import java.util.Random;
import java.util.Scanner;

// Class for the number guessing game
class NumberGuessingGame {
    private Random random;
    private Scanner scanner;
    private int score;

    public NumberGuessingGame() {
        random = new Random();
        scanner = new Scanner(System.in);
        score = 0;
    }

    public void playGame() {
        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;
            System.out.println("\nGuess the number between 1 and 100!");

            while (attempts < 10 && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score += (10 - attempts + 1);
                    guessedCorrectly = true;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all attempts! The correct number was: " + targetNumber);
            }

            System.out.println("Your current score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }
        System.out.println("Game Over! Your final score: " + score);
    }
}

// Main class to run the game
public class NumberGuessing {
    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.playGame();
    }
}
