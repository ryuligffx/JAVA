import java.util.Scanner;
public class Area {

    public static void main(String[] args){
        //rectangle

        double length, breadth, area;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length: ");
        length = scanner.nextDouble();

        System.out.print("Enter breadth: ");
        breadth = scanner.nextDouble();

        area = length * breadth;
        System.out.println("The area of the rectangle is %.2f" + area);

        scanner.close();

    }
}
