import java.util.Scanner;
   public class VolumeOfCylinder{

      public static void main(String[] args){
         Scanner sc=new Scanner(System.in);
         System.out.println("Enter the volume of Cylinder");
         double radius=sc.nextInt();
         double height=sc.nextInt();
         double volume=3.14 * radius * radius * height;
         System.out.println("Volume of cycliner is:" + volume);
}
}