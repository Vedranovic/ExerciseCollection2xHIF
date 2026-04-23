public abstract class Drink {
    protected String name;
    protected double price;
    protected int amount;

    public Drink(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public abstract String getInfo();

    public double getFinalPrice() {
        return price * amount;
    }
}
