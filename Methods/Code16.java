import java.util.Scanner;

class NaturalNumberSum
{

    public static int recursiveSum(int n)
	{
        if (n == 1) return 1;
        return n + recursiveSum(n - 1);
        }

    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args)
	{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a valid natural number (greater than 0).");
            return;
        }

        int sumRecursive = recursiveSum(n);
        int sumFormula = formulaSum(n);

        System.out.println("Sum using recursion: " + sumRecursive);
        System.out.println("Sum using formula: " + sumFormula);

        if (sumRecursive == sumFormula) {
            System.out.println("Both methods produce the same result.");
        } else {
            System.out.println("There is a discrepancy between the two methods.");
        }
    }
}
