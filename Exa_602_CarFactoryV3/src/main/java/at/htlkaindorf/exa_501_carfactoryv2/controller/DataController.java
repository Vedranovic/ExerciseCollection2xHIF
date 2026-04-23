package at.htlkaindorf.exa_501_carfactoryv2.controller;

import at.htlkaindorf.exa_501_carfactoryv2.FileAccess;
import at.htlkaindorf.exa_501_carfactoryv2.exceptions.DuplicateCarsExceptions;
import at.htlkaindorf.exa_501_carfactoryv2.pojos.Car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DataController {
    private ObservableList<Car> cars;

    public DataController() {
        this.cars = FXCollections.observableArrayList();
    }

    public void createCar(Car car) {
        if (!cars.contains(car)) {
            cars.add(car);
            FXCollections.sort(cars, new Comparator<Car>() {
                @Override
                public int compare(Car o1, Car o2) {
                    return o1.getReleaseDate().getYear() - o2.getReleaseDate().getYear();
                }
            });
        } else {
            throw new DuplicateCarsExceptions(cars + " is already in the list!");
        }
    }

    public void changePriceOfCars(int index, double newPrice) throws ArrayIndexOutOfBoundsException {
        if (index < cars.size()) {
            cars.get(index).setPrice(newPrice);
        } else {
            throw new ArrayIndexOutOfBoundsException("The entered car ID was not valid!");
        }
    }

    public void deleteCar(int index) {
        cars.remove(index);
    }

    public void loadCars() {
        cars.setAll(FileAccess.loadCars());
    }

    public void saveCars() {
        List<Car> listCars = new ArrayList<>(cars);

        FileAccess.writeCars(listCars);
    }

    public ObservableList<Car> getCars() {
        return cars;
    }
}
