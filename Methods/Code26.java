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

    public static int sumOfDigits(int number)
	{
        	int[] digits = getDigits(number);
        	int sum = 0;
        	for (int d : digits)
            		sum += d;
        	return sum;
    	}

    public static int sumOfSquaresOfDigits(int number)
	{
        int[] digits = getDigits(number);
        int sum = 0;
        for (int d : digits)
            sum += Math.pow(d, 2);
        return sum;
    	}

    public static boolean isHarshadNumber(int number)
	{
        int sum = sumOfDigits(number);
        return sum != 0 && number % sum == 0;
    	}

    public static int[][] digitFrequency(int number)
	{
        int[] freq = new int[10];
        int[] digits = getDigits(number);
        for (int d : digits)
            freq[d]++;
        int count = 0;
        for (int f : freq)
            if (f > 0) count++;
        int[][] freqArray = new int[count][2];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                freqArray[index][0] = i;
                freqArray[index][1] = freq[i];
                index++;
            }
        }
        return freqArray;
    }

    public static void main(String[] args)
	{
        int number = 1729;

        System.out.println("Number: " + number);
        System.out.println("Count of digits: " + countDigits(number));
        System.out.println("Digits array: " + Arrays.toString(getDigits(number)));
        System.out.println("Sum of digits: " + sumOfDigits(number));
        System.out.println("Sum of squares of digits: " + sumOfSquaresOfDigits(number));
        System.out.println("Is Harshad number? " + isHarshadNumber(number));

        System.out.println("Digit frequencies:");
        int[][] freq = digitFrequency(number);
        for (int[] pair : freq) {
            System.out.println("Digit " + pair[0] + " occurs " + pair[1] + " times");
        }
    }
}
