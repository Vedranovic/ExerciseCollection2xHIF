package at.htlkaindorf.exa_503_namelist.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AppController {
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfShowName;
    @FXML
    private TextField tfShowPosition;
    @FXML
    private Button btInsert;
    @FXML
    private Button btDelete;
    @FXML
    private Button btUp;
    @FXML
    private Button btDown;

    private int currentPosition;
    private DataController dataController;
    private Alert errorAlert;

    public void initialize() {
        currentPosition = 1;
        dataController = new DataController();
        errorAlert = new Alert(Alert.AlertType.ERROR);
        updateList();

        btUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onUp();
            }
        });
        btDown.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onDown();
            }
        });
        btInsert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onInsert();
            }
        });
        btDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onDelete();
            }
        });
    }

    private void onUp() {
        if (!(currentPosition >= dataController.getNames().size())) {
            currentPosition++;
            updateList();
        }
    }

    private void onDown() {
        if (currentPosition > 1) {
            currentPosition--;
            updateList();
        }
    }

    private void onInsert() {
        if (tfName.getText().isEmpty()) {
            errorAlert.setContentText("Please insert a name!");
            errorAlert.showAndWait();
        } else {
            dataController.addName(tfName.getText());

            if (dataController.getNames().size() - 1 == currentPosition && dataController.getNames().size() == 1) {
                currentPosition++;
            }

            updateList();
        }
    }

    private void onDelete() {
        if (dataController.delete(tfName.getText())) {
            dataController.getNames().remove(tfName.getText());

            if (dataController.getNames().size() == currentPosition - 1) {
                currentPosition--;
            }

            updateList();
        } else {
            errorAlert.setContentText("The name did not exist!");
            errorAlert.showAndWait();
        }
    }

    private void updateList() {
        if (dataController.getNames().isEmpty()) {
            tfShowName.setText("");
            tfShowPosition.setText("0 of 0");
        } else {
            tfShowName.setText(dataController.getElementAtIndex(currentPosition - 1));
            tfShowPosition.setText(currentPosition + " of " + dataController.getNames().size());
        }
    }
}