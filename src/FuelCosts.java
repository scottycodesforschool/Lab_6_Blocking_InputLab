import java.util.Scanner; // Required for user input

public class FuelCosts {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Create a Scanner object for input

        // Declare variables for inputs and calculations
        double gallonsInTank = 0;       // Stores the number of gallons of gas
        double fuelEfficiencyMPG = 0;   // Stores the fuel efficiency in miles per gallon
        double pricePerGallon = 0;      // Stores the price of gas per gallon

        double costPer100Miles;         // Stores the calculated cost to drive 100 miles
        double distanceWithFullTank;    // Stores the calculated distance car can go with full tank

        boolean validInput; // Flag to control the input do-while loops
        String trash;       // Used to consume invalid input strings

        System.out.println("--- Fuel Costs Calculator ---");

        // --- Input 1: Gallons of gas in the tank ---
        do {
            System.out.print("Enter the number of gallons of gas in the tank: ");
            if (in.hasNextDouble()) {
                gallonsInTank = in.nextDouble();
                in.nextLine(); // Consume the newline character
                if (gallonsInTank >= 0) { // Basic validation: gallons should not be negative
                    validInput = true;
                } else {
                    System.out.println("\nInvalid input! Gallons cannot be negative. Please enter a non-negative number.");
                    validInput = false;
                }
            } else {
                trash = in.nextLine(); // Read and discard invalid input
                System.out.println("\nInvalid input! You entered '" + trash + "'. Please enter a valid number for gallons.");
                validInput = false;
            }
        } while (!validInput); // Loop until valid, non-negative gallons are entered

        // --- Input 2: Fuel efficiency in miles per gallon ---
        do {
            System.out.print("Enter the fuel efficiency in miles per gallon (MPG): ");
            if (in.hasNextDouble()) {
                fuelEfficiencyMPG = in.nextDouble();
                in.nextLine(); // Consume the newline character
                if (fuelEfficiencyMPG > 0) { // Validation: MPG must be positive
                    validInput = true;
                } else {
                    System.out.println("\nInvalid input! Fuel efficiency must be greater than zero. Please enter a positive number.");
                    validInput = false;
                }
            } else {
                trash = in.nextLine(); // Read and discard invalid input
                System.out.println("\nInvalid input! You entered '" + trash + "'. Please enter a valid number for MPG.");
                validInput = false;
            }
        } while (!validInput); // Loop until valid, positive MPG is entered

        // --- Input 3: Price of gas per gallon ---
        do {
            System.out.print("Enter the price of gas per gallon: $");
            if (in.hasNextDouble()) {
                pricePerGallon = in.nextDouble();
                in.nextLine(); // Consume the newline character
                if (pricePerGallon >= 0) { // Validation: price should not be negative
                    validInput = true;
                } else {
                    System.out.println("\nInvalid input! Price cannot be negative. Please enter a non-negative number.");
                    validInput = false;
                }
            } else {
                trash = in.nextLine(); // Read and discard invalid input
                System.out.println("\nInvalid input! You entered '" + trash + "'. Please enter a valid number for price.");
                validInput = false;
            }
        } while (!validInput); // Loop until valid, non-negative price is entered

        // --- Calculations ---
        // Cost to drive 100 miles: (gallons needed for 100 miles) * price per gallon
        // Gallons needed for 100 miles = 100 / fuelEfficiencyMPG
        costPer100Miles = (100 / fuelEfficiencyMPG) * pricePerGallon;

        // How far the car can go with a full tank of gas: gallons in tank * MPG
        distanceWithFullTank = gallonsInTank * fuelEfficiencyMPG;

        // --- Output Results ---
        System.out.println("\n--- Fuel Cost Results ---");
        System.out.printf("Gallons in tank: %.2f%n", gallonsInTank); // Formatted to 2 decimal places
        System.out.printf("Fuel efficiency: %.2f MPG%n", fuelEfficiencyMPG);
        System.out.printf("Price per gallon: $%.2f%n", pricePerGallon);
        System.out.println("-------------------------");
        System.out.printf("Cost to drive 100 miles: $%.2f%n", costPer100Miles);
        System.out.printf("Distance car can go with a full tank: %.2f miles%n", distanceWithFullTank);

        in.close(); // Close the scanner to prevent resource leaks
    }
}