public class FormatterUI {

    public static void main(String[] args) {
        Formatter formatter = new Formatter();

        System.out.println(formatter.join("-", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
        formatter.clearOutput();
        System.out.println(formatter.join(",", 1, 2, 3, 4));
        formatter.clearOutput();
        System.out.println(formatter.join(",", 1));
        formatter.clearOutput();
        System.out.println(formatter.join(" - ", 0.50, 0.33, 0.25));
        formatter.clearOutput();
        System.out.println(formatter.time("hh:mm:ss", 12, 20, 30));
        formatter.clearOutput();
        System.out.println(formatter.time("hh:mm", 10, 45));
        formatter.clearOutput();
        System.out.println(formatter.time("HH:mm", 6, 25));
        formatter.clearOutput();
        System.out.println(formatter.time("HH:mm:ss", 11, 33, 0));
        formatter.clearOutput();
        System.out.println(formatter.join('&', "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
        formatter.clearOutput();
        System.out.println(formatter.join(',', 1, 2, 3, 4));
        formatter.clearOutput();
        System.out.println(formatter.join('/', 0.50, 0.33, 0.25));
        formatter.clearOutput();
        System.out.println(formatter.date("AM", 12, 20, 30));
        formatter.clearOutput();
        System.out.println(formatter.date("PM", 8, 45, 10));
        formatter.clearOutput();
    }
}
