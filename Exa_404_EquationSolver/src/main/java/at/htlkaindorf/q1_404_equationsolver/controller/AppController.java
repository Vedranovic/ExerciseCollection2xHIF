package at.htlkaindorf.q1_404_equationsolver.controller;

import at.htlkaindorf.q1_404_equationsolver.pojos.Equation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class AppController {

    @FXML
    private TextArea taCalcArea;

    private int countOfX = 0;

    public void onDigit(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String text = taCalcArea.getText();
        String digit = button.getText();

        if (text.isEmpty() && digit.equals("0")) {
            return;
        }
        if ((text.endsWith("x²") || text.endsWith("x") || text.endsWith("+") || text.endsWith("-")) && digit.equals("0")) {
            return;
        }
        if (text.endsWith("x") || text.endsWith("x²")) {
            return;
        }

        taCalcArea.appendText(digit);
    }

    public void onX(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String text = taCalcArea.getText();
        String btnText = button.getText();

        if (!text.contains("x²")) {
            if (btnText.equals("x²") && countOfX < 2) {
                taCalcArea.appendText("x²");
                countOfX++;
            }
        } else if (text.endsWith("x") || text.endsWith("²")) {
            if (btnText.equals("x")) {
                taCalcArea.appendText("");
            }
        } else {
            if (btnText.equals("x") && countOfX < 2) {
                taCalcArea.appendText("x");
                countOfX++;
            }
        }
    }

    public void onPlusMinus(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String text = taCalcArea.getText();
        String btnText = button.getText();

        if (text.isBlank()) {
            if (btnText.equals("-")) {
                taCalcArea.appendText("-");
            }
        } else {
            if (text.endsWith("x²") || text.endsWith("x")) {
                taCalcArea.appendText(btnText);
            }
        }
    }

    public void onCalculate(ActionEvent actionEvent) {
        String text = taCalcArea.getText();

        int [] coefficients;
        double [] result;

        coefficients = Equation.parse(taCalcArea.getText());
        result = Equation.solve(coefficients[0], coefficients[1], coefficients[2]);

        if (text.contains("x") && (text.contains("+") || text.contains("-"))) {
            taCalcArea.appendText("=0\n");
        }

        if (String.valueOf(result[0]).equals("NaN")) {
            taCalcArea.appendText("Error");
        } else {
            taCalcArea.appendText(String.format("x1=%.2f\n", result[0]));
            taCalcArea.appendText(String.format("x2=%.2f", result[1]));
        }
    }

    public void onClear(ActionEvent actionEvent) {
        taCalcArea.setText("");
        countOfX = 0;
    }
}