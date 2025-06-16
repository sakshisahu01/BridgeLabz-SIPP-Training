
import java.util.*;

class Question7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] multiplicationResult = new int[4];
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = num * i;
        }
        for (int i = 6; i <= 9; i++) {
            System.out.println(num + " * " + i + " = " + multiplicationResult[i - 6]);
        }
    }
}
