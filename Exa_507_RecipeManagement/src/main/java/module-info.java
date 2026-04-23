module at.htlkaindorf.exa_507_recipemanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlkaindorf.exa_507_recipemanagement to javafx.fxml;
    exports at.htlkaindorf.exa_507_recipemanagement;
    exports at.htlkaindorf.exa_507_recipemanagement.controller;
    opens at.htlkaindorf.exa_507_recipemanagement.controller to javafx.fxml;
    exports at.htlkaindorf.exa_507_recipemanagement.exceptions;
    opens at.htlkaindorf.exa_507_recipemanagement.exceptions to javafx.fxml;
}