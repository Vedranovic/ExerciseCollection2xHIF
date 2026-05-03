package at.htlkaindorf.exa_506_contactmanagement.pojos;

public class Contact {
    private String name;
    private long number;
    private boolean isPrivate;

    public Contact(String name, long number, boolean isPrivate) {
        this.name = name;
        this.number = number;
        this.isPrivate = isPrivate;
    }

    public String toString() {
        return ;
    }

    private String getFormattedNumber() {
        String[] parts = String.valueOf(number).split("/");
        StringBuilder formattedNumber = new StringBuilder("- " + parts[0] + " ");
        int counter = 1;

        for (char c : parts[1].toCharArray()) {
            formattedNumber.append(c);

            if (counter % 2 == 0) {
                formattedNumber.append(" ");
            }
            counter++;
        }

        return formattedNumber.toString();
    }

    public static void main(String[] args) {

    }
}
