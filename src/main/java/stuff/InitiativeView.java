package stuff;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * The main viewy thingy idk
 * @author Electrolysis
 */
public class InitiativeView extends Pane {


    //buttons
    private InitiativeTracker tracker;
    private ListView<Character> order;
    private Button addButton;
    private Button resetButton;
    private Button refreshButton;
    private Button sortButton;
    private Button saveButton;
    private Button removeButton;
    private Label nameLabel;
    private Label initLabel;
    private TextField addNameField;
    private TextField addInitField;


    /**
     * The main GUI for viewing initiatives and characters and all that
     */
    public InitiativeView() {
        this.setPrefSize(1000,800);

        //button for adding things
        addButton = new Button("Add");
        addButton.setPrefSize(70,50);
        addButton.relocate(220, 740);


        //stupid label
        nameLabel = new Label("Name:");
        nameLabel.relocate(10, 770);

        addNameField = new TextField();
        addNameField.setPrefSize(150, 20);
        addNameField.relocate(50, 770);

        initLabel = new Label("Initiative:");
        initLabel.relocate(10, 740);

        addInitField = new TextField();
        addInitField.setPrefSize(100, 20);
        addInitField.relocate(100, 740);

        //keeps the characters in order
        order = new ListView<>();
        order.setPrefSize(390, 700);
        order.relocate(10,10);

        //more rarted buttons
        removeButton = new Button("Remove");
        removeButton.setPrefSize(100,50);
        removeButton.relocate(300, 740);

        saveButton = new Button("Update");
        saveButton.setPrefSize(200,50);
        saveButton.relocate(450, 740);

        refreshButton = new Button("Refresh");
        refreshButton.setPrefSize(100,50);
        refreshButton.relocate(660, 740);

        resetButton = new Button("Reset");
        resetButton.setPrefSize(100,50);
        resetButton.relocate(890, 740);

        InfoPane info = new InfoPane();
        info.relocate(450,0);

        getChildren().addAll(addButton, nameLabel, addNameField, initLabel, addInitField, order, removeButton, saveButton, refreshButton, resetButton, info);
    }



}
