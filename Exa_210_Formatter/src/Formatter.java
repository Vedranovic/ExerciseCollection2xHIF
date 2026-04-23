public class Formatter {

    private String output;

    public Formatter() {
        output = "";
    }

    public String join(String delim, String... vars) {
        for (int i = 0; i < vars.length; i++) {
            output += vars[i];

            if ((i + 1) % vars.length != 0) {
                output += delim;
            }
        }

        return output;
    }

    public String join(String delim, int... vars) {
        for (int i = 0; i < vars.length; i++) {
            output += vars[i];

            if ((i + 1) % vars.length != 0) {
                output += delim;
            }
        }

        return output;
    }

    public String join(String delim, double... vars) {
        for (int i = 0; i < vars.length; i++) {
            output += vars[i];

            if ((i + 1) % vars.length != 0) {
                output += delim;
            }
        }

        return output;
    }

    public String join(char delim, String... vars) {
        for (int i = 0; i < vars.length; i++) {
            output += vars[i];

            if ((i + 1) % vars.length != 0) {
                output += " ";
                output += delim;
                output += " ";
            }
        }

        return output;
    }

    public String join(char delim, int... vars) {
        for (int i = 0; i < vars.length; i++) {
            output += vars[i];

            if ((i + 1) % vars.length != 0) {
                output += delim;
                output += " ";
            }
        }

        return output;
    }

    public String join(char delim, double... vars) {
        for (int i = 0; i < vars.length; i++) {
            output += vars[i];

            if ((i + 1) % vars.length != 0) {
                output += " ";
                output += delim;
                output += " ";
            }
        }

        return output;
    }

    public String date(String format, int... values) {
        output += String.format("%02d:%02d:%02d %s", values[0], values[1], values[2], format);

        return output;
    }

    public void clearOutput() {
        output = "";
    }

    public String time(String fmt, int... values) {
        switch (fmt) {
            case "hh:mm:ss":
                output += String.format("%02d:%02d:%02d", values[0], values[1], values[2]);
                break;
            case "HH:mm:ss":
                output += String.format("%02d:%02d:%02d PM", values[0], values[1], values[2]);
                break;
            case "hh:mm":
                output += String.format("%02d:%02d", values[0], values[1]);
                break;
            case "HH:mm":
                output += String.format("%02d:%02d AM", values[0], values[1]);
                break;
        }

        return output;
    }
}
