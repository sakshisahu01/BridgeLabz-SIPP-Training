class NumberChecker
{

    public static boolean isPrime(int number)
	{
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static boolean isNeon(int number)
	{
        	int square = number * number;
        	int sum = 0;
        	while (square > 0)
		{
            	sum += square % 10;
            	square /= 10;
        	}
        return sum == number;
    	}

    public static boolean isSpy(int number) {
        int sum = 0;
        int product = 1;
        int temp = number;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }

    public static boolean isAutomorphic(int number) {
        int square = number * number;
        String numStr = String.valueOf(number);
        String squareStr = String.valueOf(square);
        return squareStr.endsWith(numStr);
    }

    public static boolean isBuzz(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    public static void main(String[] args) {
        int[] testNumbers = {7, 9, 25, 5, 1729};

        for (int num : testNumbers) {
            System.out.println("Number: " + num);
            System.out.println("Prime? " + isPrime(num));
            System.out.println("Neon? " + isNeon(num));
            System.out.println("Spy? " + isSpy(num));
            System.out.println("Automorphic? " + isAutomorphic(num));
            System.out.println("Buzz? " + isBuzz(num));
            System.out.println();
        }
    }
}
