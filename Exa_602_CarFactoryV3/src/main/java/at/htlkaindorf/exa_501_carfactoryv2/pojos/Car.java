package at.htlkaindorf.exa_501_carfactoryv2.pojos;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private double price;
    private LocalDate releaseDate;

    public Car(String brand, String model, double price, LocalDate releaseDate) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    public static String toCSV(Car car) {
        DateTimeFormatter yearFormat = DateTimeFormatter.ofPattern("yyyy");
        return String.format("%s,%s,%s,%s", car.brand, yearFormat.format(car.releaseDate), car.price, car.model);
    }

    public static Car toCar(String line) {
        String [] parts = line.split(",");
        String [] dateParts = parts[1].split("-");

        String brand = parts[0];
        LocalDate releaseYear = LocalDate.of(Integer.parseInt(dateParts[0]), Month.JANUARY, 1);
        double price = Double.parseDouble(parts[2]);
        String model = parts[3];

        return new Car(brand, model, price, releaseYear);
    }

    @Override
    public String toString() {
        int releaseYear = releaseDate.getYear();

        return String.format("%s-%s in %d: € %.2f", brand, model, releaseYear, price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(price, car.price) == 0 && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(releaseDate, car.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, price, releaseDate);
    }
}
