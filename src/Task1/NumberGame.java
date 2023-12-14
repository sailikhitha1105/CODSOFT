package Task1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Game!");

        do {
            try {
                int targetNumber = generateRandomNumber(lowerBound, upperBound);
                int attempts = 0;

                System.out.println("Round " + (rounds + 1));
                System.out.println("Guess the Random number between " + lowerBound + " and " + upperBound);

                while (attempts < maxAttempts) {
                    System.out.print("guess the number (or type 'quit' to end the game): ");

                    while (!scanner.hasNextInt() && !scanner.hasNext("quit")) {
                        System.out.println("Please enter a valid number or type 'quit' to end the game.");
                        scanner.next();
                    }

                    if (scanner.hasNext("quit")) {
                        System.out.println("Thanks for playing! The game ends here.");
                        System.exit(0);
                    }

                    int userGuess = scanner.nextInt();

                    if (userGuess <= 0 || userGuess > 100) {
                        System.out.println("Please enter a valid number between 1 and 100 for your guess.");
                        continue; 
                    }

                    attempts++;

                    if (userGuess == targetNumber) {
                        System.out.println("Congratulations! You guessed the correct Random number in " + attempts + " attempts.");
                        totalAttempts += attempts;
                        break;
                    } else if (userGuess < targetNumber) {
                        System.out.println("Too low. Try again!  attempts left: " + (maxAttempts - attempts) );
                        System.out.println();
                    } else {
                        System.out.println("Too high. Try again!  attempts left: " + (maxAttempts - attempts) );
                        System.out.println();
                    }
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've run out of attempts.");
                    System.out.println();
                }

                System.out.println("The random generated number was: " + targetNumber);

                rounds++;

                String playAgainResponse;
                do {
                	System.out.println();
                    System.out.println("Do you want to play once more? (yes/no): ");
                    playAgainResponse = scanner.next().toLowerCase();

                    if ("yes".equals(playAgainResponse)) {
                        break;
                    } else if ("no".equals(playAgainResponse)) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter 'yes' to continue or 'no' to end the game.");
                    }
                } while (true);

                if ("no".equals(playAgainResponse)) {
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); 
            } catch (Exception e) {
                System.out.println("An unexpected error occurred. Exiting the game.");
                break;
            }

        } while (true);

        System.out.println("Game Over. You have played " + rounds + " rounds, and your average attempts per round is: " + (totalAttempts / rounds));
        scanner.close();
    }

    private static int generateRandomNumber(int lowerBound, int upperBound) {
        return new Random().nextInt(upperBound - lowerBound + 1) + lowerBound;
    }
}
