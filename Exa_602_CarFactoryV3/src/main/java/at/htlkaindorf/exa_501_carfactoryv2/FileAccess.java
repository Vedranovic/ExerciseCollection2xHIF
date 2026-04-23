package at.htlkaindorf.exa_501_carfactoryv2;

import at.htlkaindorf.exa_501_carfactoryv2.pojos.Car;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileAccess {
    private static Path filePath = Path.of(System.getProperty("user.dir"),
            "src",
            "main",
            "resources",
            "files",
            "carData.csv");

    public static List<Car> loadCars() {
        List<Car> carList = new ArrayList<>();

        try {
            FileReader fr = new FileReader(filePath.toFile());
            BufferedReader br = new BufferedReader(fr);

            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                carList.add(Car.toCar(line));
            }

            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return carList;
    }

    public static void writeCars(List<Car> cars) {
        try {
            FileWriter fw = new FileWriter(filePath.toFile());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("brand,releaseYear,price,model");
            bw.newLine();

            for (Car car : cars) {
                bw.write(Car.toCSV(car));
                bw.newLine();
            }

            bw.flush();
            fw.flush();
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
