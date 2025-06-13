import java.util.Scanner;
public class ConversionKiloToMiles{
    public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the kilometers");
       double Kilometers=sc.nextInt();
       double Miles = Kilometers * 0.621371;
       System.out.println("The result is:" + Miles);
}
}
    