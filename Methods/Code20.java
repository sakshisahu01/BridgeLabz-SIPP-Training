import java.util.Scanner;

class BMICalculator {

    public static void calculateBMI(double[][] data)
	{
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightInMeters = data[i][1] / 100.0;
            double bmi = weight / (heightInMeters * heightInMeters);
            data[i][2] = bmi;
        }
    }

    public static String[] getBMIStatuses(double[][] data)
	{
        String[] statuses = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmi < 25) {
                statuses[i] = "Normal weight";
            } else if (bmi < 30) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }
        return statuses;
    }

    public static void main(String[] args)
	{
        Scanner scanner = new Scanner(System.in);
        double[][] teamData = new double[10][3]; // [weight, height, bmi]

        System.out.println("Enter weight (kg) and height (cm) for 10 members:");

        for (int i = 0; i < 10; i++) {
            System.out.print("Member " + (i + 1) + " weight (kg): ");
            teamData[i][0] = scanner.nextDouble();

            System.out.print("Member " + (i + 1) + " height (cm): ");
            teamData[i][1] = scanner.nextDouble();
        }

        calculateBMI(teamData);
        String[] statuses = getBMIStatuses(teamData);

        for (int i = 0; i < teamData.length; i++) {
            String weight = String.valueOf(teamData[i][0]);
            String height = String.valueOf(teamData[i][1]);
            String bmi = String.valueOf(teamData[i][2]);
            String status = statuses[i];

            System.out.println(weight + "       " + height + "      " + bmi + " " + status);
        }
    }
}
