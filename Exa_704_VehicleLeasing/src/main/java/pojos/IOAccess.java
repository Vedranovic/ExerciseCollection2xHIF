package pojos;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IOAccess {
    public List<Vehicle> loadVehicles() throws IOException {
        Path path = Path.of(System.getProperty("user.dir"),
                "src",
                "main",
                "resources",
                "files",
                "704.csv"
        );

        List<String> lines = Files.readAllLines(path);
        List<Vehicle> vehicles = new ArrayList<>();

        String line = "";

        for (int i = 1; i < lines.size(); i++) {
            line = lines.get(i);

            if (line.split(";")[4].equals("TRUCK")) {
                Truck truck = new Truck();
                truck.initVehicle(line);
                vehicles.add(truck);
            } else {
                Car car = new Car();
                car.initVehicle(line);
                vehicles.add(car);
            }
        }

        return vehicles;
    }
}
