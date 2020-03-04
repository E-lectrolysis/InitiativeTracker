package stuff;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Initiative Tracking App
 * @author Electrolysis
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {


        InitiativeView view = new InitiativeView();
        Scene scene = new Scene(view);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}