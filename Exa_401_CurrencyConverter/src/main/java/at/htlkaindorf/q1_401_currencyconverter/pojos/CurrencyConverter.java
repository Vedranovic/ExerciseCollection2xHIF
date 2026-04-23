package at.htlkaindorf.q1_401_currencyconverter.pojos;

public class CurrencyConverter {
    public double euroToDollar(double euro) {
        return euro * 1.10;
    }

    public double dollarToEuro(double dollar) {
        return dollar * 0.91;
    }
}
