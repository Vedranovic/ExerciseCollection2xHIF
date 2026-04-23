package at.htlkaindorf.exa_501_carfactoryv2.controller;

import at.htlkaindorf.exa_501_carfactoryv2.exceptions.DuplicateCarsExceptions;
import at.htlkaindorf.exa_501_carfactoryv2.pojos.Car;
import javafx.event.ActionEvent;
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
    private Button btAdd;
    @FXML
    private Button btChange;
    @FXML
    private Button btClear;
    @FXML
    private ListView<Car> lvOutput;

    private DataController dataController;
    private boolean loaded = false;
    private Alert alert;

    public void initialize() {
        dataController = new DataController();
        alert = new Alert(Alert.AlertType.WARNING);

        btAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onAdd();
            }
        });

        btChange.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onChange();
            }
        });

        btClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onClear();
            }
        });
    }

    private void onAdd() {
        if (tfBrand.getText().isBlank() || tfModel.getText().isBlank() || tfPrice.getText().isBlank() || tfReleaseDate.getText().isBlank()) {
            alert.setContentText("Please fill out every field!");
            alert.showAndWait();
        } else {
            try {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");

                Car car = new Car(
                        tfBrand.getText(),
                        tfModel.getText(),
                        Double.parseDouble(tfPrice.getText()),
                        LocalDate.parse(tfReleaseDate.getText(), dtf)
                );

                dataController.createCar(car);
                dataController.saveCars();
                lvOutput.setItems(dataController.getCars());
            } catch (NumberFormatException nfe) {
                alert.setContentText("The price value is not valid!");
                alert.showAndWait();
            } catch (DateTimeParseException dtpe) {
                alert.setContentText("The date format is not correct!");
                alert.showAndWait();
            } catch (DuplicateCarsExceptions dce) {
                alert.setContentText(dce.getMessage());
                alert.showAndWait();
            }
        }
    }

    private void onChange() {
        TextInputDialog secondInput = new TextInputDialog();
        secondInput.setTitle("Input");
        secondInput.setHeaderText("Input");
        secondInput.setContentText("Please enter the new price of the car:");
        Optional<String> secondResult = secondInput.showAndWait();

        if (secondResult.isPresent()) {
            try {
                dataController.changePriceOfCars(lvOutput.getSelectionModel().getSelectedIndex(), Double.parseDouble(secondResult.get()));
                lvOutput.setItems(dataController.getCars());
            } catch (NumberFormatException nfe) {
                alert.setContentText("Please enter numeric values only!");
                alert.showAndWait();
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                alert.setContentText(aioobe.getMessage());
                alert.showAndWait();
            }
        }

        dataController.saveCars();
    }

    private void onClear() {
        tfBrand.setText("");
        tfModel.setText("");
        tfPrice.setText("");
        tfReleaseDate.setText("");
    }

    public void onLoad(ActionEvent event) {
        dataController.loadCars();

        lvOutput.setItems(dataController.getCars());
    }

    public void onDelete(ActionEvent event) {
        int index = lvOutput.getSelectionModel().getSelectedIndex();

        dataController.deleteCar(index);
    }
}