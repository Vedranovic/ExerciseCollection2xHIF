import java.util.Random;
import java.util.Scanner;

public class CarFactoryUI {

    private String[] brandNames = {"Audi", "Fiat", "VW", "Mercedes", "BMW"};
    private String[] modelNames = {"Panda", "500", "Polo", "Golf", "S", "Mini", "ID.4", "Mustang", "Chiron", "Diablo"};
    private Car[] cars;

    public CarFactoryUI(int size) {
        this.cars = new Car[size];
    }

    public void createCars() {
        Random random = new Random();

        for (int i = 0; i < cars.length; i++) {
            double price = random.nextDouble(1000, 10000);
            String brandName = brandNames[random.nextInt(brandNames.length)];
            String modelName = modelNames[random.nextInt(modelNames.length)];

            Car car = new Car(brandName, modelName, price);
            cars[i] = car;
        }
    }

    public void printCars() {
        for (int i = 0; i < cars.length; i++) {
            System.out.printf("%d%50s%n", (i + 1), cars[i]);
        }
    }

    public void changePriceOfCar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Change price of car: ");
        int selection = scanner.nextInt();

        System.out.printf("Car: %s-%s%n", cars[selection - 1].getBrand(), cars[selection - 1].getModel());
        System.out.printf("Actual price: %.2f €%n", cars[selection - 1].getPrice());

        System.out.print("New price: ");
        double price = scanner.nextDouble();
        cars[selection - 1].setPrice(price);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of cars: ");
        int countOfCars = scanner.nextInt();

        CarFactoryUI factoryUI = new CarFactoryUI(countOfCars);
        factoryUI.createCars();
        factoryUI.printCars();
        factoryUI.changePriceOfCar();
        factoryUI.printCars();
    }
}
