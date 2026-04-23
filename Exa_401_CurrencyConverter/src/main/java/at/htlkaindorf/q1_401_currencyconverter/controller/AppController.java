package at.htlkaindorf.q1_401_currencyconverter.controller;

import at.htlkaindorf.q1_401_currencyconverter.pojos.CurrencyConverter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AppController {
    @FXML
    private TextField tfEuro;
    @FXML
    private TextField tfDollar;

    public void onEurToUsd(ActionEvent actionEvent) {
        CurrencyConverter converter = new CurrencyConverter();

        double euro = Double.parseDouble(tfEuro.getText());
        double dollar = converter.euroToDollar(euro);
        tfDollar.setText(String.format("%.2f", dollar));
    }

    public void onUsdToEur(ActionEvent actionEvent) {
        CurrencyConverter converter = new CurrencyConverter();

        double dollar = Double.parseDouble(tfDollar.getText());
        double euro = converter.dollarToEuro(dollar);
        tfEuro.setText(String.format("%.2f", euro));
    }
}