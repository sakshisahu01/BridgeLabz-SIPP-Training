import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your weight in kilograms (kg): ");
        double weight = scanner.nextDouble();

        System.out.print("Enter your height in centimeters (cm): ");
        double heightCm = scanner.nextDouble();

        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);

        System.out.printf("Your BMI is: %.2f\n", bmi);

        String weightStatus;
        if (bmi < 18.5) {
            weightStatus = "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            weightStatus = "Normal weight";
        } else if (bmi >= 25 && bmi < 39.9) {
            weightStatus = "Overweight";
        } else {
            weightStatus = "Obesity";
        }

        System.out.println("Weight Status: " + weightStatus);

    }
}