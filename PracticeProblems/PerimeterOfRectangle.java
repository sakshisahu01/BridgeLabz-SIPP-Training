import java.util.Scanner;
public class PerimeterOfRectangle{
       public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the length");
            double length=sc.nextInt();
            System.out.println("Enter the width");
            double width=sc.nextInt();
            double Perimeter=2 * (length + width);
            System.out.println("Perimeter of Rectangle is:" + Perimeter);
}
}
