
import java.util.*;

class Question14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] age = new int[3];
        double[] height = new double[3];
        for (int i = 0; i < 3; i++) {
            age[i] = sc.nextInt();
            height[i] = sc.nextDouble();
        }
        int minAgeIndex = 0;
        int maxHeightIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (age[i] < age[minAgeIndex]) {
                minAgeIndex = i;
            }
            if (height[i] > height[maxHeightIndex]) {
                maxHeightIndex = i;
            }
        }
        String[] names = {"Amar", "Akbar", "Anthony"};
        System.out.println("Youngest: " + names[minAgeIndex]);
        System.out.println("Tallest: " + names[maxHeightIndex]);
    }
}
