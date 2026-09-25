import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static final String[] OPTIONS = {"rock", "paper", "scissors"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int playerScore = 0, computerScore = 0;

        System.out.println("=== Rock, Paper, Scissors — Best of 3 ===");

        while (playerScore < 2 && computerScore < 2) {
            System.out.print("Your move (rock/paper/scissors): ");
            String playerMove = scanner.nextLine().trim().toLowerCase();

            // Validation de la saisie : on redemande si le coup est invalide
            if (!isValidMove(playerMove)) {
                System.out.println("Invalid move! Please type rock, paper or scissors.");
                continue;
            }

            String computerMove = OPTIONS[random.nextInt(OPTIONS.length)];
            System.out.println("Computer chose: " + computerMove);

            String result = getResult(playerMove, computerMove);
            System.out.println(result);

            if (result.equals("You win!")) playerScore++;
            else if (result.equals("Computer wins!")) computerScore++;

            System.out.println("Score — You: " + playerScore + " | Computer: " + computerScore);
        }

        System.out.println(playerScore > computerScore ? "You win the match!" : "Computer wins the match!");
        scanner.close();
    }

    private static boolean isValidMove(String move) {
        return Arrays.asList(OPTIONS).contains(move);
    }

    private static String getResult(String player, String computer) {
        if (player.equals(computer)) return "It's a tie!";
        boolean playerWins =
            (player.equals("rock") && computer.equals("scissors")) ||
            (player.equals("paper") && computer.equals("rock")) ||
            (player.equals("scissors") && computer.equals("paper"));
        return playerWins ? "You win!" : "Computer wins!";
    }
}