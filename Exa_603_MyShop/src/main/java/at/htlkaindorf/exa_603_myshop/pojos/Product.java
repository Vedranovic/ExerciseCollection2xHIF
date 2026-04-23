package at.htlkaindorf.exa_603_myshop.pojos;

public class Product implements Comparable<Product> {
    private int number;
    private String name;
    private float price;
    private String category;

    public Product(int number, String name, float price, String category) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public static Product parseLine(String line) {
        String [] parts = line.split(",");

        return new Product(Integer.parseInt(parts[0]), parts[1], Float.parseFloat(parts[2]), parts[3]);
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public int compareTo(Product o) {
        return this.name.compareTo(o.name);
    }
}
