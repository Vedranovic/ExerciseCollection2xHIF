package at.htlkaindorf.exa_507_recipemanagement.pojos;

import at.htlkaindorf.exa_507_recipemanagement.exceptions.DuplicateIngredientException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Recipe implements Comparable<Recipe> {
    private List<Ingredient> ingredients;
    private String name;
    private int productionTime;
    private String author;

    public Recipe(String name, int productionTime, String author) {
        this.ingredients = new ArrayList<>();
        this.name = name;
        this.productionTime = productionTime;
        this.author = author;
    }

    public void addIngredient(Ingredient ingredient) {
        if (ingredients.contains(ingredient)) {
            throw new DuplicateIngredientException("This ingredient does already exist!");
        }

        ingredients.add(ingredient);
    }

    @Override
    public String toString() {
        return String.format("%s from %s - %d ingredients - %d minutes", name, author, ingredients.size(), productionTime);
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

    @Override
    public int compareTo(Recipe o) {
        return this.name.compareTo(o.name);
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
