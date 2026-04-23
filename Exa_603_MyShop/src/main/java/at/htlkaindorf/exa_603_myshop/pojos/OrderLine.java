package at.htlkaindorf.exa_603_myshop.pojos;

public class OrderLine {
    private int quantity;
    private Product product;

    public OrderLine(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public String toHTML() {
        return "<tr>\n" +
                "                <td>" + product.getNumber() + "</td>\n" +
                "                <td>" + product.getName() + "</td>\n" +
                "                <td>" + product.getPrice() + "</td>\n" +
                "                <td>" + quantity + "</td>\n" +
                "                <td>" + getLinePrice() + "</td>\n" +
                "            </tr>";
    }

    public float getLinePrice() {
        return quantity * product.getPrice();
    }
}
