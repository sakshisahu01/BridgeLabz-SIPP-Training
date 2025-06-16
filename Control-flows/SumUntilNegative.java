import java.util.Scanner;

public class SumUntilNegative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        while (true) {
            int num = scanner.nextInt();
            if (num <= 0) {
                break;
            }
            total += num;
        }
        System.out.println("Total sum is: " + total);
    }
}
