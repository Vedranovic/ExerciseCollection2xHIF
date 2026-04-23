module at.htlkaindorf.q1_405_eulerproblems {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlkaindorf.q1_405_eulerproblems to javafx.fxml;
    exports at.htlkaindorf.q1_405_eulerproblems;
    exports at.htlkaindorf.q1_405_eulerproblems.controller;
    opens at.htlkaindorf.q1_405_eulerproblems.controller to javafx.fxml;
}