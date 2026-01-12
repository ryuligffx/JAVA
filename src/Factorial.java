import java.util.Scanner;
public class Factorial {

    public static void main(String[] args){
        int userInput;
        long factorial=1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer to find factorial: ");
        userInput = scanner.nextInt();
        if(userInput >= 0 ){
            for(int i=1;i<=userInput;i++){
                factorial = factorial * i;
            }
        System.out.println("The factorial of " + userInput + " is " + factorial);
        }
        else{
            System.out.println("Please enter a positive integer.");
        }
        scanner.close();
    }
}
