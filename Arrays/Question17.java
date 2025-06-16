import java.util.*;

class Question17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] frequency = new int[10];
        while (num != 0) {
            int digit = num % 10;
            frequency[digit]++;
            num /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0)
                System.out.println("Digit " + i + ": " + frequency[i]);
        }
    }
}
