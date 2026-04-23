public class Water extends Drink {
    public Water(String name, double price, int amount) {
        super(name, price, amount);
    }

    @Override
    public String getInfo() {
        return String.format("%s (water) costs %.2f €.", name, price);
    }
}
