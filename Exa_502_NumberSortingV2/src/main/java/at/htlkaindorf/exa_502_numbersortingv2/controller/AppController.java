package at.htlkaindorf.exa_502_numbersortingv2.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Time;

public class AppController {
    @FXML
    public TextField tfElements;
    @FXML
    public RadioButton rbSelectionSort;
    @FXML
    public RadioButton rbBubbleSort;
    @FXML
    public RadioButton rbInsertionSort;
    @FXML
    public Label lbMs;
    @FXML
    public Button btGenerate;
    @FXML
    public Button btSort;
    @FXML
    public TextArea taOutput;

    private DataController dataController;
    private Alert errorAlert;

    public void initialize() {
        dataController = new DataController();
        errorAlert = new Alert(Alert.AlertType.ERROR);

        btSort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onSort(actionEvent);
            }
        });
        btGenerate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onGenerate(actionEvent);
            }
        });
    }

    private void onSort(Event event) {
        long startTime = System.currentTimeMillis();

        if (rbSelectionSort.isSelected()) {
            dataController.selectionSort();
            taOutput.setText(dataController.toString());
        }
        if (rbBubbleSort.isSelected()) {
            dataController.bubbleSort();
            taOutput.setText(dataController.toString());
        }
        if (rbInsertionSort.isSelected()) {
            dataController.insertionSort();
            taOutput.setText(dataController.toString());
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        lbMs.setText("Sorted in " + duration + "ms!");
    }

    private void onGenerate(Event event) {
        if (tfElements.getText().isBlank()) {
            errorAlert.setContentText("Please enter a valid number!");
            errorAlert.showAndWait();
        } else {
            try {
                dataController.generateNumbers(Integer.parseInt(tfElements.getText()));
                taOutput.appendText(dataController.toString());
            } catch (NumberFormatException nfe) {
                errorAlert.setContentText("Enter only numbers!");
            }
        }
    }
}