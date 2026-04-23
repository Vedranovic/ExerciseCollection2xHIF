module at.htlkaindorf.q1_401_currencyconverter {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlkaindorf.q1_401_currencyconverter to javafx.fxml;
    exports at.htlkaindorf.q1_401_currencyconverter;
    exports at.htlkaindorf.q1_401_currencyconverter.controller;
    opens at.htlkaindorf.q1_401_currencyconverter.controller to javafx.fxml;
}