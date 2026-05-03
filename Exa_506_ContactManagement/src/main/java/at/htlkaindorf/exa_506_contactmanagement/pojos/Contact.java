package at.htlkaindorf.exa_506_contactmanagement.pojos;

public class Contact implements Comparable<Contact> {
    private String name;
    private String number;
    private boolean isPrivate;

    public Contact(String name, String number, boolean isPrivate) {
        this.name = name;
        this.number = number;
        this.isPrivate = isPrivate;
    }

    public String toString() {
        return String.format("%s %20s", name, getFormattedNumber());
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

    @Override
    public int compareTo(Contact o) {
        return this.name.compareTo(o.name);
    }
}
