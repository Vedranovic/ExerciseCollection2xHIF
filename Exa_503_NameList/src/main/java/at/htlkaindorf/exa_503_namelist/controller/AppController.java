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
        currentPosition = 0;
        dataController = new DataController();
        errorAlert = new Alert(Alert.AlertType.ERROR);

        updateList();
        btInsert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onInsert();
                updateList();
            }
        });

        btDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onDelete();
                updateList();
            }
        });

        btUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onUp();
                updateList();
            }
        });

        btDown.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onDown();
                updateList();
            }
        });
    }

    private void onUp() {
        if (currentPosition < dataController.getNames().size() - 1) {
            currentPosition++;
            tfShowName.setText(dataController.getNames().get(currentPosition));
        }
    }

    private void onDown() {
        if (currentPosition > 0) {
            currentPosition--;
            tfShowName.setText(dataController.getNames().get(currentPosition));
        }
    }

    private void onInsert() {
        if (tfName.getText().isBlank()) {
            errorAlert.setContentText("Please insert a name!");
            errorAlert.showAndWait();
        } else {
            dataController.addName(tfName.getText());
        }
    }

    private void onDelete() {
        String name = tfName.getText();
        boolean isInList = false;

        for (int i = 0; i < dataController.getNames().size(); i++) {
            if (name.equals(dataController.getNames().get(i))) {
                isInList = true;
                break;
            }
        }

        if (isInList) {
            dataController.getNames().remove(name);
            currentPosition--;
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
            tfShowName.setText(dataController.getNames().get(currentPosition));
            tfShowPosition.setText((currentPosition + 1) + " of " + dataController.getNames().size());
        }
    }
}