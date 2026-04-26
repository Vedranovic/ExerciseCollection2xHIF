package at.htlkaindorf.exa_408_airportmanagement.pojos;
import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;

public class Passenger {
    private String name;
    private int age;
    private String id;
    private float baggageWeight;
    private float price;

    public Passenger(String firstname, String lastname, LocalDate birthdate, String id, float baggageWeight) {
        this.name = String.format(Locale.GERMAN, "%s, %s", lastname, firstname);
        this.age = calculateAge(birthdate);
        this.baggageWeight = baggageWeight;
        this.id = id;
        calculatePrice();
    }

    private void calculatePrice() {
        price = calculatePrice(baggageWeight);
    }

    public static float calculatePrice(float baggageWeight) {
        if (baggageWeight <= 30) {
            return 0;
        }

        float over = baggageWeight - 30;
        float price = 0;
        int blockPrice = 5;

        while (over > 0) {
            float kgInThisBlock = Math.min(5, over);
            price += (kgInThisBlock * blockPrice);

            over -= kgInThisBlock;

            if (blockPrice < 9) {
                blockPrice += 2;
            }
        }

        return price;
    }

    private int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return String.format("%s - %d years old; %s; %.2f €\n", name, age, id, price);
    }
}
