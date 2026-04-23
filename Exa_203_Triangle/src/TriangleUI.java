// import java.util.Scanner;

public class TriangleUI {

//    public int readSides(String side, Scanner scan) {
//        System.out.printf("Enter side %s: ", side);
//
//        return scan.nextInt();
//    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        triangle.sortSides();
        triangle.determineType();
        System.out.println(triangle);
    }
}
