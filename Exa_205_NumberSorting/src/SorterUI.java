import java.util.Scanner;

public class SorterUI {
    private int numOfElements;

    public void readNumOfElements() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number of elements: ");
        numOfElements = scanner.nextInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SorterUI ui = new SorterUI();
        int choice = 0;

        ui.readNumOfElements();
        int numOfElements = ui.getNumOfElements();
        Sorter sorter = new Sorter(numOfElements);

        System.out.println("(1) Selection Sort");
        System.out.println("(2) Insertion Sort");
        System.out.println("(3) Bubble Sort");
        System.out.println("(4) Quick Sort");
        System.out.print("Please select the algorithm: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                sorter.selectionSort();
                break;
            case 2:
                sorter.insertionSort();
                break;
            case 3:
                sorter.bubbleSort();
                break;
            case 4:
                sorter.quickSort();
                break;
        }

        System.out.println(sorter);
    }

    public int getNumOfElements() {
        return numOfElements;
    }
}
