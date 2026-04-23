module at.htlkaindorf.exa_407_musicapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlkaindorf.exa_407_musicapp to javafx.fxml;
    exports at.htlkaindorf.exa_407_musicapp;
    exports at.htlkaindorf.exa_407_musicapp.controller;
    opens at.htlkaindorf.exa_407_musicapp.controller to javafx.fxml;
}