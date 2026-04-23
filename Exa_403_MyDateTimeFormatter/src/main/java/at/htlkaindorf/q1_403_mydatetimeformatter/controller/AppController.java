package at.htlkaindorf.q1_403_mydatetimeformatter.controller;

import at.htlkaindorf.q1_403_mydatetimeformatter.pojos.MyDateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AppController {
    @FXML
    public CheckBox cbDate;
    @FXML
    public CheckBox cbTime;
    @FXML
    private TextField tfDay;
    @FXML
    private TextField tfMonth;
    @FXML
    private TextField tfYear;
    @FXML
    private TextField tfHour;
    @FXML
    private TextField tfMinute;
    @FXML
    private TextField tfFormat;

    private Alert errorAlert;

    public void initialise() {
        errorAlert = new Alert(Alert.AlertType.ERROR);
    }

    public void onFormat(ActionEvent actionEvent) {
        initialise();
        String formatStr = "";

        try {
            if (cbDate.isSelected() && cbTime.isSelected()) {
                formatStr = "DT";

                validateInputs(tfDay, tfMonth, tfYear, tfHour, tfMinute);
                checkDate(Integer.parseInt(tfDay.getText()), Integer.parseInt(tfMonth.getText()), Integer.parseInt(tfYear.getText()));
                checkTime(Integer.parseInt(tfHour.getText()), Integer.parseInt(tfMinute.getText()));

                tfFormat.setText(MyDateTimeFormatter.format(formatStr,
                        Integer.parseInt(tfDay.getText()),
                        Integer.parseInt(tfMonth.getText()),
                        Integer.parseInt(tfYear.getText()),
                        Integer.parseInt(tfHour.getText()),
                        Integer.parseInt(tfMinute.getText())));
            } else if (cbDate.isSelected()) {
                formatStr = "D";

                validateInputs(tfDay, tfMonth, tfYear);
                ensureEmpty(tfHour, tfMinute);
                checkDate(Integer.parseInt(tfDay.getText()), Integer.parseInt(tfMonth.getText()), Integer.parseInt(tfYear.getText()));

                tfFormat.setText(MyDateTimeFormatter.format(formatStr,
                        Integer.parseInt(tfDay.getText()),
                        Integer.parseInt(tfMonth.getText()),
                        Integer.parseInt(tfYear.getText())));
            } else if (cbTime.isSelected()) {
                formatStr = "T";

                validateInputs(tfHour, tfMinute);
                ensureEmpty(tfDay, tfMonth, tfYear);
                checkTime(Integer.parseInt(tfHour.getText()), Integer.parseInt(tfMinute.getText()));

                tfFormat.setText(MyDateTimeFormatter.format(formatStr,
                        Integer.parseInt(tfHour.getText()),
                        Integer.parseInt(tfMinute.getText())));
            } else {
                errorAlert.setContentText("Please select one or more checkboxes");
                errorAlert.showAndWait();
            }
        } catch (NumberFormatException nfe) {
            errorAlert.setContentText("Please enter valid integers in all required fields.");
            errorAlert.showAndWait();
        } catch (IllegalArgumentException e) {
            errorAlert.setContentText(e.getMessage());
            errorAlert.showAndWait();
        }
    }


    private void validateInputs(TextField... fields) {
        for (TextField field : fields) {
            if (field.getText().isBlank()) {
                throw new IllegalArgumentException("All required fields must be filled");
            }
        }
    }

    private void ensureEmpty(TextField... fields) {
        for (TextField field : fields) {
            if (!field.getText().isBlank()) {
                throw new IllegalArgumentException("Unnecessary fields must be left empty");
            }
        }
    }

    private void checkDate(int day, int month, int year) throws IllegalArgumentException {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month == 2 && isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month has to be correct");
        }

        if (day < 1 || day > daysInMonth[month - 1]) {
            throw new IllegalArgumentException("Day has to be correct");
        }

        if (year < 0) {
            throw new IllegalArgumentException("Year has to be correct");
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private void checkTime(int hour, int minute) throws IllegalArgumentException {
        if (hour < 0 || hour > 24) {
            throw new IllegalArgumentException("Hour has to be correct");
        }

        if (minute < 0 || minute > 60) {
            throw new IllegalArgumentException("Minute has to be correct");
        }
    }
}
