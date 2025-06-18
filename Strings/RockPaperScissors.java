import java.util.*;

public class RockPaperScissors {

    public static String getComputerChoice() {
        int choice = (int)(Math.random() * 3);
        if (choice == 0) return "rock";
        else if (choice == 1) return "paper";
        else return "scissors";
    }

    public static String getWinner(String user, String computer) {
        if (user.equals(computer)) return "Draw";
        if ((user.equals("rock") && computer.equals("scissors")) ||
            (user.equals("scissors") && computer.equals("paper")) ||
            (user.equals("paper") && computer.equals("rock"))) return "User";
        return "Computer";
    }

    public static String[][] getStats(List<String[]> results) {
        int userWins = 0, computerWins = 0, draws = 0;
        for (String[] r : results) {
            if (r[2].equals("User")) userWins++;
            else if (r[2].equals("Computer")) computerWins++;
            else draws++;
        }
        int total = results.size();
        double userPercent = (userWins * 100.0) / total;
        double compPercent = (computerWins * 100.0) / total;

        String[][] stats = new String[3][3];
        stats[0] = new String[]{"Player", String.valueOf(userWins), String.format("%.2f%%", userPercent)};
        stats[1] = new String[]{"Computer", String.valueOf(computerWins), String.format("%.2f%%", compPercent)};
        stats[2] = new String[]{"Draws", String.valueOf(draws), "-"};
        return stats;
    }

    public static void displayResults(List<String[]> results, String[][] stats) {
        System.out.printf("%-10s %-10s %-10s\n", "Player", "Computer", "Winner");
        for (String[] r : results) {
            System.out.printf("%-10s %-10s %-10s\n", r[0], r[1], r[2]);
        }
        System.out.println("\nStatistics:");
        System.out.printf("%-10s %-10s %-10s\n", "Name", "Wins", "Win %");
        for (String[] s : stats) {
            System.out.printf("%-10s %-10s %-10s\n", s[0], s[1], s[2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String[]> results = new ArrayList<>();
        System.out.print("Enter number of games: ");
        int games = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < games; i++) {
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String user = sc.nextLine().toLowerCase();
            String computer = getComputerChoice();
            String winner = getWinner(user, computer);
            results.add(new String[]{user, computer, winner});
        }
        String[][] stats = getStats(results);
        displayResults(results, stats);
    }
}
