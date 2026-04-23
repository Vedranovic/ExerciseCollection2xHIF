package at.htlkaindorf.exa_603_myshop.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String  HTML_HEAD = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <link href=\"style.css\" type=\"text/css\" rel=\"stylesheet\">\n" +
            "</head>\n";
    private final String COMPANY_DATA = "<section id=\"companyData\">\n" +
            "        <h1>MyShop GmbH</h1>\n" +
            "        <p>Kaiser-Franz-Josef-Kai 3</p>\n" +
            "        <p>8010 Graz</p>\n" +
            "        <p>0316 35 099</p>\n" +
            "    </section>\n";
    private LocalDate date;
    private User user;
    private List<OrderLine> lines;

    public Order(LocalDate date, User user) {
        this.date = date;
        this.user = user;
        lines = new ArrayList<>();
    }

    public float getTotalPrice() {
        float totalPrice = 0.0f;

        for (OrderLine orderLine : lines) {
            totalPrice += orderLine.getLinePrice();
        }

        return totalPrice;
    }

    public String toHTML() {
        String output = HTML_HEAD;

        output += "<body>\n" +
                        COMPANY_DATA +
                    "<br><br>" +
                    user.toHTML() +
                "    <section id=\"invoiceDate\">\n" +
                "        <p>31.03.2025</p>\n" +
                "    </section>" +
                "   <br><br><br>" +
                "   <section id=\"products\">\n" +
                "        <table>";

        for (int i = 0; i < lines.size(); i++) {
            output += lines.get(i).toHTML();
        }

        output += "</table>\n" +
                "    </section>\n" +
                "    <br><br><br>\n" +
                "    <p>Thanks for your order!</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        return output;
    }
}
