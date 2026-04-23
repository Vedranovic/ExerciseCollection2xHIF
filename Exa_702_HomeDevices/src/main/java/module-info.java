module at.htlkaindorf.exa_702_homedevices {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlkaindorf.exa_702_homedevices to javafx.fxml;
    exports at.htlkaindorf.exa_702_homedevices;
    exports at.htlkaindorf.exa_702_homedevices.controller;
    opens at.htlkaindorf.exa_702_homedevices.controller to javafx.fxml;
}