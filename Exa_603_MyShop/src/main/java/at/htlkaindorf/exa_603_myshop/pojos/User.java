package at.htlkaindorf.exa_603_myshop.pojos;

public class User {
    private String name;
    private String street;
    private int number;
    private int zipCode;
    private String city;
    private String email;

    public User(String name, String street, int number, int zipCode, String city, String email) {
        this.name = name;
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
        this.email = email;
    }

    public String toHTML() {
        return "<section id=\"invoiceAddress\">\n" +
                " <h1>" + name + "</h1>\n" +
                " <p>" + street + number + "</p>\n" +
                " <p>" + zipCode + city + "</p>\n" +
                " <p>" + email + "</p>\n" +
                " </section>";
    }
}
