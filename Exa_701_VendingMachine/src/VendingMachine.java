import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private List<Drink> drinks;

    public VendingMachine() {
        drinks = new ArrayList<>();
    }

    public static void main(String[] args) {
        Water water1 = new Water("Vöslauer", 0.79, 3);
        Water water2 = new Water("Römerquelle", 0.69, 1);
        Juice juice1 = new Juice("Orange Juice", 1.29, 2);
        Juice juice2 = new Juice("Cranberry Juice", 1.39, 5);
        Juice juice3 = new Juice("Mango Smoothie", 1.79, 3);
        Soda soda1 = new Soda("Coca-Cola", 3.49, 7);
        Soda soda2 = new Soda("Sprite", 2.69, 4);
        Soda soda3 = new Soda("Cola Zero", 3.39, 2);
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.addDrink(water1);
        vendingMachine.addDrink(water2);
        vendingMachine.addDrink(juice1);
        vendingMachine.addDrink(juice2);
        vendingMachine.addDrink(juice3);
        vendingMachine.addDrink(soda1);
        vendingMachine.addDrink(soda2);
        vendingMachine.addDrink(soda3);

        vendingMachine.deleteAllJuices();

        System.out.println("---- Vending Machine ----");
        System.out.println("The following drinks are selected:");

        for (Drink drink : vendingMachine.drinks) {
            System.out.println(drink.amount + " x " + drink.getInfo());
        }

        System.out.println();

        double [] pricePerDrink = vendingMachine.getPricePerDrink();

        System.out.printf("The waters cost %.2f €\n", pricePerDrink[0]);
        System.out.printf("The juices cost %.2f €\n", pricePerDrink[1]);
        System.out.printf("The sodas cost %.2f €\n", pricePerDrink[2]);
        System.out.printf("You have to pay: %.2f €", vendingMachine.getFullPrice());
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void deleteAllJuices() {
        for (int i = drinks.size() - 1; i >= 0; i--) {
            if (drinks.get(i) instanceof Juice) {
                drinks.remove(i);
            }
        }
    }

    public double [] getPricePerDrink() {
        double [] pricePerDrink = new double[3];

        for (Drink drink : drinks) {
            if (drink instanceof Water) {
                pricePerDrink[0] += drink.getFinalPrice();
            }
        }
        for (Drink drink : drinks) {
            if (drink instanceof Juice) {
                pricePerDrink[1] += drink.getFinalPrice();
            }
        }
        for (Drink drink : drinks) {
            if (drink instanceof Soda) {
                pricePerDrink[2] += drink.getFinalPrice();
            }
        }

        return pricePerDrink;
    }

    public double getFullPrice() {
        double fullPrice = 0.0;
        double [] pricePerDrink = getPricePerDrink();

        for (double value : pricePerDrink) {
            fullPrice += value;
        }

        return fullPrice;
    }
}
