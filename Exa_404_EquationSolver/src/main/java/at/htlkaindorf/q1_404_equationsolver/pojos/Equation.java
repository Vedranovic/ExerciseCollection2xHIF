package at.htlkaindorf.q1_404_equationsolver.pojos;

public class Equation {

    public static int [] parse(String equation) {
        String replaced = equation.replace("x²", "#").replace("x", "#");

        String [] parts = replaced.split("#");
        int [] coefficients = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            if (!((parts[i].equals("-") || parts[i].equals("+") || parts[i].isBlank()))) {
                coefficients[i] = Integer.parseInt(parts[i]);
            } else {
                coefficients[i] = 1;
            }
        }

        return coefficients;
    }

    public static double [] solve(int aCoeff, int bCoeff, int cCoeff) {
        double [] resultX = new double[2];
        double equation = Math.pow(bCoeff, 2.0) - 4 * aCoeff * cCoeff;

        resultX[0] = (-bCoeff + Math.sqrt(equation)) / (2 * aCoeff);
        resultX[1] = (-bCoeff - Math.sqrt(equation)) / (2 * aCoeff);

        return resultX;
    }
}
