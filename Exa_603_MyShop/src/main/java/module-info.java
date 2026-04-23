module at.htlkaindorf.exa_603_myshop {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlkaindorf.exa_603_myshop to javafx.fxml;
    exports at.htlkaindorf.exa_603_myshop;
    exports at.htlkaindorf.exa_603_myshop.controller;
    exports at.htlkaindorf.exa_603_myshop.pojos;
    opens at.htlkaindorf.exa_603_myshop.controller to javafx.fxml;
}