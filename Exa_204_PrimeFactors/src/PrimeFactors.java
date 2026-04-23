public class PrimeFactors {

    private int number;
    private int [] primeFactors;

    public PrimeFactors(int number) {
        setNumber(number);
        this.primeFactors = new int[number];
    }

    public void compute() {
        int index = 0;

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                boolean isPrime = true;

                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    primeFactors[index] = i;
                }

                index++;
            }
        }
    }

    public String toString() {
        String output = String.format("Prime factors of %d: ", number);
        boolean first = true;

        for (int i = 0; i < primeFactors.length; i++) {
            if (primeFactors[i] != 0) {
                if (!first) {
                    output += ", ";
                }
                output += primeFactors[i];
                first = false;
            }
        }

        return output;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
