module at.htlkaindorf.exa_502_numbersortingv2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens at.htlkaindorf.exa_502_numbersortingv2 to javafx.fxml;
    exports at.htlkaindorf.exa_502_numbersortingv2;
    exports at.htlkaindorf.exa_502_numbersortingv2.controller;
    opens at.htlkaindorf.exa_502_numbersortingv2.controller to javafx.fxml;
}