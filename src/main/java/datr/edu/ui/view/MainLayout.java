package datr.edu.ui.view;

import datr.edu.*;
import datr.edu.ui.util.DatrCodeAreaController;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import org.fxmisc.richtext.CodeArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.javafx.FXMLController;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Controller for the main layout components.
 */
@FXMLController
public class MainLayout implements FXMLController.RootNodeAware<BorderPane> {

    private BorderPane rootNode;

    @FXML
    private CodeArea theoryCode;

    @FXML
    private TableView<DatrParser.ErrorListener.Error> theoryErrors;

    @FXML
    private CodeArea queryCode;

    @FXML
    private TableView<DatrParser.ErrorListener.Error> queryErrors;

    @FXML
    private Button querySubmit;

    @FXML
    private TextArea log;

    private final ExecutorService executor;
    private final DatrParser parser;

    private DatrCodeAreaController<DatrTheory> theoryController;
    private DatrCodeAreaController<DatrQuery> queryController;

    @Autowired
    public MainLayout(ExecutorService executor, DatrParser parser) {
        this.executor = executor;
        this.parser = parser;
    }

    @Override
    public void setRootNode(BorderPane rootNode) {
        this.rootNode = rootNode;
    }

    @Override
    public BorderPane getRootNode() {
        return rootNode;
    }

    @PostConstruct
    private void initialize() {
        theoryController = new DatrCodeAreaController<>(theoryCode, executor, parser::parseTheory).withLineNumbers();
        queryController = new DatrCodeAreaController<>(queryCode, executor, parser::parseQuery);

        initializeErrorTable(theoryErrors, theoryController);
        initializeErrorTable(queryErrors, queryController);

        querySubmit.disableProperty().bind(Bindings.not(Bindings.and(theoryController.valid(), queryController.valid())));
        querySubmit.onActionProperty().set(e -> {
            evaluate();
        });
    }

    private void evaluate() {
        DatrQueryEvaluator evaluator = new DatrQueryEvaluator(
                theoryController.result().getValue().result.get(),
                queryController.result().getValue().result.get());

        log.clear();
        evaluator.setListener(evaluationListener);
        try {
            evaluator.evaluate();
        } catch (DatrQueryEvaluator.DatrQueryEvaluationException e) {
            append("\n\nERROR: " + e.getMessage());
        }
    }

    private void initializeErrorTable(TableView<DatrParser.ErrorListener.Error> tableView, DatrCodeAreaController<?> controller) {
        tableView.setRowFactory(tv -> {
            TableRow<DatrParser.ErrorListener.Error> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY && event.getClickCount() == 2) {
                    controller.showError(row.getItem());
                }
            });
            return row ;
        });

        ObservableList<TableColumn<DatrParser.ErrorListener.Error, ?>> columns = tableView.getColumns();
        TableColumn<DatrParser.ErrorListener.Error, Object> col;
        col = initializeErrorTableColumn(columns, "Row", e -> new SimpleIntegerProperty(e.row));
        col.setMinWidth(50);
        col.setPrefWidth(75);
        col.setMaxWidth(100);
        col = initializeErrorTableColumn(columns, "Col", e -> new SimpleIntegerProperty(e.col));
        col.setMinWidth(50);
        col.setPrefWidth(75);
        col.setMaxWidth(100);
        col = initializeErrorTableColumn(columns, "Error", e -> new SimpleStringProperty(e.msg));

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setMaxHeight(100);
        tableView.setItems(controller.errors());
    }

    private TableColumn<DatrParser.ErrorListener.Error, Object> initializeErrorTableColumn(ObservableList<TableColumn<DatrParser.ErrorListener.Error, ?>> columns, String title, Function<DatrParser.ErrorListener.Error, ObservableValue> mapper) {
        TableColumn<DatrParser.ErrorListener.Error, Object> column = new TableColumn<>(title);
        column.setCellValueFactory(data -> mapper.apply(data.getValue()));
        columns.add(column);
        return column;
    }

    private void append(String string) {
        log.setText(log.getText() + string);
    }

    DatrQueryEvaluator.DatrQueryEvaluationListener evaluationListener = new DatrQueryEvaluator.DatrQueryEvaluationListener() {

        @Override
        public void beforeEquation(DatrEquation equation, DatrQueryEnvironment.Context context, DatrQueryEnvironment environment) {
            StringBuilder builder = new StringBuilder();
            String extension = environment.extensions.peek().stream().map(Object::toString).collect(Collectors.joining(" "));
            builder.append("\n" + getIndent(environment) + context.node + ":" + context.path);
            builder.append(" => Matched " + context.node + ":" + equation.lhs);
            if (extension.length() > 0) {
                builder.append(" +<" + extension + ">");
            }
            append(builder.toString());
        }

        @Override
        public void afterEquation(String result, DatrEquation equation, DatrQueryEnvironment.Context context, DatrQueryEnvironment environment) {
            StringBuilder builder = new StringBuilder();
            builder.append("\n" + getIndent(environment) + "= " + result);
            append(builder.toString());
        }

        private String getIndent(DatrQueryEnvironment environment) {
            return environment.extensions.stream().map(ext -> "  ").collect(Collectors.joining());
        }

    };

}
