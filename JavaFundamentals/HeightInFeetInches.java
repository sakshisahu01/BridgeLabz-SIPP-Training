import java.util.Scanner;

public class HeightInFeetInches {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the height in centimeters");
        double heightCm = sc.nextDouble();
        double totalInches = heightCm / 2.54;
        int feet = (int) (totalInches / 12);
        double inches = totalInches % 12;

        System.out.printf("The height in cm is %.2f and the height in feet and inches is %d feet %.2f inches.%n", heightCm, feet, inches);
    }
}
