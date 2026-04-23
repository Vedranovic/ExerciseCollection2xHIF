public class Juice extends Drink {
    public Juice(String name, double price, int amount) {
        super(name, price, amount);
    }

    private int fruitPercent() {
        if (name.equals("Orange Juice")) {
            return 80;
        } else if (name.equals("Cranberry Juice")) {
            return 60;
        } else if (name.equals("Mango Smoothie")) {
            return 20;
        }

        return 0;
    }

    @Override
    public String getInfo() {
        return String.format("%s (juice, %d%%) costs %.2f €.", name, fruitPercent(), price);
    }
}
