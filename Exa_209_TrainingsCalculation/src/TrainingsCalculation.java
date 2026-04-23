import java.util.Random;

public class TrainingsCalculation {

    private int number1;
    private int number2;
    private char operator;
    private int result;
    private byte difficulty;

    public TrainingsCalculation(byte difficulty) {
        Random random = new Random();
        this.difficulty = difficulty;

        if (difficulty == 1) {
            number1 = random.nextInt(1, 11);
            number2 = random.nextInt(1, 11);
        } else if (difficulty == 2) {
            number1 = random.nextInt(1, 101);
            number2 = random.nextInt(1, 101);
        }

        char [] operators = {'+', '-', '*', '/'};

        operator = operators[random.nextInt(operators.length)];

        switch (operator) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
        }
    }

    public String toString() {
        return String.format("%d %s %d = ?", number1, operator, number2);
    }

    public int getResult() {
        return result;
    }
}
