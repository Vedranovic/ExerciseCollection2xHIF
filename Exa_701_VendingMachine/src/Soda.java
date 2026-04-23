public class Soda extends Drink {
    public Soda(String name, double price, int amount) {
        super(name, price, amount);
    }

    private boolean isSugarFree() {
        if (name.equals("Coca-Cola") || name.equals("Sprite")) {
            return false;
        }

        return true;
    }

    @Override
    public String getInfo() {
        if (isSugarFree()) {
            return String.format("%s (soda, sugarfree) costs %.2f €.", name, price);
        } else {
            return String.format("%s (soda) costs %.2f €.", name, price);
        }
    }
}
