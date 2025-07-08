import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    public static void main(String[] args) {
        // Create a random number generator
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
        int numberOfTries = 0;
        Scanner input = new Scanner(System.in);
        int guess;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("I have randomly chosen a number between 1 and 100.");
        System.out.println("Try to guess it!");

        // Game loop
        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            guess = input.nextInt();
            numberOfTries++;

            if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("Correct! You've guessed the number in " + numberOfTries + " tries.");
            }
        }
        input.close();
    }
}