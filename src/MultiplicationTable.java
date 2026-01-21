import java.util.Scanner;
public class MultiplicationTable {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int userInput,upto;
        System.out.print("Enter a number to find it's table: ");
        userInput = scan.nextInt();
        System.out.print("Enter the maximum value of table: ");
        upto = scan.nextInt();

        for(int i=1;i<=upto;i++){
            System.out.println(userInput + " * " + i + " = " + userInput*i );
        }
        scan.close();
    }
}
