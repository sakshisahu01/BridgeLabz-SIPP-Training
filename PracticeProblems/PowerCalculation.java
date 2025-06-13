import java.util.Scanner;
public class PowerCalculation{
   public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the base");
       double base=sc.nextInt();
       System.out.println("Enter the exponent");
       double exponent=sc.nextInt();
       double result=Math.pow(base,exponent);
       System.out.println("The result is:" + result);
}
}