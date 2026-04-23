module at.htlkaindorf.exa_506_contactmanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlkaindorf.exa_506_contactmanagement to javafx.fxml;
    exports at.htlkaindorf.exa_506_contactmanagement;
    exports at.htlkaindorf.exa_506_contactmanagement.controller;
    opens at.htlkaindorf.exa_506_contactmanagement.controller to javafx.fxml;
}