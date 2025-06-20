import java.util.Scanner;

class FactorAnalyzer {

    public static int[] findFactors(int number)
	{
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    public static int findSum(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }

    public static long findProduct(int[] array) {
        long product = 1;
        for (int num : array) {
            product *= num;
        }
        return product;
    }

    public static double findSumOfSquares(int[] array) {
        double sumSquares = 0;
        for (int num : array) {
            sumSquares += Math.pow(num, 2);
        }
        return sumSquares;
    }

    public static void main(String[] args)
	{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find its factors: ");
        int number = scanner.nextInt();

        int[] factors = findFactors(number);

        System.out.println("Factors of " + number + ":");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }

        System.out.println("\nSum of factors: " + findSum(factors));
        System.out.println("Product of factors: " + findProduct(factors));
        System.out.println("Sum of squares of factors: " + findSumOfSquares(factors));
        }
}
