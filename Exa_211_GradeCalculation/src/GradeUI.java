import java.util.Scanner;

public class GradeUI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of grades: ");
        int numberOfGrades = scanner.nextInt();

        GradeBL gradeBL = new GradeBL(numberOfGrades);
        gradeBL.evaluation();
        System.out.println(gradeBL);
    }
}
