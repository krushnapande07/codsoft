import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Random randomGenerator = new Random();
        int playerScore = 0;  // Score based on attempts or rounds won

        boolean continuePlaying = true;
        
        while (continuePlaying) {
            int secretNumber = randomGenerator.nextInt(100) + 1;  // Generate random number between 1 and 100
            int guessCount = 0;
            int maxGuesses = 7;  // Limit the number of attempts
            boolean numberGuessed = false;

            System.out.println("I have picked a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + maxGuesses + " attempts.");

            // Loop for the guessing attempts
            while (guessCount < maxGuesses && !numberGuessed) {
                System.out.print("Enter your guess: ");
                int playerGuess = inputScanner.nextInt();
                guessCount++;

                if (playerGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    playerScore += (maxGuesses - guessCount + 1);  // Add score based on remaining attempts
                    numberGuessed = true;
                } else if (playerGuess < secretNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                // Check if user is out of attempts
                if (guessCount == maxGuesses && !numberGuessed) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was " + secretNumber + ".");
                }
            }

            // Ask if user wants to play another round
            System.out.print("Do you want to play another round? (yes/no): ");
            String userResponse = inputScanner.next();
            if (!userResponse.equalsIgnoreCase("yes")) {
                continuePlaying = false;
            }
        }

        // Display final score
        System.out.println("Game over! Your total score is: " + playerScore);
        inputScanner.close();
    }
}

