import java.util.Scanner;

class HandshakeCalculator 
{
	public static int calculateHandshakes(int n)
	{
        	return (n * (n - 1)) / 2;
        }

    public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int numberOfStudents = sc.nextInt();
        int handshakes = calculateHandshakes(numberOfStudents);
        System.out.println(handshakes);
       }
}
