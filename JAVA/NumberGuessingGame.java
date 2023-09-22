import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // Generate a random number between 1 and 100
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;

        // Initialize variables
        int attempts = 0;
        boolean guessedCorrectly = false;

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Game loop
        while (!guessedCorrectly && attempts < 10) {
            System.out.print("Guess a number between 1 and 100: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == randomNumber) {
                guessedCorrectly = true;
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
            } else if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        // If the player couldn't guess the number within the given attempts
        if (!guessedCorrectly) {
            System.out.println("Sorry, you couldn't guess the number. The correct number was " + randomNumber + ".");
        }

        // Close the Scanner object
        scanner.close();
    }
}
