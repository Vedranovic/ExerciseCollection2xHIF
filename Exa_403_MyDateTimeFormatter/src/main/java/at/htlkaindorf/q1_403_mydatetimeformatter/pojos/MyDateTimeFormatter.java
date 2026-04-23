package at.htlkaindorf.q1_403_mydatetimeformatter.pojos;

public class MyDateTimeFormatter {

    public static String format(String formatStr, int... values) {
        int requiredLength = switch (formatStr) {
            case "D" -> 3;
            case "T" -> 2;
            case "DT" -> 5;
            default -> throw new IllegalArgumentException("Invalid format string: " + formatStr);
        };

        if (values.length != requiredLength) {
            throw new NumberFormatException(
                    "Invalid number of parameters. Expected: " + requiredLength + ", Provided: " + values.length
            );
        }

        return switch (formatStr) {
            case "D" -> String.format("%02d.%02d.%04d", values[0], values[1], values[2]);
            case "T" -> String.format("%02d:%02d", values[0], values[1]);
            case "DT" -> String.format("%02d.%02d.%04d - %02d:%02d",
                    values[0], values[1], values[2], values[3], values[4]);
            default -> throw new IllegalArgumentException("Invalid format string.");
        };
    }
}