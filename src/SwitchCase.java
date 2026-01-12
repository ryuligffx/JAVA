import java.util.Scanner;
public class SwitchCase {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int number;
        System.out.print("Enter number to find the corresponding day: ");
        number = scan.nextInt();

        switch (number){
            case 1:
                System.out.println("The corresponding day to 1 is Sunday.");
                break;
            case 2:
                System.out.println("The corresponding day to 2 is Monday.");
                break;
            case 3:
                System.out.println("The corresponding day to 3 is Tuesday.");
                break;
            case 4:
                System.out.println("The corresponding day to 4 is Wednesday.");
                break;
            case 5:
                System.out.println("The corresponding day to 5 is Thursday.");
                break;
            case 6:
                System.out.println("The corresponding day to 6 is Friday.");
                break;
            case 7:
                System.out.println("The corresponding day to 7 is Saturday.");
                break;
        }
        scan.close();
    }
}
