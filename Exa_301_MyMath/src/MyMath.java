public class MyMath {

    private static final double PI = 3.14159265;

    public static int abs(int a) {
        if (a < 0) {
            a *= (-1);
        }

        return a;
    }

    public static int min(int a, int b, int c) {
        int min = a;

        min = min > b ? b : min;
        min = min > c ? c : min;

        return min;
    }

    public static int max(int a, int b, int c) {
        int max = a;

        max = max < b ? b : max;
        max = max < c ? c : max;

        return max;
    }

    public static double power(double base, int exponent) {
        double power = 1.0;

        for (int i = 0; i < exponent; i++) {
            power *= base;
        }

        return power;
    }

    public static double round(double value, int positions) {
        long power = 1;

        for (int i = 0; i < positions; i++) {
            power *= 10;
        }
        value *= power;

        double roundDecider = (value * 10) % 10;

        if (roundDecider < 5) {
            value = (int)value;
        } else {
            value += 0.5;
            value = (int)value;
        }

        return value;
    }

    public static long faculty(int number) {
        long faculty = 1;

        for (int i = 0; i < number; i++) {
            faculty *= (i + 1);
        }

        return faculty;
    }

    public static double sin(double x) {
        double result = x;
        int exp = 3;

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                result -= (power(x, exp) / faculty(exp));
            } else {
                result += (power(x, exp) / faculty(exp));
            }
            exp += 2;
        }

        return result;
    }

    public static double cos(double x) {
        double result = 1;
        int exp = 2;

        for(int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                result -= (power(x, exp) / faculty(exp));
            } else {
                result += (power(x, exp) / faculty(exp));
            }
            exp += 2;
        }

        return result;
    }
}
