import java.util.Scanner;

class NumberChecker
{
	public static int checkNumber(int number)
	{
        	if (number > 0) return 1;
        	else if (number < 0) return -1;
        	else return 0;
        }

    public static void main(String[] args)
	{
        	Scanner sc = new Scanner(System.in);
        	int number = sc.nextInt();
        	int result = checkNumber(number);
        	System.out.println(result);
        }
}
