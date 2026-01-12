import java.util.Scanner;
public class Userinput{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); //Scanner is class, scanner is object

        //string input linako lagi
        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); //nextLine le input read with spaces too, tara next le space agadiko matrai read garxa

        //integer ko lagi
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        //double ko lagi
        System.out.print("Enter your GPA: ");
        double gpa = scanner.nextDouble();

        //boolean ko lagi
        System.out.print("Are you gay?(true/false): ");
        boolean isgay = scanner.nextBoolean();

        System.out.println("Your name is " + name);
        System.out.println("Your Age is " + age);
        scanner.nextLine(); //input buffer hatauna ko lagi if occured
        System.out.println("Your Gpa is " + gpa);
        if(isgay){
            System.out.println("Yes, you are a gay");
        }
        else{
            System.out.println("You are straight");
        }


        scanner.close();
    }
}
