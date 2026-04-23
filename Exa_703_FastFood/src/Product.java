import java.util.ArrayList;
import java.util.List;

public abstract class Product {
    protected String name;
    protected double price;
    protected List<Ingredient> ingredients;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        ingredients = new ArrayList<>();
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public int getOverallCalories() {
        int overallCalories = 0;

        for (Ingredient ingredient : ingredients) {
            overallCalories += ingredient.getCalories();
        }

        return overallCalories;
    }

    public String toXML() {
        String output = "";

        output += "<product>\n" +
                "      <type>" + ingredients.getClass() + "</type>\n" +
                "      <name>" + name + "</name>\n" +
                "      <price>" + price + "</price>\n";

        output += toXMLDetails();
        output += "       <ingredients>\n";

        for (Ingredient ingredient : ingredients) {
            output += ingredient.toXML() + "\n";
        }

        output += "      </ingredients>\n";
        output += "    </product>\n";

        return output;
    }

    public abstract String toXMLDetails();

    public double getPrice() {
        return price;
    }
}
