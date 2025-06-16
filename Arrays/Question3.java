import java.util.*;

class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] arr = new double[10];
        double total = 0.0;
        int index = 0;
        while (true) {
            double input = sc.nextDouble();
            if (input <= 0 || index == 10)
                break;
            arr[index++] = input;
        }
        for (int i = 0; i < index; i++)
            total += arr[i];
        for (int i = 0; i < index; i++)
            System.out.print(arr[i] + " ");
        System.out.println("\nTotal: " + total);
    }
}
