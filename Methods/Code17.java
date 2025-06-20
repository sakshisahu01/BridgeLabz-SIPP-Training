import java.util.Scanner;
class NumberChecker {

    public static boolean isPositive(int number)
	{
        	return number >= 0;
        }

    public static boolean isEven(int number)
	{
        	return number % 2 == 0;
        }

    public static int compare(int num1, int num2)
	{
        	if (num1 > num2) return 1;
        	else if (num1 == num2) return 0;
       		else return -1;
        }

    public static void main(String[] args)
	{
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int number : numbers) {
            if (isPositive(number)) {
                System.out.print(number + " is positive and ");
                if (isEven(number)) {
                    System.out.println("even.");
                } else {
                    System.out.println("odd.");
                }
            } else {
                System.out.println(number + " is negative.");
            }
        }

        int comparison = compare(numbers[0], numbers[numbers.length - 1]);
        if (comparison == 1) {
            System.out.println("First element (" + numbers[0] + ") is greater than last element (" + numbers[numbers.length - 1] + ").");
        } else if (comparison == 0) {
            System.out.println("First element (" + numbers[0] + ") is equal to last element (" + numbers[numbers.length - 1] + ").");
        } else {
            System.out.println("First element (" + numbers[0] + ") is less than last element (" + numbers[numbers.length - 1] + ").");
        }
    }
}
