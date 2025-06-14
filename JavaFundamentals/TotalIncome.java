import java.util.Scanner;

public class TotalIncome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter salary (INR): ");
        double salary = sc.nextDouble();
        System.out.print("Enter bonus (INR): ");
        double bonus = sc.nextDouble();
        double income = salary + bonus;
        System.out.println("The salary is INR " + salary + " and the bonus is INR " + bonus + ". Hence Total Income is INR " + income);
        
    }
}
