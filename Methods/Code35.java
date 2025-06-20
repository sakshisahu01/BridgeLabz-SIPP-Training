import java.util.Random;

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        double[][] employeeData = generateEmployeeData(10);
        double[][] bonusData = calculateBonusAndNewSalary(employeeData);
        displayResults(employeeData, bonusData);
    }

    public static double[][] generateEmployeeData(int numberOfEmployees) {
        Random rand = new Random();
        double[][] data = new double[numberOfEmployees][2];
        for (int i = 0; i < numberOfEmployees; i++) {
            double salary = 10000 + rand.nextInt(90000); // 5-digit salary
            int yearsOfService = 1 + rand.nextInt(10);   // 1 to 10 years
            data[i][0] = salary;
            data[i][1] = yearsOfService;
        }
        return data;
    }

    public static double[][] calculateBonusAndNewSalary(double[][] employeeData) {
        int n = employeeData.length;
        double[][] bonusData = new double[n][2]; // [][0] = bonus, [][1] = new salary
        for (int i = 0; i < n; i++) {
            double salary = employeeData[i][0];
            int years = (int) employeeData[i][1];
            double bonus = (years > 5) ? salary * 0.05 : salary * 0.02;
            double newSalary = salary + bonus;
            bonusData[i][0] = bonus;
            bonusData[i][1] = newSalary;
        }
        return bonusData;
    }

    public static void displayResults(double[][] employeeData, double[][] bonusData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.printf("%-10s %-12s %-10s %-10s %-12s\n", "Employee", "Old Salary", "Years", "Bonus", "New Salary");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < employeeData.length; i++) {
            double oldSalary = employeeData[i][0];
            int years = (int) employeeData[i][1];
            double bonus = bonusData[i][0];
            double newSalary = bonusData[i][1];

            totalOldSalary += oldSalary;
            totalBonus += bonus;
            totalNewSalary += newSalary;

            System.out.printf("%-10d %-12.2f %-10d %-10.2f %-12.2f\n", i + 1, oldSalary, years, bonus, newSalary);
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-10s %-12.2f %-10s %-10.2f %-12.2f\n", "TOTAL", totalOldSalary, "", totalBonus, totalNewSalary);
    }
}
