import java.util.Scanner;
public class Average{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first number");
        double num1=sc.nextInt();
        System.out.println("Enter the second number");
        double num2=sc.nextInt();
        System.out.println("Enter the third number");   
        double num3=sc.nextInt();
        double average=(num1+num2+num3)/3;
        System.out.println("Average of three numbers is:" + average);
}
}