package at.htlkaindorf.exa_507_recipemanagement.controller;

import at.htlkaindorf.exa_507_recipemanagement.exceptions.DuplicateRecipeException;
import at.htlkaindorf.exa_507_recipemanagement.pojos.Ingredient;
import at.htlkaindorf.exa_507_recipemanagement.pojos.Recipe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
            public void handle(ActionEvent actionEvent) {
                onAddRecipe(actionEvent);
            }
        });

        btAddIngredients.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onAddIngredient(actionEvent);
            }
        });

        btDeleteRecipe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onDeleteRecipe(actionEvent);
            }
        });

        btShowIngredients.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onShowingIngredients(actionEvent);
            }
        });
    }

    private void loadIngredients(Recipe recipe) {
        ObservableList<Ingredient> ingredientsList = FXCollections.observableArrayList();

        if (rbOrderDefault.isSelected()) {
            FXCollections.sort(ingredientsList, new Comparator<Ingredient>() {
                @Override
                public int compare(Ingredient o1, Ingredient o2) {
                    if (o1.getUnit().equals(o2.getUnit())) {
                        return o1.getAmount() - o2.getAmount();
                    }

                    return o1.getUnit().compareTo(o2.getUnit());
                }
            });
        }

        if (rbOrderAmount.isSelected()) {
            FXCollections.sort(ingredientsList, new Comparator<Ingredient>() {
                @Override
                public int compare(Ingredient o1, Ingredient o2) {
                    return o1.getAmount() - o2.getAmount();
                }
            });
        }

        if (rbOrderName.isSelected()) {
            FXCollections.sort(ingredientsList, new Comparator<Ingredient>() {
                @Override
                public int compare(Ingredient o1, Ingredient o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
        }

        lvIngredients.setItems(ingredientsList);
    }

    public void onAddRecipe(ActionEvent actionEvent) {
        TextInputDialog inputRecipe = new TextInputDialog();
        inputRecipe.setTitle("Bestätigung");
        inputRecipe.setHeaderText("Bestätigung");
        inputRecipe.setContentText("Please enter the addedRecipe information in the following format: name;author;productionTime!");
        Optional<String> addedRecipe = inputRecipe.showAndWait();

        if (addedRecipe.isPresent()) {
            String input = addedRecipe.get();
            String [] parts = input.split(";");

            if (parts.length == 3) {
                String name = parts[0];
                String author = parts[1];
                String productionTimeStr = parts[2];

                if (!name.isBlank() && !author.isBlank()) {
                    try {
                        int productionTime = Integer.parseInt(productionTimeStr);

                        if (productionTime > 0) {
                            try {
                                Recipe recipe = new Recipe(productionTime, author, name);
                                dataController.addRecipe(recipe);
                                lvRecipes.setItems(dataController.getRecipeList());
                            } catch (DuplicateRecipeException dre) {
                                errorAlert.setContentText(dre.getMessage());
                                errorAlert.showAndWait();
                            }
                        } else {
                            errorAlert.setContentText("Input format is not correct!");
                            errorAlert.showAndWait();
                        }
                    } catch (NumberFormatException nfe) {
                        errorAlert.setContentText("Input format is not correct!");
                        errorAlert.showAndWait();
                    }
                } else {
                    errorAlert.setContentText("Input format is not correct!");
                    errorAlert.showAndWait();
                }
            } else {
                errorAlert.setContentText("Input format is not correct!");
                errorAlert.showAndWait();
            }
        }
    }

    public void onDeleteRecipe(ActionEvent actionEvent) {
        Recipe selected = lvRecipes.getSelectionModel().getSelectedItem();
        dataController.deleteRecipe(selected);
        lvRecipes.setItems(dataController.getRecipeList());
    }

    public void onShowingIngredients(ActionEvent actionEvent) {

    }

    public void onAddIngredient(ActionEvent actionEvent) {
        Recipe selected = lvRecipes.getSelectionModel().getSelectedItem();
        int index = lvRecipes.getSelectionModel().getSelectedIndex();

        if (!(selected == null)) {
            TextInputDialog inputIngredient = new TextInputDialog();
            inputIngredient.setTitle("Bestätigung");
            inputIngredient.setHeaderText("Bestätigung");
            inputIngredient.setContentText("Please enter the ingredient information in the following format: amount-unit-name!");
            Optional<String> addedIngredient = inputIngredient.showAndWait();

            if (addedIngredient.isPresent()) {
                String input = addedIngredient.get();
                String [] parts = input.split("-");

                if (parts.length == 3) {
                    String amountStr = parts[0];
                    String unit = parts[1];
                    String name = parts[2];

                    if (!unit.isBlank() && !name.isBlank()) {
                        try {
                            int amount = Integer.parseInt(amountStr);

                            if (amount > 0) {
                                Ingredient ingredient = new Ingredient(name, unit, amount);
                                dataController.addIngredientToRecipe(index, ingredient);
                                lvRecipes.setItems(dataController.getRecipeList());
                            }
                        } catch (NumberFormatException nfe) {
                            errorAlert.setContentText("Input format is not correct!");
                            errorAlert.showAndWait();
                        }
                    } else {
                        errorAlert.setContentText("Input format is not correct!");
                        errorAlert.showAndWait();
                    }
                } else {
                    errorAlert.setContentText("Input format is not correct!");
                    errorAlert.showAndWait();
                }
            } else {
                errorAlert.setContentText("Input format is not correct!");
                errorAlert.showAndWait();
            }
        }
    }
}