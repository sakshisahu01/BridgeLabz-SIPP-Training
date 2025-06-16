
import java.util.*;

class Question4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] result = new String[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result[i] = "FizzBuzz"; 
            }else if (i % 3 == 0) {
                result[i] = "Fizz"; 
            }else if (i % 5 == 0) {
                result[i] = "Buzz"; 
            }else {
                result[i] = String.valueOf(i);
            }
        }
        for (int i = 0; i <= n; i++) {
            System.out.println("Position " + i + " = " + result[i]);
        }
    }
}
