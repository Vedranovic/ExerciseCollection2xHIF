package at.htlkaindorf.exa_501_carfactoryv2.controller;

import at.htlkaindorf.exa_501_carfactoryv2.pojos.Car;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class AppController {
    @FXML
    private TextField tfBrand;
    @FXML
    private TextField tfModel;
    @FXML
    private TextField tfPrice;
    @FXML
    private TextField tfReleaseDate;
    @FXML
    private Button btCreate;
    @FXML
    private Button btChange;
    @FXML
    private Button btClear;
    @FXML
    private TextArea taOutput;

    private DataController dataController;
    private Alert alert;

    public void initialize() {
        dataController = new DataController();
        alert = new Alert(Alert.AlertType.WARNING);

        btCreate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onCreate(actionEvent);
            }
        });
        btChange.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onChange(actionEvent);
            }
        });
        btClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onClear(actionEvent);
            }
        });
    }

    private void onChange(Event event) {
        TextInputDialog firstInput = new TextInputDialog();
        firstInput.setTitle("Input");
        firstInput.setHeaderText("Input");
        firstInput.setContentText("Please enter the id of the car you want to change:");
        Optional<String> firstResult = firstInput.showAndWait();

        if (firstResult.isPresent()) {
            TextInputDialog secondInput = new TextInputDialog();
            secondInput.setTitle("Input");
            secondInput.setHeaderText("Input");
            secondInput.setContentText("Please enter the new price of the car:");
            Optional<String> secondResult = secondInput.showAndWait();

            if (secondResult.isPresent()) {
                try {
                    dataController.changePriceOfCars(Integer.parseInt(firstResult.get()) - 1, Double.parseDouble(secondResult.get()));
                    taOutput.setText(dataController.printCars());
                } catch (NumberFormatException nfe) {
                    alert.setContentText("Please enter numeric values only!");
                    alert.showAndWait();
                } catch (ArrayIndexOutOfBoundsException aioobe) {
                    alert.setContentText(aioobe.getMessage());
                    alert.showAndWait();
                }
            }
        }
    }

    private void onClear(Event event) {
        tfBrand.setText("");
        tfModel.setText("");
        tfPrice.setText("");
        tfReleaseDate.setText("");
    }

    private void onCreate(Event event) {
        if (tfBrand.getText().isBlank() || tfModel.getText().isBlank() || tfPrice.getText().isBlank() || tfReleaseDate.getText().isBlank()) {
            alert.setContentText("Please fill in all fields!");
            alert.showAndWait();
        } else {
            try {
                String dateString = tfReleaseDate.getText();
                DateTimeFormatter inputForm = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate releaseDate = LocalDate.parse(dateString, inputForm);
                Car car = new Car(
                        tfBrand.getText(),
                        tfModel.getText(),
                        Double.parseDouble(tfPrice.getText()),
                        releaseDate
                );

                dataController.createCar(car);
                showData();
            } catch (NumberFormatException nfe) {
                alert.setContentText("The price value is not valid!");
                alert.showAndWait();
            } catch (DateTimeParseException dtpe) {
                alert.setContentText("The date format is not correct!");
                alert.showAndWait();
            }
        }
    }

    private void showData() {
        taOutput.setText(dataController.printCars());
    }
}