package at.htlkaindorf.exa_507_recipemanagement.controller;

import at.htlkaindorf.exa_507_recipemanagement.exceptions.DuplicateRecipeException;
import at.htlkaindorf.exa_507_recipemanagement.pojos.Ingredient;
import at.htlkaindorf.exa_507_recipemanagement.pojos.Recipe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataController {
    private ObservableList<Recipe> recipeList;

    public DataController() {
        this.recipeList = FXCollections.observableArrayList();
    }

    public void addRecipe(Recipe recipe) {
        if (recipeList.contains(recipe)) {
            throw new DuplicateRecipeException("This recipe does already exists!");
        }

        recipeList.add(recipe);
        FXCollections.sort(recipeList);
    }

    public void deleteRecipe(Recipe recipe) {
        recipeList.remove(recipe);
    }

    public void addIngredientToRecipe(int index, Ingredient ingredient) {
        recipeList.get(index).addIngredient(ingredient);
    }

    public ObservableList<Recipe> getRecipeList() {
        return recipeList;
    }
}
