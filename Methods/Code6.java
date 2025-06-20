import java.util.Scanner;

class SumOfNaturalNumbers
{
	public static int findSum(int n)
	{
        	int sum = 0;
        	for (int i = 1; i <= n; i++)
		{
            		sum += i;
                }
        return sum;
        }

	public static void main(String[] args)
	{
        	Scanner sc = new Scanner(System.in);
        	System.out.print("Enter a positive integer: ");
        	int n = sc.nextInt();

       		if (n > 0)
			{		
            			int sum = findSum(n);
            			System.out.println("Sum of first " + n + " natural numbers is: " + sum);
        		} 
			else 
			{
            			System.out.println("Please enter a positive integer.");
       	 		}

        sc.close();
        }
}
