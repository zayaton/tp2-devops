import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] options = {"rock", "paper", "scissors"};
        Random random = new Random();
        int playerScore = 0, computerScore = 0;

        System.out.println("=== Rock, Paper, Scissors — Best of 3 ===");

        while (playerScore < 2 && computerScore < 2) {
            System.out.print("Your move (rock/paper/scissors): ");
            String playerMove = scanner.nextLine().trim().toLowerCase();
            String computerMove = options[random.nextInt(options.length)];
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

    private static String getResult(String player, String computer) {
        if (player.equals(computer)) return "It's a tie!";
        boolean playerWins =
            (player.equals("rock") && computer.equals("scissors")) ||
            (player.equals("paper") && computer.equals("rock")) ||
            (player.equals("scissors") && computer.equals("paper"));
        return playerWins ? "You win!" : "Computer wins!";
    }
}