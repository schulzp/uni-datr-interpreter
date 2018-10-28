package datr.edu.ui.util;

import datr.edu.DatrParser;
import datr.edu.DatrParserListener;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.control.Label;
import javafx.stage.Popup;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/**
 * Created by peter on 10/12/16.
 */
public class DatrCodeAreaController<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatrCodeAreaController.class);

    private final CodeArea codeArea;

    private final ExecutorService executor;
    private final Function<String, DatrParser.Result<T>> parser;

    private final ObservableList<DatrParser.ErrorListener.Error> errors = FXCollections.observableList(new LinkedList<>());

    private final SimpleBooleanProperty valid = new SimpleBooleanProperty();

    private final Popup popup = new Popup();

    private final Label popupMessage = new Label();

    private final SimpleObjectProperty<DatrParser.Result<T>> result = new SimpleObjectProperty<>();

    public DatrCodeAreaController(CodeArea codeArea, ExecutorService executor, Function<String, DatrParser.Result<T>> parser) {

        this.codeArea = codeArea;
        this.executor = executor;
        this.parser = parser;

        this.popup.getContent().add(popupMessage);

        codeArea.styleProperty().set("-fx-highlight-fill: red;");

        codeArea.richChanges()
                .filter(ch -> !ch.getInserted().equals(ch.getRemoved())) // XXX
                .successionEnds(Duration.ofMillis(500))
                .supplyTask(this::computeHighlightingAsync)
                .awaitLatest(codeArea.richChanges())
                .filterMap(t -> { if(t.isSuccess()) {
                        return Optional.of(t.get());
                    } else {
                        LOGGER.error("Failed to update highlighting", t.getFailure());
                        return Optional.empty();
                    }
                })
                .subscribe(this::applyHighlighting);

        this.result.addListener((v, o, n) -> {
            errors.clear();
            errors.addAll(n.errors);
            valid.set(errors.isEmpty() && n.result.isPresent());
        });
    }

    public DatrCodeAreaController<T> withLineNumbers() {
        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
        return this;
    }

    public ObservableList<DatrParser.ErrorListener.Error> errors() {
        return errors;
    }

    public ObservableBooleanValue valid() {
        return valid;
    }

    public ObservableValue<DatrParser.Result<T>> result() {
        return result;
    }

    private void applyHighlighting(StyleSpans<Collection<String>> highlighting) {
        codeArea.setStyleSpans(0, highlighting);
    }

    private StyleSpans<Collection<String>> computeHighlighting(List<DatrParserListener.Token> tokens, List<DatrParser.ErrorListener.Error> errors) {
        StyleSpansBuilder<Collection<String>> builder = new StyleSpansBuilder<>();
        AtomicInteger offset = new AtomicInteger(0);
        if (tokens.isEmpty()) {
            builder.add(Collections.emptyList(), codeArea.getLength());
        } else {
            LOGGER.trace(tokens.toString());
            tokens.stream().forEach(token -> {
                if (token.start - offset.get() > 0) {
                    builder.add(getTokenTypes(token, false), token.start - offset.get());
                    LOGGER.trace((token.start - offset.get()) + ", ");
                }
                builder.add(getTokenTypes(token, true), token.stop - token.start);
                LOGGER.trace(token.start + "-" + token.stop + "; ");
                offset.set(token.stop);
            });
        }
        return builder
                .create();
    }

    private Set<String> getTokenTypes(DatrParserListener.Token token, boolean inclusive) {
        HashSet<String> types = new HashSet<>();
        if (!inclusive) {
            token = token.parent;
        }
        while (token != null) {
            types.add(token.type.name().toLowerCase());
            token = token.parent;
        }
        System.out.println(types);
        return types;
    }

    private Task<StyleSpans<Collection<String>>> computeHighlightingAsync() {
        String text = codeArea.getText();
        Task<StyleSpans<Collection<String>>> task = new Task<StyleSpans<Collection<String>>>() {
            @Override
            protected StyleSpans<Collection<String>> call() throws Exception {
                DatrParser.Result<T> result = parser.apply(text);
                DatrCodeAreaController.this.result.set(result);
                return computeHighlighting(result.tokens, result.errors);
            }
        };
        executor.execute(task);
        return task;
    }


    public void showError(DatrParser.ErrorListener.Error error) {
        popupMessage.setText(error.msg);

        codeArea.position(error.row, error.col);

        // Simply log them, since popup support has been removed from RichTextFX
        LOGGER.debug("Error: " + error.msg + " at " + error.row + "," + error.col);

        popupMessage.setVisible(true);
    }

}
