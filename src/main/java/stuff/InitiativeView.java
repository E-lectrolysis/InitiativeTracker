package stuff;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

/**
 * The main viewy thingy idk
 * @author Electrolysis
 */
public class InitiativeView extends Pane {


    //buttons
    private InitiativeTracker tracker;
    private ListView<Entity> order;
    private Button addButton;
    private Button resetButton;
    private Button refreshButton;
    private Button saveButton;
    private Button removeButton;
    private Label nameLabel;
    private Label initLabel;
    private TextField addNameField;
    private TextField addInitField;
    private InfoPane infoPane;
    private Alert warning;


    /**
     * The main GUI for viewing initiatives and characters and all that
     */
    public InitiativeView() {
        this.setPrefSize(1000,800);

        tracker = new InitiativeTracker();

        //button for adding things
        addButton = new Button("Add");
        addButton.setPrefSize(70,50);
        addButton.relocate(220, 740);

        //stupid label
        nameLabel = new Label("Name:");
        nameLabel.relocate(10, 740);

        addNameField = new TextField();
        addNameField.setPrefSize(130, 20);
        addNameField.relocate(70, 740);

        initLabel = new Label("Initiative:");
        initLabel.relocate(10, 770);

        addInitField = new TextField();
        addInitField.setPrefSize(80, 20);
        addInitField.relocate(120, 770);
        addInitField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                addInitField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        //keeps the characters in order
        order = new ListView<>();
        order.setPrefSize(390, 700);
        order.relocate(10,10);

        //more rarted buttons
        removeButton = new Button("Remove");
        removeButton.setPrefSize(100,50);
        removeButton.relocate(300, 740);

        saveButton = new Button("Update");
        saveButton.setPrefSize(180,50);
        saveButton.relocate(460, 740);

        refreshButton = new Button("Refresh");
        refreshButton.setPrefSize(100,50);
        refreshButton.relocate(660, 740);

        resetButton = new Button("Reset All");
        resetButton.setPrefSize(100,50);
        resetButton.relocate(840, 740);

        infoPane = new InfoPane();
        infoPane.relocate(450,0);

        warning = new Alert(Alert.AlertType.WARNING);
        warning.setContentText("One or more fields are empty. Please make sure both are filled out.");

        getChildren().addAll(addButton, nameLabel, addNameField, initLabel, addInitField, order, removeButton, saveButton, refreshButton, resetButton, infoPane);
    }

    public void update() {
        tracker.sortInitiative();
        order.getItems().setAll((tracker.getCreatures()));
        displayStats();
    }

    public void displayStats() {
        int i = order.getSelectionModel().getSelectedIndex();
        if(i > -1) {
            infoPane.getStats(order.getItems().get(i));
        } else {
            infoPane.getStats(null);
        }
    }

    /**
     * update the stats displayed in the info pane
     */
    public void updateStats() {
        int i = order.getSelectionModel().getSelectedIndex();
        if(i > -1) {
            infoPane.setStats(tracker.getCreatures().get(i));
            update();
        }
    }

    /**
     * adds a new creature to the initiative order
     */
    public void addSomething() {
        if(!(addNameField.getText().equalsIgnoreCase("") || addInitField.getText().equalsIgnoreCase(""))) {
            tracker.getCreatures().add(new Entity(addNameField.getText().strip(), Integer.parseInt(addInitField.getText())));
            addNameField.setText("");
            addInitField.setText("");
            update();
        } else {
            warning.showAndWait();
        }
    }

    public void removeSomething() {
        int i = order.getSelectionModel().getSelectedIndex();
        if(i > -1) {
            tracker.getCreatures().remove(i);
        }
        update();
    }


    public void reset() {
        tracker = new InitiativeTracker();
        update();
    }


    public InitiativeTracker getTracker() {
        return tracker;
    }

    public ListView<Entity> getOrder() {
        return order;
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getResetButton() {
        return resetButton;
    }

    public Button getRefreshButton() {
        return refreshButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getRemoveButton() {
        return removeButton;
    }

    public Label getNameLabel() {
        return nameLabel;
    }

    public Label getInitLabel() {
        return initLabel;
    }

    public TextField getAddNameField() {
        return addNameField;
    }

    public TextField getAddInitField() {
        return addInitField;
    }

    public InfoPane getInfoPane() {
        return infoPane;
    }
}
