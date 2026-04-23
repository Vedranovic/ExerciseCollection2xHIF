import java.util.Random;

public class GradeBL {

    private int [] grades;
    private int [] gradeStatistics;
    private String [] gradeNames;
    private float avgValue;

    public GradeBL(int size) {
        Random random = new Random();

        this.grades = new int[size];
        this.gradeStatistics = new int[5];
        this.gradeNames = new String[5];

        for (int i = 0; i < grades.length; i++) {
            grades[i] = random.nextInt(1, 6);
        }

        gradeNames[0] = "Sehr gut";
        gradeNames[1] = "Gut";
        gradeNames[2] = "Befriedigend";
        gradeNames[3] = "Genuegend";
        gradeNames[4] = "Nicht Genuegend";
    }

    public void evaluation() {
        int counter = 1;

        for (int i = 0; i < gradeStatistics.length; i++) {
            for (int j = 0; j < grades.length; j++) {
                if (grades[j] == counter) {
                    gradeStatistics[i]++;
                }
            }

            counter++;
        }
    }

    public String toString() {
        String output = "";

        for (int i = 0; i < grades.length; i++) {
            output += grades[i];

            if ((i + 1) % 6 != 0) {
                output += ", ";
            } else {
                output += "\n";
            }
        }

        if (grades.length % 6 == 0) {
            output += "Evaluation:\n";
        } else {
            output += "\nEvaluation:\n";
        }

        output += String.format("Sehr Gut: %d\n", gradeStatistics[0]);
        output += String.format("Gut: %d\n", gradeStatistics[1]);
        output += String.format("Befriedigend: %d\n", gradeStatistics[2]);
        output += String.format("Genuegend: %d\n", gradeStatistics[3]);
        output += String.format("Nicht Genuegend: %d\n", gradeStatistics[4]);
        output += "--------------------\n";

        for (int gradeStatistic : gradeStatistics) {
            avgValue += gradeStatistic;
        }

        avgValue /= gradeStatistics.length;

        output += String.format("Average: %.2f", avgValue);

        return output;
    }
}
