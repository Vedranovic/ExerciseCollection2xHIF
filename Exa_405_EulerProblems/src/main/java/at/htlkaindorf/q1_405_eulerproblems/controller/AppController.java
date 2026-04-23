package at.htlkaindorf.q1_405_eulerproblems.controller;

import at.htlkaindorf.q1_405_eulerproblems.pojos.Euler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

public class AppController {
    @FXML
    private TextArea taResults;
    @FXML
    private CheckBox cbProblem1;
    @FXML
    private CheckBox cbProblem9;
    @FXML
    private CheckBox cbProblem13;
    @FXML
    private CheckBox cbProblem20;
    @FXML
    private CheckBox cbProblem48;

    public void onCalculate(ActionEvent actionEvent) {
        Euler euler = new Euler();

        if (cbProblem1.isSelected() || cbProblem9.isSelected() || cbProblem13.isSelected() || cbProblem20.isSelected() || cbProblem48.isSelected()) {
            taResults.clear();
        }

        if (cbProblem1.isSelected()) {
            int result = euler.euler1();

            taResults.appendText("Problem 1 (Multiples of 3 and 5):\n"
                    + result
                    + "\n---------------------------------------------------------------------------------------\n");
        }
        if (cbProblem9.isSelected()) {
            int result = euler.euler9();

            taResults.appendText("Problem 9 (Pythagorean triplet):\n"
                    + result
                    + "\n---------------------------------------------------------------------------------------\n");
        }
        if (cbProblem13.isSelected()) {
            String result = euler.euler13();

            taResults.appendText("Problem 13 (Large Sum):\n"
                    + result
                    + "\n---------------------------------------------------------------------------------------\n");
        }
        if (cbProblem20.isSelected()) {
            int result = euler.euler20();

            taResults.appendText("Problem 20 (Factorial Digit Number):\n"
                    + result
                    + "\n---------------------------------------------------------------------------------------\n");
        }
        if (cbProblem48.isSelected()) {
            String result = euler.euler48();

            taResults.appendText("Problem 48 (Self Powers):\n"
                    + result
                    + "\n---------------------------------------------------------------------------------------\n");
        }
    }
}