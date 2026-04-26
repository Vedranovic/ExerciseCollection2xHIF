package at.htlkaindorf.exa_501_carfactoryv2.controller;

import at.htlkaindorf.exa_501_carfactoryv2.pojos.Car;

import java.util.ArrayList;
import java.util.List;

public class DataController {
    private List<Car> cars;

    public DataController() {
        cars = new ArrayList<>();
    }

    public void createCar(Car car) {
        cars.add(car);
    }

    public String printCars() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            output.append(String.format("%d: ", i + 1));
            output.append(car.toString()).append("\n");
        }

        return output.toString();
    }

    public void changePriceOfCars(int index, double newPrice) throws ArrayIndexOutOfBoundsException {
        if (index < cars.size()) {
            cars.get(index).setPrice(newPrice);
        } else {
            throw new ArrayIndexOutOfBoundsException("The entered car ID was not valid!");
        }
    }
}
