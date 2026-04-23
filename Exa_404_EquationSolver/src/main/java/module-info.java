module at.htlkaindorf.q1_404_equationsolver {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlkaindorf.q1_404_equationsolver to javafx.fxml;
    exports at.htlkaindorf.q1_404_equationsolver;
    exports at.htlkaindorf.q1_404_equationsolver.controller;
    opens at.htlkaindorf.q1_404_equationsolver.controller to javafx.fxml;
}