package at.htlkaindorf.exa_507_recipemanagement.exceptions;

public class DuplicateIngredientException extends RuntimeException {
    public DuplicateIngredientException(String message) {
        super(message);
    }
}
