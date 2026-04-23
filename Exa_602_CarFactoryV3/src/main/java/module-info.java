module at.htlkaindorf.exa_501_carfactoryv2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlkaindorf.exa_501_carfactoryv2 to javafx.fxml;
    exports at.htlkaindorf.exa_501_carfactoryv2;
    exports at.htlkaindorf.exa_501_carfactoryv2.controller;
    opens at.htlkaindorf.exa_501_carfactoryv2.controller to javafx.fxml;
}