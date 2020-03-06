package stuff;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * the class for the pane displaying all the info
 * @author Electrolysis
 */
public class InfoPane extends Pane {
    private Label nameLabel, initiativeLabel, notesLabel, hpLabel, acLabel;
    private TextField nameField, initField, hpField,  acField;
    private CheckBox reactionBox;
    private TextArea notes;
    private Entity zeroEntity;

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
        initField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                initField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        hpLabel = new Label("Hit Points:");
        hpLabel.relocate(10,50);

        hpField = new TextField();
        hpField.setPrefWidth(90);
        hpField.relocate(70, 50);
        hpField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                hpField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        acLabel = new Label("AC:");
        acLabel.relocate(270, 50);

        acField = new TextField();
        acField.setPrefWidth(50);
        acField.relocate(300,50);
        acField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                acField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        reactionBox = new CheckBox("Reaction");
        reactionBox.relocate(400,50);

        notesLabel = new Label("Notes, conditions, additional properties, whatever:");
        notesLabel.relocate(10, 125);

        notes = new TextArea();
        notes.setPrefSize(480, 560);
        notes.relocate(10, 150);

        zeroEntity = new Entity("", 0);
        zeroEntity.setReaction(false);


        //why do i have to do this
        getChildren().addAll(nameLabel, nameField, initiativeLabel, initField, hpLabel, hpField, acLabel, acField, reactionBox, notesLabel, notes);
    }

    public void getStats(Entity e) {
        if(e == null) {
            e = zeroEntity;
        }
        nameField.setText(e.getName());
        initField.setText(""+ e.getInitiative());
        hpField.setText(e.getHp()+"");
        acField.setText(e.getAc()+"");
        reactionBox.setSelected(e.isReaction());
        notes.setText(e.getNotes());
    }

    public void setStats(Entity e) {
        if(e != null) {
            e.setName(nameField.getText().strip());
            try {
                e.setInitiative(Integer.parseInt(initField.getText()));
            } catch(NumberFormatException n) {
                e.setInitiative(0);
            }
            try {
                e.setHp(Integer.parseInt(hpField.getText()));
            } catch(NumberFormatException n) {
                e.setHp(0);
            }

            try {
                e.setAc(Integer.parseInt(acField.getText()));
            } catch(NumberFormatException n) {
                e.setAc(0);
            }
            e.setReaction(reactionBox.isSelected());
            e.setNotes(notes.getText());
        }
    }







}
