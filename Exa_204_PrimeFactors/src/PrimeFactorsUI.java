import java.util.Scanner;

public class PrimeFactorsUI {

    public int readNumber() {
        Scanner scanner = new Scanner(System.in);
        int number = 0;

        do {
            System.out.print("Number: ");
            number = scanner.nextInt();
        } while (number < 0);

        return number;
    }

    public static void main(String[] args) {
        PrimeFactorsUI ui = new PrimeFactorsUI();

        int number = ui.readNumber();

        PrimeFactors factors = new PrimeFactors(number);
        factors.compute();
        System.out.println(factors);
    }
}
