import java.util.*;

class Question18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        int temp = num;
        while (temp != 0) {
            temp /= 10;
            count++;
        }
        int[] digits = new int[count];
        for (int i = 0; i < count; i++) {
            digits[i] = num % 10;
            num /= 10;
        }
        for (int i = 0; i < count; i++)
            System.out.print(digits[i]);
    }
}
