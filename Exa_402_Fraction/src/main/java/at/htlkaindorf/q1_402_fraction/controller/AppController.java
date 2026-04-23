package at.htlkaindorf.q1_402_fraction.controller;

import at.htlkaindorf.q1_402_fraction.pojos.Fraction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AppController {
    @FXML
    private TextField tfNumerator;
    @FXML
    private TextField tfDenominator;
    @FXML
    private TextField tfShortenNumerator;
    @FXML
    private TextField tfShortenDenominator;

    public void onShorten(ActionEvent actionEvent) {
        int numerator = Integer.parseInt(tfNumerator.getText());
        int denominator = Integer.parseInt(tfDenominator.getText());

        Fraction fraction = new Fraction(numerator, denominator);
        fraction.shorten();

        tfShortenNumerator.setText(String.format("%d", fraction.getNumerator()));
        tfShortenDenominator.setText(String.format("%d", fraction.getDenominator()));
    }
}