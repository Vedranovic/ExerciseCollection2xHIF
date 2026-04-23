module at.htlkaindorf.q1_402_fraction {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlkaindorf.q1_402_fraction to javafx.fxml;
    exports at.htlkaindorf.q1_402_fraction;
    exports at.htlkaindorf.q1_402_fraction.controller;
    opens at.htlkaindorf.q1_402_fraction.controller to javafx.fxml;
}