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
        String output = "";

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            output += String.format("%d: ", i + 1);
            output += car.toString() + "\n";
        }

        return output;
    }

    public void changePriceOfCars(int index, double newPrice) throws ArrayIndexOutOfBoundsException {
        if (index < cars.size()) {
            cars.get(index).setPrice(newPrice);
        } else {
            throw new ArrayIndexOutOfBoundsException("The entered car ID was not valid!");
        }
    }
}
