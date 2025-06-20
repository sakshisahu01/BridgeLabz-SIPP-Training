import java.util.Arrays;

class NumberChecker
{

    public static int countDigits(int number)
	{
        	return String.valueOf(number).length();
    	}

    public static int[] getDigits(int number)
	{
        	String str = String.valueOf(number);
        	int[] digits = new int[str.length()];
        	for (int i = 0; i < str.length(); i++)
            		digits[i] = str.charAt(i) - '0';
        	return digits;
   	 }

    public static int[] reverseArray(int[] array)
	{
        	int[] reversed = new int[array.length];
        	for (int i = 0; i < array.length; i++)
            		reversed[i] = array[array.length - 1 - i];
        	return reversed;
    	}

    public static boolean arraysEqual(int[] a, int[] b)
	{
        	return Arrays.equals(a, b);
    	}

    public static boolean isPalindrome(int number)
	{
        	int[] digits = getDigits(number);
        	int[] reversed = reverseArray(digits);
        	return arraysEqual(digits, reversed);
    	}

    public static boolean isDuckNumber(int number)
	{
        	int[] digits = getDigits(number);
        	for (int i = 1; i < digits.length; i++)
            		if (digits[i] == 0)
                		return true;
        	return false;
    	}

    public static void main(String[] args)
	{
        	int number1 = 12321;
        	int number2 = 1023;

        	System.out.println("Count of digits in " + number1 + ": " + countDigits(number1));
        	System.out.println("Digits of " + number1 + ": " + Arrays.toString(getDigits(number1)));
        	System.out.println("Reversed digits of " + number1 + ": " + Arrays.toString(reverseArray(getDigits(number1))));
        	System.out.println("Is " + number1 + " a palindrome? " + isPalindrome(number1));
        	System.out.println("Is " + number2 + " a duck number? " + isDuckNumber(number2));
        }
}
