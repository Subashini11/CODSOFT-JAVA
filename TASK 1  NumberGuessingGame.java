import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Prediction Challenge!");

        int points = 0;
        boolean continuePlaying = true;

        while (continuePlaying) {
            int secretNumber = random.nextInt(100) + 1;
            int guessCount = 0;
            int maxGuesses = 5;

            System.out.println("I have chosen a number between 1 and 100. Can you predict it?");

            while (guessCount < maxGuesses) {
                System.out.print("Enter your prediction: ");
                int userPrediction = scanner.nextInt();
                scanner.nextLine();

                guessCount++;

                if (userPrediction == secretNumber) {
                    System.out.println("Awesome! You predicted the number " + secretNumber + " in " + guessCount + " attempts.");
                    points++;
                    break;
                } else if (userPrediction < secretNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }
            }

            if (guessCount >= maxGuesses) {
                System.out.println("Oops! You've used all your attempts. The correct number was " + secretNumber + ".");
            }

            System.out.print("Would you like to play another round? (yes/no): ");
            String continueInput = scanner.nextLine();
            continuePlaying = continueInput.equalsIgnoreCase("yes");
        }

        System.out.println("Challenge over! Your total points: " + points);

        scanner.close();
    }
}
