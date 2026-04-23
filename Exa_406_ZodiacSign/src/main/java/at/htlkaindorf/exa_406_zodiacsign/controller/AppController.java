package at.htlkaindorf.exa_406_zodiacsign.controller;

import at.htlkaindorf.exa_406_zodiacsign.pojos.Sign;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AppController {
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfBirthdate;
    @FXML
    private TextField tfBirthtime;
    @FXML
    private TextField tfLatitude;
    @FXML
    private TextField tfLongitude;
    @FXML
    private Label lbResult;
    @FXML
    private Label lbAge;
    @FXML
    private Label lbAgeInDays;
    @FXML
    private RadioButton rbZodiacSign;
    @FXML
    private RadioButton rbAscendant;

    private SignManager manager;
    private Alert errorAlert;
    private int index;

    public void initialize() {
        manager = new SignManager();
        errorAlert = new Alert(Alert.AlertType.ERROR);
        index = 0;
    }

    public void onReset(ActionEvent actionEvent) {
        tfName.setText("");
        tfBirthdate.setText("");
        tfBirthtime.setText("");
        tfLatitude.setText("");
        tfLongitude.setText("");
    }

    private String checkName() throws Exception {
        String name = tfName.getText();

        if (name.isBlank() || !name.matches("[a-zA-Z ]+")) {
            throw new Exception("Please enter a valid name!");
        }

        return name;
    }

    private LocalDate checkBirthDate() throws Exception {
        String birthdate = tfBirthdate.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        if (birthdate.isBlank()) {
            throw new Exception("Please enter a birthdate");
        }

        try {
            return LocalDate.parse(birthdate, formatter);
        } catch (DateTimeParseException dtpe) {
            throw new Exception("Please enter a valid birthdate");
        }
    }

    private LocalTime checkBirthTime() throws Exception {
        String birthTime = tfBirthtime.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm");

        if (birthTime.isBlank()) {
            throw new Exception("Please enter a birthtime");
        }

        try {
            return LocalTime.parse(birthTime, formatter);
        } catch (DateTimeParseException dtpe) {
            throw new Exception("Please enter a valid birthtime");
        }
    }

    private String checkLatitude() throws Exception {
        String latitude = tfLatitude.getText();

        if (latitude.isBlank() || !latitude.matches("[0-9.]+")) {
            throw new Exception("Please enter a valid latitude!");
        }

        return latitude;
    }

    private String checkLongitude() throws Exception {
        String longitude = tfLongitude.getText();

        if (longitude.isBlank() || !longitude.matches("[0-9.]+")) {
            throw new Exception("Please enter a valid longitude!");
        }

        return longitude;
    }

    public void onCalc(ActionEvent actionEvent) {
        try {
            String name = checkName();
            LocalDate birthDate = checkBirthDate();

            if (rbZodiacSign.isSelected()) {

                manager.addSign(new Sign(birthDate));
                lbResult.setText("Your zodiac sign is " + manager.getSigns()[index].calcZodiac().toUpperCase() + "!");
                lbAge.setText(name + ", you are " + manager.getSigns()[index].getAge() + " years old.");
                lbAgeInDays.setText("This is " + manager.getSigns()[index].getDays() + " days!");
                lbAgeInDays.setStyle("-fx-text-fill: red;");
                index++;
            }
            if (rbAscendant.isSelected()) {
                LocalTime birthTime = checkBirthTime();
                double latitude = Double.parseDouble(checkLatitude());
                double longitude = Double.parseDouble(checkLongitude());

                manager.addSign(new Sign(birthDate, birthTime, longitude, latitude));
                lbResult.setText("Your ascendant sign is " + manager.getSigns()[index].calcAscendant().toUpperCase());
                lbAge.setText(name + ", you are " + manager.getSigns()[index].getAge() + " years old.");
                lbAgeInDays.setText("This is " + manager.getSigns()[index].getDays() + " days!");
                lbAgeInDays.setStyle("-fx-text-fill: red;");
                index++;
            }

        } catch (Exception e) {
            errorAlert.setContentText(e.getMessage());
            errorAlert.showAndWait();
        }
    }
}
