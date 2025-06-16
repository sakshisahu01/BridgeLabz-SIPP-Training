import java.util.Scanner;

public class DivisibleByFive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        boolean isDivisible = number % 5 == 0;
        System.out.println("Is the number " + number + " divisible by 5? " + isDivisible);
    }
}
