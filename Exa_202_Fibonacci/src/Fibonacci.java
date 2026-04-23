public class Fibonacci {

    private int upperLimit;
    private int fiboSum;

    public Fibonacci(int upperLimit) {
        this.upperLimit = upperLimit;
        this.fiboSum = 0;

        computeSum();
    }

    private void computeSum() {
        int fibo1 = 0;
        int fibo2 = 1;
        int fibo3 = 0;

        while (fibo3 <= upperLimit) {
            if (isEven(fibo3)) {
                fiboSum += fibo3;
            }

            fibo1 = fibo2;
            fibo2 = fibo3;
            fibo3 = fibo1 + fibo2;
        }
    }

    private boolean isEven(int fibo) {
        return fibo % 2 == 0;
    }

    public String toString() {
        return String.format("Fibonacci sum till %d: %d", upperLimit, fiboSum);
    }
}
