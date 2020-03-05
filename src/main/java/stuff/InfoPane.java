package stuff;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * the class for the pane displaying all the info
 * @author Electrolysis
 */
public class InfoPane extends Pane {
    private Label nameLabel, initiativeLabel, notesLabel, hpLabel, acLabel, reactionLabel;
    private TextField nameField, initField, hpField,  reactionField, acField;
    private TextArea notes;

    /**
     * the pane for displaying all the info
     */
    public InfoPane() {

        //yes
        this.setPrefSize(500,700);


        //all the ugly fields and stuff go here
        nameLabel = new Label("Name:");
        nameLabel.relocate(10,10);

        nameField = new TextField();
        nameField.setPrefWidth(300);
        nameField.relocate(50,10);

        initiativeLabel = new Label("Initiative:");
        initiativeLabel.relocate(400, 10);

        initField = new TextField();
        initField.setPrefWidth(40);
        initField.relocate(460, 10);

        hpLabel = new Label("Hit Points:");
        hpLabel.relocate(10,50);

        hpField = new TextField();
        hpField.setPrefWidth(90);
        hpField.relocate(70, 50);

        acLabel = new Label("AC:");
        



        //why do i have to do this
        getChildren().addAll(nameLabel, nameField, initiativeLabel, initField, hpLabel, hpField);
    }

    public void updateStats(Entity e) {

    }
}
