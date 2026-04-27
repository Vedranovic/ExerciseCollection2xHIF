package at.htlkaindorf.exa_502_numbersortingv2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataController {
    private List<Integer> numbers;

    public DataController() {
        this.numbers = new ArrayList<>();
    }

    public void generateNumbers(int numOfElements) {
        Random random = new Random();

        numbers.clear();

        for (int i = 0; i < numOfElements; i++) {
            numbers.add(i, random.nextInt(0, numOfElements + 1));
        }
    }

    public void selectionSort() {
        for (int i = 0; i < numbers.size(); i++) {
            int minIndex = i;

            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(minIndex) > numbers.get(j)) {
                    minIndex = j;
                }
            }

            int temp = numbers.get(i);
            numbers.set(i, numbers.get(minIndex));
            numbers.set(minIndex, temp);
        }
    }

    public void insertionSort() {
        for (int i = 1; i < numbers.size(); i++) {
            int key = numbers.get(i);
            int j = i - 1;

            while (j >= 0 && key < numbers.get(j)) {
                numbers.set(j + 1, numbers.get(j));
                j -= 1;
            }

            numbers.set(j + 1, key);
        }
    }

    public void bubbleSort() {
        int nSwaps;

        do {
            nSwaps = 0;

            for (int i = 0; i < numbers.size() - 1; i++) {
                if (numbers.get(i) > numbers.get(i + 1)) {
                    int temp = numbers.get(i);
                    numbers.set(i, numbers.get(i + 1));
                    numbers.set(i + 1, temp);
                    nSwaps++;
                }
            }
        } while (nSwaps != 0);
    }

    public String toString() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < numbers.size(); i++) {
            output.append(numbers.get(i));

            if ((i + 1) % 10 == 0) {
                output.append("\n");
            } else {
                output.append(", ");
            }
        }

        return output.toString();
    }
}
