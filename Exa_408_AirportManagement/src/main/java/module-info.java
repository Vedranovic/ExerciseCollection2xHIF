module at.htlkaindorf.exa_408_airportmanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlkaindorf.exa_408_airportmanagement to javafx.fxml;
    exports at.htlkaindorf.exa_408_airportmanagement;
    exports at.htlkaindorf.exa_408_airportmanagement.controller;
    opens at.htlkaindorf.exa_408_airportmanagement.controller to javafx.fxml;
}