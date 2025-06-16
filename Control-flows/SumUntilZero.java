import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        double num = scanner.nextDouble();
        while (num != 0) {
            total += num;
            num = scanner.nextDouble();
        }
        System.out.println("Total sum is: " + total);
    }
}
