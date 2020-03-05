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


    /**
     * The method which starts the program i guess
     * @param stage idfk man it's a stage, it's kinda just goes there or something
     */
    @Override
    public void start(Stage stage) {


        InitiativeView view = new InitiativeView();

        view.getAddButton().setOnAction(actionEvent -> view.addSomething());
        view.getRemoveButton().setOnAction(actionEvent -> view.removeSomething());
        view.getOrder().setOnMouseReleased(mouseEvent -> view.displayStats());

        Scene scene = new Scene(view);
        stage.setScene(scene);
        stage.setTitle("Electrolysis's Initiative Tracker");
        stage.show();
    }

    /**
     * the main method
     * @param args i think this is java launch args or something?
     */
    public static void main(String[] args) {
        launch();
    }

}