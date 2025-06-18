import java.util.*;

public class VotingEligibility {

    
    public static int[] generateAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(82) + 10; // Age between 10 and 91
        }
        return ages;
    }

    
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] results = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            results[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                results[i][1] = "false"; 
            } else if (ages[i] >= 18) {
                results[i][1] = "true";
            } else {
                results[i][1] = "false";
            }
        }
        return results;
    }

    
    public static void displayResults(String[][] results) {
        System.out.println("Age\tCan Vote");
        System.out.println("----\t--------");
        for (String[] row : results) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ages = generateAges(n);
        String[][] results = checkVotingEligibility(ages);
        displayResults(results);
    }
}
