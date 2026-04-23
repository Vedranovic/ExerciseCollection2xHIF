import java.util.Scanner;

public class CalcTrainerUI {

    public boolean performTrainingsTask(byte difficulty, int round) {
        TrainingsCalculation calculation = new TrainingsCalculation(difficulty);
        Scanner scanner = new Scanner(System.in);
        int userResult = 0;

        System.out.printf("Round %d%n", round);
        System.out.println(calculation);
        System.out.print("Enter result: ");
        userResult = scanner.nextInt();

        if (userResult == calculation.getResult()) {
            System.out.println("Perfect");
        } else {
            System.out.printf("The correct result is %d%n", calculation.getResult());
        }

        return userResult == calculation.getResult();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rounds = 0;
        byte difficulty = 0;
        int points = 0;

        System.out.print("Enter number of rounds: ");
        rounds = scanner.nextInt();
        System.out.print("Enter difficulty: ");
        difficulty = scanner.nextByte();

        CalcTrainerUI ui = new CalcTrainerUI();

        for (int i = 0; i < rounds; i++) {
            points += ui.performTrainingsTask(difficulty, i+1) ? 1 : 0;
        }

        System.out.printf("You achieved %d of %d points!", points, rounds);
    }
}
