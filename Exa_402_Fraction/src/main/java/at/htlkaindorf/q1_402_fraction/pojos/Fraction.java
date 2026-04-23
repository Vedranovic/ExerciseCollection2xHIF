package at.htlkaindorf.q1_402_fraction.pojos;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void shorten() {
        int ogNumerator = numerator;
        int ogDenominator = denominator;

        while (numerator != denominator) {
            if (numerator > denominator) {
                numerator = numerator - denominator;
            } else {
                denominator = denominator - numerator;
            }
        }

        int ggT = numerator;
        numerator = ogNumerator;
        denominator = ogDenominator;

        numerator /= ggT;
        denominator /= ggT;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}
