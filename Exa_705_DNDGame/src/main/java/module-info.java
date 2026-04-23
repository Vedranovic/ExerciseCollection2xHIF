module at.htlkaindorf.exa_705_dndgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlkaindorf.exa_705_dndgame to javafx.fxml;
    exports at.htlkaindorf.exa_705_dndgame;
    exports at.htlkaindorf.exa_705_dndgame.controller;
    opens at.htlkaindorf.exa_705_dndgame.controller to javafx.fxml;
}