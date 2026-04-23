import java.util.Scanner;

public class FibonacciUI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Upper limit: ");
        int upperLimit = scanner.nextInt();

        Fibonacci fibo = new Fibonacci(upperLimit);

        System.out.println(fibo);
    }
}
