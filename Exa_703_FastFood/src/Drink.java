import java.util.ArrayList;
import java.util.List;

public class Drink extends Product {
    protected double volume;

    public Drink(String name, double price, double volume) {
        super(name, price);
        this.volume = volume;
    }

    @Override
    public String toXMLDetails() {
        return "<volume>" + volume + "</volume>\n";
    }

    public static Drink fromCSV(String [] fields, List<Ingredient> allIngredients) {
        List<Ingredient> ingri = new ArrayList<>();
        String name = fields[1];
        double price = Double.parseDouble(fields[2]);
        double volume = Double.parseDouble(fields[3]);
        String [] parts = fields[4].split(";");

        for (String token : parts) {
            for (Ingredient ingredient : allIngredients) {
                if (token.equals(ingredient.name)) {
                    ingri.add(ingredient);
                }
            }
        }

        return new Drink(name, price, volume);
    }
}
