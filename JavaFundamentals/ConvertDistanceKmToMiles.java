import java.util.Scanner;
public class ConvertDistanceKmToMiles{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double Km;
		System.out.println("Enter the ditance in km");
		Km=sc.nextDouble();
		double miles=Km/1.6;
		System.out.println("The distance in miles is:" + miles);
}
}