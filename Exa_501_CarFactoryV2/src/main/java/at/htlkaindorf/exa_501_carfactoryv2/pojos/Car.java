package at.htlkaindorf.exa_501_carfactoryv2.pojos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public String toString() {
        return String.format("%s %s released in %s costs € %.2f",
                brand, model, releaseDate.format(DateTimeFormatter.ofPattern("MM/yyyy")), price);
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
