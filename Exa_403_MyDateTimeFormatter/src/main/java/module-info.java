module at.htlkaindorf.q1_403_mydatetimeformatter {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens at.htlkaindorf.q1_403_mydatetimeformatter to javafx.fxml;
    exports at.htlkaindorf.q1_403_mydatetimeformatter;
    exports at.htlkaindorf.q1_403_mydatetimeformatter.controller;
    opens at.htlkaindorf.q1_403_mydatetimeformatter.controller to javafx.fxml;
}