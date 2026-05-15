package at.htlkaindorf.exa_507_recipemanagement.controller;

import at.htlkaindorf.exa_507_recipemanagement.exceptions.DuplicateIngredientException;
import at.htlkaindorf.exa_507_recipemanagement.exceptions.DuplicateRecipeException;
import at.htlkaindorf.exa_507_recipemanagement.pojos.Ingredient;
import at.htlkaindorf.exa_507_recipemanagement.pojos.Recipe;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Comparator;
import java.util.Optional;

public class AppController {
    @FXML
    private RadioButton rbOrderDefault;
    @FXML
    private RadioButton rbOrderAmount;
    @FXML
    private RadioButton rbOrderName;
    @FXML
    private Button btAddRecipe;
    @FXML
    private Button btAddIngredients;
    @FXML
    private Button btDeleteRecipe;
    @FXML
    private Button btShowIngredients;
    @FXML
    private ListView<Recipe> lvRecipes;
    @FXML
    private ListView<Ingredient> lvIngredients;

    private DataController dataController;
    private Alert errorAlert;

    public void initialize() {
        dataController = new DataController();
        errorAlert = new Alert(Alert.AlertType.ERROR);

        btAddRecipe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onAddRecipe(event);
            }
        });
        btAddIngredients.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onAddIngredient(event);
            }
        });
        btDeleteRecipe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onDeleteRecipe(event);
            }
        });
        btShowIngredients.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onShowingIngredients(event);
            }
        });
    }

    private void loadIngredients(Recipe recipe) {
        if (rbOrderDefault.isSelected()) {
            FXCollections.sort(FXCollections.observableArrayList(recipe.getIngredients()));
            lvIngredients.setItems(FXCollections.observableArrayList(recipe.getIngredients()));
        }
        if (rbOrderAmount.isSelected()) {
            recipe.getIngredients().sort(new Comparator<Ingredient>() {
                @Override
                public int compare(Ingredient o1, Ingredient o2) {
                    return o1.getAmount() - o2.getAmount();
                }
            });
            lvIngredients.setItems(FXCollections.observableArrayList(recipe.getIngredients()));
        }
        if (rbOrderName.isSelected()) {
            recipe.getIngredients().sort(new Comparator<Ingredient>() {
                @Override
                public int compare(Ingredient o1, Ingredient o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            lvIngredients.setItems(FXCollections.observableArrayList(recipe.getIngredients()));
        }
    }

    public void onAddRecipe(ActionEvent actionEvent) {
        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setTitle("Bestätigung");
        inputDialog.setHeaderText("Bestätigung");
        inputDialog.setContentText(
                "Please enter the recipe information in the following format: name;author;productionTime!");
        Optional<String> result = inputDialog.showAndWait();

        if (result.isPresent()) {
            try {
                String[] tokens = result.get().split(";");

                dataController.addRecipe(new Recipe(tokens[0], Integer.parseInt(tokens[2]), tokens[1]));
                lvRecipes.setItems(dataController.getRecipeList());
            } catch (IndexOutOfBoundsException ioobe) {
                errorAlert.setContentText("Input format is not correct!");
                errorAlert.showAndWait();
            } catch (DuplicateRecipeException dre) {
                errorAlert.setContentText(dre.getMessage());
                errorAlert.showAndWait();
            } catch (NumberFormatException nfe) {
                errorAlert.setContentText("Please only enter valid inputs!");
                errorAlert.showAndWait();
            }
        }
    }

    public void onDeleteRecipe(ActionEvent actionEvent) {
        if (lvRecipes.getSelectionModel().getSelectedIndex() > -1) {
            dataController.deleteRecipe(
                    dataController.getRecipeList().get(
                            lvRecipes.getSelectionModel().getSelectedIndex()));
        }
    }

    public void onShowingIngredients(ActionEvent actionEvent) {
        if (lvRecipes.getSelectionModel().getSelectedIndex() > -1) {
            loadIngredients(dataController.getRecipeList().get(lvRecipes.getSelectionModel().getSelectedIndex()));
        }
    }

    public void onAddIngredient(ActionEvent actionEvent) {
        if (lvRecipes.getSelectionModel().getSelectedIndex() > -1) {
            TextInputDialog inputDialog = new TextInputDialog();
            inputDialog.setTitle("Bestätigung");
            inputDialog.setHeaderText("Bestätigung");
            inputDialog.setContentText(
                    "Please enter the ingredient information in the following format: amount-unit-name!");
            Optional<String> result = inputDialog.showAndWait();

            if (result.isPresent()) {
                try {
                    String[] tokens = result.get().split("-");

                    dataController.addIngredientToRecipe(
                            lvRecipes.getSelectionModel().getSelectedIndex(),
                            new Ingredient(
                                    tokens[2],
                                    tokens[1],
                                    Integer.parseInt(tokens[0])
                            ));
                    lvRecipes.setItems(dataController.getRecipeList());
                }catch (IndexOutOfBoundsException ioobe) {
                    errorAlert.setContentText("Input format is not correct!");
                    errorAlert.showAndWait();
                } catch (DuplicateIngredientException die) {
                    errorAlert.setContentText(die.getMessage());
                    errorAlert.showAndWait();
                } catch (NumberFormatException nfe) {
                    errorAlert.setContentText("Please only enter valid inputs!");
                    errorAlert.showAndWait();
                }
            }
        }
    }
}