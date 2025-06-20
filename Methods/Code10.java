import java.util.Scanner;

class ChocolateDivider
{
    public static int[] findRemainderAndQuotient(int number, int divisor) 
	{
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
        }

    public static void main(String[] args)
	{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();
        System.out.print("Enter the number of children: ");
        int numberOfChildren = scanner.nextInt();

        if (numberOfChildren == 0) {
            System.out.println("Cannot divide by zero children.");
            return;
        }

        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);
        System.out.println("Each child will get " + result[0] + " chocolates");
        System.out.println("Remaining chocolates: " + result[1]);
       }
}
