package controller;

import pojos.Car;
import pojos.IOAccess;
import pojos.Truck;
import pojos.Vehicle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataController {
    private List<Vehicle> vehicles;

    public DataController() {
        vehicles = new ArrayList<>();
    }

    public void loadVehicles() throws IOException {
        IOAccess io = new IOAccess();

        vehicles = io.loadVehicles();
    }

    public String printAllCars() {
        String output = "";
        Collections.sort(vehicles);

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass().getSimpleName().equals("Car")) {
                output += vehicle.toString();
            }
        }

        return output;
    }

    public String printAllVehicles() {
        String output = "";
        Collections.sort(vehicles);

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass().getSimpleName().equals("Car")) {
                output += vehicle.toString();
            } else {
                output += vehicle.toString();
            }
        }

        return output;
    }

    public String printAllTrucks() {
        String output = "";
        Collections.sort(vehicles);

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass().getSimpleName().equals("Truck")) {
                output += vehicle.toString();
            }
        }

        return output;
    }

    public static void main(String[] args) throws IOException {
        DataController dataController = new DataController();

        dataController.loadVehicles();
        System.out.println("ALL:");
        System.out.println(dataController.printAllVehicles());
        System.out.println();
        System.out.println("CARS:");
        System.out.println(dataController.printAllCars());
        System.out.println();
        System.out.println("TRUCKS:");
        System.out.println(dataController.printAllTrucks());
    }
}
