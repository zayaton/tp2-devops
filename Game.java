import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] options = {"rock", "paper", "scissors"};
        Random random = new Random();

        System.out.println("=== Rock, Paper, Scissors ===");
        System.out.print("Your move (rock/paper/scissors): ");
        String playerMove = scanner.nextLine().trim().toLowerCase();

        String computerMove = options[random.nextInt(options.length)];
        System.out.println("Computer chose: " + computerMove);

        System.out.println(getResult(playerMove, computerMove));

        scanner.close();
    }

    private static String getResult(String player, String computer) {
        if (player.equals(computer)) {
            return "It's a tie!";
        }
        boolean playerWins =
            (player.equals("rock") && computer.equals("scissors")) ||
            (player.equals("paper") && computer.equals("rock")) ||
            (player.equals("scissors") && computer.equals("paper"));

        return playerWins ? "You win!" : "Computer wins!";
    }
}