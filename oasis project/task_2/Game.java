import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char playAgain;

        do {
            playGame(sc);
            System.out.println("Do you want to play again? (y/n): ");
            playAgain = sc.next().charAt(0);
        } while (playAgain == 'y' || playAgain == 'Y');

        sc.close();
        System.out.println("Thanks for playing!");
    }

    public static void playGame(Scanner sc) {
        Random rand = new Random();
        int minRange = 1;
        int maxRange = 100;
        int randomNumber = rand.nextInt(maxRange - minRange + 1) + minRange;
        int tryCount = 0;
        int maxTries = 10; // Adjust this value as needed

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange);

        while (tryCount < maxTries) {
            System.out.println("Enter your guess(" + minRange + "-" + maxRange + "): ");
            int playerGuess = sc.nextInt();
            tryCount++;

            if (playerGuess == randomNumber) {
                System.out.println("Correct!! You got it.");
                System.out.println("It took you " + tryCount + " tries.");
                break;
            } else if (playerGuess < randomNumber) {
                System.out.println("Nope! The number is higher. Guess Again");
            } else {
                System.out.println("Nope! The number is lower. Guess Again");
            }
        }

        if (tryCount >= maxTries) {
            System.out.println("Sorry, you've run out of tries. The correct number was " + randomNumber);
        }
    }
}
