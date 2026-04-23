import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 1;

        System.out.println("Welcome to number analysis!");

        while (number != 0) {
            System.out.print("Enter a number: ");
            number = scanner.nextInt();

            if (number != 0) {
                NumberAnalysis analysis = new NumberAnalysis(number);

                analysis.calculate();
                System.out.println(analysis);
                System.out.println();
            }
        }

        System.out.print("Bye! :)");
    }
}
