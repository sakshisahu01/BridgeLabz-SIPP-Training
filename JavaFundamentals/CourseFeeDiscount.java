public class CourseFeeDiscount{
	public static void main(String[] args){
		double fee=12500;
		double discountPercent=10;
		double discount=(fee*discountPercent)*100;
		double finalFee=fee-discount;
		System.out.println("discount amount is INR:" + discount);
		System.out.println("Final fee is INR:" + finalFee);
}
}
		