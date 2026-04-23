import java.util.Scanner;

public class AddressUI {

    public Address createAddress() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        String street = "";
        int number = 0;
        String city = "";
        int zipCode = 0;

        System.out.print("Enter street: ");
        street = scanner.next();
        System.out.print("Enter number: ");
        number = scanner.nextInt();
        System.out.print("Enter city: ");
        city = scanner.next();
        System.out.print("Enter zipcode: ");
        zipCode = scanner.nextInt();

        Address address = new Address(street, number, city, zipCode);

        return address;
    }

    public void changeAddress(Address address) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        char choice = 'a';

        System.out.println("Would you like to to change?");
        System.out.println("(A) street: " + address.getStreet());
        System.out.println("(B) number: " + address.getNumber());
        System.out.println("(C) city: " + address.getCity());
        System.out.println("(D) zipcode: " + address.getZipCode());

        System.out.print("");
        choice = scanner.next().charAt(0);

        System.out.print("Enter new value: ");

        switch (choice) {
            case 'a', 'A':
                address.setStreet(scanner.next());
                break;
            case 'b', 'B':
                address.setNumber(scanner.nextInt());
                break;
            case 'c', 'C':
                address.setCity(scanner.next());
                break;
            case 'd', 'D':
                address.setZipCode(scanner.nextInt());
                break;
        }
    }

    public static void main(String[] args) {
        AddressUI ui = new AddressUI();
        Address address = ui.createAddress();
        System.out.println(address.toString());
        ui.changeAddress(address);
        System.out.println(address);
    }
}
