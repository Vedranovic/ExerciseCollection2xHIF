import java.util.Random;

public class Triangle {

    private int sideA;
    private int sideB;
    private int sideC;
    private String type;

//    public Triangle(int sideA, int sideB, int sideC) {
//        this.sideA = sideA;
//        this.sideB = sideB;
//        this.sideC = sideC;
//    }

    public Triangle() {
        Random random = new Random();

        sideA = random.nextInt(5, 11);
        sideB = random.nextInt(5, 11);
        sideC = random.nextInt(5, 11);
    }

    public void sortSides() {
        if (sideA > sideB) {
            int temp = sideA;
            sideA = sideB;
            sideB = temp;
        }
        if (sideB > sideC) {
            int temp = sideB;
            sideB = sideC;
            sideC = temp;
        }
        if (sideA > sideB) {
            int temp = sideA;
            sideA = sideB;
            sideB = temp;
        }
    }

    public void determineType() {
        if (sideA == sideB && sideB == sideC) {
            type = "equilateral";
        } else if (sideA != sideB && sideB == sideC || sideA == sideB || sideA == sideC) {
            type = "isosceles";
        } else if ((sideA * sideA) + (sideB * sideB) == (sideC * sideC)) {
            type = "right-angled";
        } else if (sideA + sideB > sideC) {
            type = "right-angled";
        } else {
            type = "not a triangle";
        }
    }

    public String toString() {
        return String.format("Triangle (%d,%d,%d) -> %s", sideA, sideB, sideC, type);
    }
}
