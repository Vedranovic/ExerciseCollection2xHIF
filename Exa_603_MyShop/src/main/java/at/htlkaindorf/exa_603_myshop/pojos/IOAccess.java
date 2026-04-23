package at.htlkaindorf.exa_603_myshop.pojos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IOAccess {
    public static void writeInvoice(Path path, Order order) {
        try {
            FileWriter fw = new FileWriter(path.toFile());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(order.toString());

            bw.flush();
            fw.flush();
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Product> loadProducts() throws IOException {
        Path path = Path.of(System.getProperty("user.dir"),
                "src",
                "main",
                "resources",
                "files",
                "products.csv"
        );

        List<String> list = Files.readAllLines(path);
        List<Product> products = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            String line = list.get(i);

            products.add(Product.parseLine(line));
        }

        return products;
    }
}
