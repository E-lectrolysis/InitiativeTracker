package stuff;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class InitiativeView extends Pane {

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

    public InitiativeView() {
        this.setPrefSize(1000,800);

        addButton = new Button("Add");
        addButton.setPrefSize(70,50);
        addButton.relocate(220, 740);

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

        order = new ListView<>();
        order.setPrefSize(300, 700);
        order.relocate(10,10);
        


        getChildren().addAll(addButton, nameLabel, addNameField, initLabel, addInitField, order);
    }



}
