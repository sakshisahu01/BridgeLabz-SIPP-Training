import java.util.Scanner;

public class SumNaturalNumbersComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n > 0) {
            int sumLoop = 0;
            int i = 1;
            while (i <= n) {
                sumLoop += i;
                i++;
            }

            int sumFormula = n * (n + 1) / 2;

            System.out.println("Sum using while loop: " + sumLoop);
            System.out.println("Sum using formula: " + sumFormula);
            System.out.println("Are both results equal? " + (sumLoop == sumFormula));
        } else {
            System.out.println("The number " + n + " is not a natural number");
        }
    }
}
