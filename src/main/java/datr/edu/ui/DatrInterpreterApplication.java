package datr.edu.ui;

import datr.edu.ui.scene.SceneHolder;
import datr.edu.ui.view.MainLayout;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.javafx.SpringFXApplication;

/**
 * Main entry point.
 */
public class DatrInterpreterApplication extends SpringFXApplication {

    @Autowired
    private MainLayout mainLayout;

    @Autowired
    private SceneHolder sceneHolder;

    public DatrInterpreterApplication() {
        super(DatrInterpreterApplicationConfiguration.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.sceneProperty().addListener((observable, oldValue, newValue) -> sceneHolder.setScene(newValue));

        Scene scene = new Scene(mainLayout.getRootNode());

        scene.getStylesheets().add(DatrInterpreterApplication.class.getResource("/datr.css").toExternalForm());
        stage.setTitle("DATR Interpreter");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] arguments) {
        launch(DatrInterpreterApplication.class, arguments);
    }

}
