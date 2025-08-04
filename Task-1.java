
import java.util.Random;
import java.util.Scanner

public class task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        int roundsPlayed = 0;

        while (true) {
            roundsPlayed++;
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = 10;
            int attempts = 0;

            System.out.println("Round " + roundsPlayed + ":");
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + attemptsLeft + " attempts to guess it.");

            while (attemptsLeft > 0) {
                System.out.print("Attempt " + (attempts + 1) + ": Guess the number: ");
                int guess = scanner.nextInt();
                attempts++;
                attemptsLeft--;

                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    totalScore += attempts;
                    break;
                }

                System.out.println("You have " + attemptsLeft + " attempts left.");
            }

            if (attemptsLeft == 0) {
                System.out.println("Sorry, you're out of attempts. The correct number was " + numberToGuess + ".");
                totalScore += 10;
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Game Over! You played " + roundsPlayed + " rounds.");
        System.out.println("Your total score is " + totalScore + " attempts.");
    }
}
