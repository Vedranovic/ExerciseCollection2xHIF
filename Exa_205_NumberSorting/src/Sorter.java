import java.util.Random;

public class Sorter {
    private int [] numbers;

    public Sorter(int size) {
        Random random = new Random();
        numbers = new int[size];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(0, numbers.length + 1);
        }
    }

    public void selectionSort() {
        for (int i = 0; i < numbers.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[minIndex] > numbers[j]) {
                    minIndex = j;
                }
            }

            int temp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = temp;
        }
    }

    public void insertionSort() {
        for (int i = 1; i < numbers.length; i++) {
            int j = i;

            while (j > 0 && numbers[j - 1] > numbers[j]) {
                int temp = numbers[j - 1];
                numbers[j - 1] = numbers[j];
                numbers[j] = temp;
                j--;
            }
        }
    }

    public void bubbleSort() {
        int nSwaps = 0;

        do {
            nSwaps = 0;

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                    nSwaps++;
                }
            }
        } while (nSwaps != 0);
    }

    public void quickSort() {
        quickSort(0, numbers.length - 1);
    }

    private void quickSort(int li, int re) {
        if (re > li) {
            int pivot = partition(li, re);
            quickSort(li, pivot + 1);
            quickSort(pivot + 1, re);
        }
    }

    private int partition(int li, int re) {
        int pivot = numbers[re];
        int i = li - 1;
        int k = re;

        do {
            do {
                i++;
            } while (numbers[i] < pivot);

            do {
                k--;
            } while (k >= li && numbers[k] > pivot);

            if (i < k) {
                int temp = numbers[i];
                numbers[i] = numbers[k];
                numbers[k] = temp;
            }
        } while (i < k);

        int temp = numbers[i];
        numbers[i] = numbers[re];
        numbers[re] = temp;

        return i + 1;
    }

    public String toString() {
        String output = "";
        int maxIndex = numbers.length - 10;

        if (numbers.length > 20) {
            for (int i = 0; i < 10; i++) {
                output += String.format("%d", numbers[i]);

                if ((i + 1) % 10 != 0) {
                    output += String.format(", ");
                }
            }

            output += String.format("\n...\n");

            for (int i = maxIndex; i < numbers.length; i++) {
                output += String.format("%d", numbers[i]);

                if ((i + 1) % numbers.length != 0) {
                    output += String.format(", ");
                }
            }
        } else {
            for (int i = 0; i < numbers.length; i++) {
                output += String.format("%d", numbers[i]);

                if ((i + 1) % 10 != 0) {
                    output += String.format(", ");
                }

                if ((i + 1) % 10 == 0) {
                    output += String.format("\n");
                }
            }
        }

        return output;
    }
}
