public class NumberAnalysis {
    private int number;
    private boolean even;
    private boolean prime;
    private int digitSum;

    public NumberAnalysis(int number) {
        this.number = number;
        this.even = false;
        this.prime = true;
    }

    public void calculate() {
        calcEvenOdd();
        calcPrime();
        calcDigitSum();
    }

    public String toString() {
        String output = String.format("%d is ", number);

        output += even ? "even, " : "odd, ";
        output += prime ? "prime, " : "not prime, ";
        output += String.format("digit sum: %d", digitSum);

        return output;
    }

    private void calcEvenOdd() {
        if (number % 2 == 0) {
            even = true;
        }
    }

    private void calcPrime() {
        int index = 2;

        while (prime && index < number) {
            if (number % index == 0) {
                prime = false;
            }

            index++;
        }
    }

    private void calcDigitSum() {
        int ogNum = number;

        while (number > 0) {
            int digit = number % 10;
            number /= 10;
            digitSum += digit;
        }

        number = ogNum;
    }
}
