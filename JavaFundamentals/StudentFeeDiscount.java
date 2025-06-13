import java.util.Scanner;

public class StudentFeeDiscount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	System.out.print("Enter the student fee (INR): ");
        double fee = sc.nextDouble();
	System.out.print("Enter the discount percent (%): ");
        double discountPercent = sc.nextDouble();
	double discount = (fee * discountPercent) / 100;
	double finalFee = fee - discount;
	System.out.println("The discount amount is INR " + discount);
        System.out.println("Final discounted fee is INR " + finalFee);
}
}