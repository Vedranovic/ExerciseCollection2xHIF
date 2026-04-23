import java.util.Random;

public class LottoNumbers {

    private int [] numbers;
    private int additionalNumber;

    public LottoNumbers() {
        Random random = new Random();
        int size = 6;
        numbers = new int[size];
        additionalNumber = random.nextInt(1, 46);

        for (int i = 0; i < numbers.length; i++) {
            int randNum = random.nextInt(1, 46);
            numbers[i] = randNum;

            if (additionalNumber == numbers[i]) {
                additionalNumber = random.nextInt(1, 46);
            }
        }
    }

    public void sortNumbers() {
        int nSwaps = 1;

        do {
            nSwaps = 0;

            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                    nSwaps++;
                }
            }
        } while (nSwaps != 0);
    }

    public String toString() {
        String output = "Lottery Result: ";

        for (int i = 0; i < numbers.length; i++) {
            output += String.format("%d", numbers[i]);

            if ((i + 1) % numbers.length != 0) {
                output += ", ";
            }
        }

        output += String.format(" Additional Number: %d", additionalNumber);

        return output;
    }
}
