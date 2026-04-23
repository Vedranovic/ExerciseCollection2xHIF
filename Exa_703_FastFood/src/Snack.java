import java.util.ArrayList;
import java.util.List;

public class Snack extends Product {
    protected String size;

    public Snack(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

    @Override
    public String toXMLDetails() {
        return "<size>" + size + "</size>\n";
    }

    public static Snack fromCSV(String [] fields, List<Ingredient> allIngredients) {
        List<Ingredient> ingri = new ArrayList<>();
        String name = fields[1];
        double price = Double.parseDouble(fields[2]);
        String size = fields[3];
        String [] parts = fields[4].split(";");

        for (String token : parts) {
            for (Ingredient ingredient : allIngredients) {
                if (token.equals(ingredient.name)) {
                    ingri.add(ingredient);
                }
            }
        }

        return new Snack(name, price, size);
    }
}
