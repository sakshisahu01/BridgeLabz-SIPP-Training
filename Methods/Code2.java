import java.util.Scanner;

class DivisionCalculator
{
	public static int[] findRemainderAndQuotient(int number, int divisor)
	{
        	int[] result = new int[2];
        	result[0] = number / divisor;
        	result[1] = number % divisor;
        	return result;
        }

    public static void main(String[] args)
	{
        	Scanner sc = new Scanner(System.in);
        	int number = sc.nextInt();
        	int divisor = sc.nextInt();
        	int[] result = findRemainderAndQuotient(number, divisor);
        	System.out.println("Quotient: " + result[0]);
        	System.out.println("Remainder: " + result[1]);
        }
}
