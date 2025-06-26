import java.util.Scanner; // Required for user input
import java.util.Random;  // Required for generating random numbers

public class HighorLow {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Create a Scanner object for input
        Random rand = new Random();      // Create a Random object for number generation

        // Generate a random integer between 1 and 10 (inclusive)
        // rand.nextInt(10) generates numbers from 0 to 9.
        // Adding 1 shifts the range to 1 to 10.
        int randomNumber = rand.nextInt(10) + 1;

        int userGuess = 0;              // Variable to store the user's guess
        boolean validInput = false;     // Flag to control the input do-while loop
        String trash;                   // Used to consume invalid input strings

        System.out.println("--- High or Low Guessing Game ---");
        System.out.println("I'm thinking of a number between 1 and 10.");

        // --- Input: User's Guess ---
        // Use a do-while loop to ensure the prompt runs at least once
        // and keeps looping until a valid guess (int between 1 and 10) is entered.
        do {
            System.out.print("Enter your guess (1-10): ");
            if (in.hasNextInt()) {
                userGuess = in.nextInt();
                in.nextLine(); // Consume the newline character

                // Validate if the guess is within the desired range
                if (userGuess >= 1 && userGuess <= 10) {
                    validInput = true; // Guess is valid, exit the loop
                } else {
                    System.out.println("\nInvalid guess! Your guess must be between 1 and 10. Please try again.");
                    validInput = false; // Guess is out of range, continue loop
                }
            } else {
                trash = in.nextLine(); // Read and discard invalid input
                System.out.println("\nInvalid input! You entered '" + trash + "'. Please enter a whole number (1-10).");
                validInput = false; // Input is not an int, continue loop
            }
        } while (!validInput); // Loop continues as long as input is NOT valid

        // --- Display Results ---
        System.out.println("\n--- Game Result ---");
        System.out.println("The random number was: " + randomNumber);
        System.out.println("Your guess was: " + userGuess);

        // Compare the guess with the random number
        if (userGuess == randomNumber) {
            System.out.println("Result: ON THE MONEY! You guessed correctly!");
        } else if (userGuess > randomNumber) {
            System.out.println("Result: HIGH! Your guess was too high.");
        } else { // userGuess < randomNumber
            System.out.println("Result: LOW! Your guess was too low.");
        }

        in.close(); // Close the scanner to prevent resource leaks
    }
}