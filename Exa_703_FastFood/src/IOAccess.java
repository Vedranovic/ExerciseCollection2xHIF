import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IOAccess {
    private static Path basePath = Path.of(System.getProperty("user.dir"),
            "src",
            "files");
    private static Path ingredientsPath = Path.of(String.valueOf(basePath),
            "ingredients.csv");
    private static Path productsPath = Path.of(String.valueOf(basePath),
            "products.csv");
    private static Path orderPath = Path.of(String.valueOf(basePath),
            "order.xml");

    public static List<Ingredient> loadIngredients() {
        List<Ingredient> ingredientList = new ArrayList<>();

        try {
            FileReader fr = new FileReader(ingredientsPath.toFile());
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                ingredientList.add(Ingredient.fromCSV(line));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ingredientList;
    }

    public static List<Product> loadProducts(List<Ingredient> ingredients) {
        List<Product> productList = new ArrayList<>();

        try {
            FileReader fr = new FileReader(productsPath.toFile());
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String [] parts = line.split(",");

                if (parts[0].equals("Snack")) {
                    productList.add(Snack.fromCSV(parts, ingredients));
                } else {
                    productList.add(Drink.fromCSV(parts, ingredients));
                }
            }

            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return productList;
    }

    public static void saveOrderAsXML(Order order) {
        try {
            FileWriter fw = new FileWriter(orderPath.toFile());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(order.toXML());

            bw.flush();
            fw.flush();
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
    }
}
