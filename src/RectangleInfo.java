import java.util.Scanner; // Required for user input
import java.lang.Math;   // Required for Math.sqrt and Math.pow

public class RectangleInfo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Create a Scanner object for input

        // Declare variables for inputs and calculations
        double width = 0;       // Stores the width of the rectangle
        double height = 0;      // Stores the height of the rectangle

        double area;            // Stores the calculated area
        double perimeter;       // Stores the calculated perimeter
        double diagonal;        // Stores the calculated length of the diagonal

        boolean validInput; // Flag to control the input do-while loops
        String trash;       // Used to consume invalid input strings

        System.out.println("--- Rectangle Information Calculator ---");

        // --- Input 1: Rectangle Width ---
        do {
            System.out.print("Enter the width of the rectangle: ");
            if (in.hasNextDouble()) {
                width = in.nextDouble();
                in.nextLine(); // Consume the newline character
                if (width > 0) { // Validation: Width must be positive
                    validInput = true;
                } else {
                    System.out.println("\nInvalid input! Width must be greater than zero. Please enter a positive number.");
                    validInput = false;
                }
            } else {
                trash = in.nextLine(); // Read and discard invalid input
                System.out.println("\nInvalid input! You entered '" + trash + "'. Please enter a valid positive number for width.");
                validInput = false;
            }
        } while (!validInput); // Loop until valid, positive width is entered

        // --- Input 2: Rectangle Height ---
        do {
            System.out.print("Enter the height of the rectangle: ");
            if (in.hasNextDouble()) {
                height = in.nextDouble();
                in.nextLine(); // Consume the newline character
                if (height > 0) { // Validation: Height must be positive
                    validInput = true;
                } else {
                    System.out.println("\nInvalid input! Height must be greater than zero. Please enter a positive number.");
                    validInput = false;
                }
            } else {
                trash = in.nextLine(); // Read and discard invalid input
                System.out.println("\nInvalid input! You entered '" + trash + "'. Please enter a valid positive number for height.");
                validInput = false;
            }
        } while (!validInput); // Loop until valid, positive height is entered

        // --- Calculations ---
        area = width * height;
        perimeter = 2 * (width + height);
        // Calculate diagonal using Pythagorean theorem: sqrt(width^2 + height^2)
        diagonal = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));

        // --- Output Results ---
        System.out.println("\n--- Rectangle Dimensions and Calculations ---");
        System.out.printf("Width: %.2f%n", width);
        System.out.printf("Height: %.2f%n", height);
        System.out.println("------------------------------------------");
        System.out.printf("Area: %.2f%n", area);
        System.out.printf("Perimeter: %.2f%n", perimeter);
        System.out.printf("Diagonal Length: %.2f%n", diagonal);

        in.close(); // Close the scanner to prevent resource leaks
    }
}