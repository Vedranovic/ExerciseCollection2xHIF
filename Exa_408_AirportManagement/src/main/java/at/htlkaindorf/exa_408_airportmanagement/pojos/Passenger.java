package at.htlkaindorf.exa_408_airportmanagement.pojos;
import java.time.LocalDate;

public class Passenger {
    private String name;
    private int age;
    private String id;
    private float baggageWeight;
    private float price;

    public Passenger(String firstName, String lastName, LocalDate birthDate, String id, float baggageWeight) {
        this.name = firstName + ", " + lastName;
        age = calculateAge(birthDate);
        this.id = id;
        this.baggageWeight = baggageWeight;
        price = Passenger.calculatePrice(baggageWeight);
    }

    private void calculatePrice() {

    }

    public static float calculatePrice(float baggageWeight) {

    }

    private int calculateAge(LocalDate birthDate) {

    }
}
