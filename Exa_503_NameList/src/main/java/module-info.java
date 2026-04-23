module at.htlkaindorf.exa_503_namelist {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlkaindorf.exa_503_namelist to javafx.fxml;
    exports at.htlkaindorf.exa_503_namelist;
    exports at.htlkaindorf.exa_503_namelist.controller;
    opens at.htlkaindorf.exa_503_namelist.controller to javafx.fxml;
}