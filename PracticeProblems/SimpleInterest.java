import java.util.Scanner;
     public class SimpleInterest{
         public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the Principal");
            double Principal=sc.nextInt();
            System.out.println("Enter the Rate");
            double Rate=sc.nextInt();
            System.out.println("Enter the Time");
            double Time=sc.nextInt();
            double SI=(Principal * Rate * Time) / 100;
            System.out.println("Simple Interest is:" + SI);
}
}
            