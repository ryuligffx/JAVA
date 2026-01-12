import java.util.Scanner;
public class Factors {
    public static void main(String[] args){
        int userInput;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find it's factors: ");
        userInput = scanner.nextInt();
        if(userInput >0 ){
            System.out.println("The factors of " + userInput + " are:");
            for(int i=1;i<=userInput;i++){
                if(userInput%i==0){
                System.out.println(i);
                }
            }
        }
        else{
            System.out.println("Please enter a positive number.");
        }
        scanner.close();
    }
}
