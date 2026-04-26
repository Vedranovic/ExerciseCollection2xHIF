package at.htlkaindorf.exa_408_airportmanagement.controller;

import at.htlkaindorf.exa_408_airportmanagement.pojos.Passenger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class AppController {
    @FXML
    public TextField tfFirstName;
    @FXML
    public TextField tfLastName;
    @FXML
    public TextField tfBirthdate;
    @FXML
    public RadioButton rbPassport;
    @FXML
    public RadioButton rdIDCard;
    @FXML
    public Label lbIdOrPassport;
    @FXML
    public TextField tfVerificationForm;
    @FXML
    public TextField tfBaggageWeight;
    @FXML
    public TextField tfAdditionalPrice;
    @FXML
    public Button btAdd;
    @FXML
    public Button btClear;
    @FXML
    public TextArea taOutput;

    private Passenger[] passengers;
    private int numOfPassengers;
    private Alert errorAlert;
    private boolean isPassport;

    public void initialize() {
        passengers = new Passenger[72];
        numOfPassengers = 0;
        errorAlert = new Alert(Alert.AlertType.ERROR);
        isPassport = true;
    }

    public void onRbChanged(ActionEvent actionEvent) {
        if (rbPassport.isSelected()) {
            lbIdOrPassport.setText("Passport: ");
            isPassport = true;
        } else {
            lbIdOrPassport.setText("ID card: ");
            isPassport = false;
        }
    }

    public void onCheckAdd(KeyEvent keyEvent) {
        if (!(tfFirstName.getText().isEmpty() || tfLastName.getText().isEmpty() || tfBirthdate.getText().isEmpty() || tfVerificationForm.getText().isEmpty())) {
            checkId();
        }
    }

    private void checkId() {
        String id = tfVerificationForm.getText();

        if (isPassport) {
            btAdd.setDisable(id.length() != 7 || !id.matches("[A-Z]\\d{6}"));
        } else {
            if (id.length() == 12 && id.matches("[A-Z]\\d{11}")) {
                int checkSum = id.toCharArray()[8] - '0';
                int sum = (id.toCharArray()[0] - '7') * 2;

                for (int i = 3; i < 10; i++) {
                    sum += Integer.parseInt(String.valueOf(id.toCharArray()[i - 2])) * i;
                }

                sum %= 11;
                int result = 11 - sum;

                if (result == 10 || result == 11) {
                    btAdd.setDisable(checkSum != 0);
                } else {
                    btAdd.setDisable(result != checkSum);
                }
            } else {
                btAdd.setDisable(true);
            }
        }
    }

    public void onCalcBaggageWeight(KeyEvent keyEvent) {
        if (!tfBaggageWeight.getText().isEmpty()) {
            try {
                float price = Passenger.calculatePrice(Float.parseFloat(tfBaggageWeight.getText()));
                tfAdditionalPrice.setText(String.format(Locale.GERMAN, "%.2f €", price));
            } catch (NumberFormatException nfe) {
                errorAlert.setContentText("Enter a valid baggage weight number");
                errorAlert.showAndWait();
            }
        }
    }

    public void onClear(ActionEvent actionEvent) {
        tfFirstName.setText("");
        tfLastName.setText("");
        tfBirthdate.setText("");
        tfVerificationForm.setText("");
        tfBaggageWeight.setText("");
        tfAdditionalPrice.setText("");
        btAdd.setDisable(true);
    }

    public void onAdd(ActionEvent actionEvent) {
        try {
            passengers[numOfPassengers] = new Passenger(
                    tfFirstName.getText(),
                    tfLastName.getText(),
                    LocalDate.parse(tfBirthdate.getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    tfVerificationForm.getText(),
                    tfBaggageWeight.getText().isEmpty() ? 0f : Float.parseFloat(tfBaggageWeight.getText())
            );
            taOutput.appendText(passengers[numOfPassengers].toString());
            numOfPassengers++;
        } catch (DateTimeParseException dtpe) {
            errorAlert.setContentText("Please use the correct format for the birthdate!");
            errorAlert.showAndWait();
        } catch (NumberFormatException nfe) {
            errorAlert.setContentText("Please enter only correct values!");
            errorAlert.showAndWait();
        }
    }
}