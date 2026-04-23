package at.htlkaindorf.exa_507_recipemanagement.pojos;

import at.htlkaindorf.exa_507_recipemanagement.exceptions.DuplicateIngredientException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.Objects;

public class Recipe implements Comparable<Recipe> {
    private String name;
    private LocalDate createDate;
    private int productionTime;
    private String author;
    private ObservableList<Ingredient> ingredients;

    public Recipe(int productionTime, String author, String name) {
        this.productionTime = productionTime;
        this.author = author;
        this.name = name;
        ingredients = FXCollections.observableArrayList();
    }

    public void addIngredient(Ingredient ingredient) {
        if (ingredients.contains(ingredient)) {
            throw new DuplicateIngredientException("This ingredient does already exist!");
        }

        ingredients.add(ingredient);
        FXCollections.sort(ingredients);
    }

    @Override
    public String toString() {
        return String.format("%s from %s - 0 ingredients - %d minutes", name, author, productionTime);
    }

    @Override
    public int compareTo(Recipe o) {
        return o.author.compareTo(this.author);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(name, recipe.name) && Objects.equals(author, recipe.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author);
    }
}
