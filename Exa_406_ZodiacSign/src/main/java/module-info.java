module at.htlkaindorf.exa_406_zodiacsign {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlkaindorf.exa_406_zodiacsign to javafx.fxml;
    exports at.htlkaindorf.exa_406_zodiacsign;
    exports at.htlkaindorf.exa_406_zodiacsign.controller;
    opens at.htlkaindorf.exa_406_zodiacsign.controller to javafx.fxml;
}