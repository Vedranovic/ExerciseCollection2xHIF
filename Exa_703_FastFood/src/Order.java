import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNumber;
    private LocalDate orderDate;
    private List<Product> products;

    public Order(LocalDate orderDate, int orderNumber) {
        this.orderDate = orderDate;
        this.orderNumber = orderNumber;
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;

        for (Product product : products) {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }

    public int getTotalCalories() {
        int totalCalories = 0;

        for (Product product : products) {
            totalCalories += product.getOverallCalories();
        }

        return totalCalories;
    }

    public String toXML() {
        String output = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<order>\n" +
                "  <orderNumber>" + orderNumber + "</orderNumber>\n" +
                "  <orderDate>" + orderDate + "</orderDate>\n" +
                "  <totalPrice>" + getTotalPrice() + "</totalPrice>\n" +
                "  <totalCalories>" + getTotalCalories() + "</totalCalories>\n" +
                "  <products>\n";

        for (Product product : products) {
            output += product.toXML();
        }

        output += "  </products>\n" +
                "</order>\n";

        return output;
    }
}
