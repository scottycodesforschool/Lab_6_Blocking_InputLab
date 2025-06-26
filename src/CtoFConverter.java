import java.util.Scanner; // Required for user input

public class CtoFConverter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Create a Scanner object for input
        double celsius = 0; // Variable to store the Celsius temperature
        double fahrenheit = 0; // Variable to store the Fahrenheit temperature
        boolean validInput = false; // Flag to control the input loop
        String trash = ""; // Used to consume invalid input

        System.out.println("--- Celsius to Fahrenheit Converter ---");

        // Use a do-while loop to ensure the input prompt runs at least once
        do {
            System.out.print("Enter the temperature in Celsius: ");

            if (in.hasNextDouble()) {
                celsius = in.nextDouble(); // Read the valid double input
                in.nextLine(); // Consume the newline character left in the buffer
                validInput = true; // Set flag to true to exit the loop
            } else {
                trash = in.nextLine(); // Read and discard the invalid input
                System.out.println("\nInvalid input! You entered '" + trash + "'. Please enter a valid number.");
                // validInput remains false, so the loop will continue
            }
        } while (!validInput); // The loop continues as long as input is NOT valid

        // Once a valid Celsius temperature is obtained, perform the conversion
        fahrenheit = (celsius * 9 / 5) + 32;

        // Display the result
        System.out.println("\n--- Conversion Result ---");
        System.out.println("The temperature in Celsius: " + celsius + "°C");
        System.out.println("The equivalent temperature in Fahrenheit: " + fahrenheit + "°F");

        in.close(); // Close the scanner to release resources
    }
}