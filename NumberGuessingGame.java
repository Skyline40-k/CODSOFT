import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int roundsWon = 0;
        String playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int numberToGuess = rand.nextInt(100) + 1; // Random number from 1 to 100
            int attempts = 5;
            boolean guessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between 1 and 100.");
            System.out.println("You have " + attempts + " attempts to guess it!");

            for (int i = 1; i <= attempts; i++) {
                System.out.print("Attempt " + i + ": Enter your guess: ");
                int userGuess = sc.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Correct! You've guessed the number in " + i + " attempt(s)!");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all your attempts. The number was: " + numberToGuess);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            sc.nextLine(); // consume newline
            playAgain = sc.nextLine().trim().toLowerCase();

        } while (playAgain.equals("yes"));

        System.out.println("\nGame Over! 🎮");
        System.out.println("Total rounds won: " + roundsWon);
        System.out.println("Thanks for playing!");
        sc.close();
    }
}
