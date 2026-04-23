module at.htlkaindorf.exa_505_studentlist {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlkaindorf.exa_505_studentlist to javafx.fxml;
    exports at.htlkaindorf.exa_505_studentlist;
    exports at.htlkaindorf.exa_505_studentlist.controller;
    opens at.htlkaindorf.exa_505_studentlist.controller to javafx.fxml;
    exports at.htlkaindorf.exa_505_studentlist.comparator;
    opens at.htlkaindorf.exa_505_studentlist.comparator to javafx.fxml;
}