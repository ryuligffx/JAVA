import java.util.Scanner;
public class PrimeChecker {
    public static void main(String[] args){
        int userInput,count=0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter non-negative integer to check: ");
        userInput = scanner.nextInt();

        if (userInput == 0 || userInput == 1) {
            System.out.println(userInput + " is neither prime nor composite");
        }
        else if(userInput > 0){
            for(int i=1;i<=userInput;i++) {
                if (userInput % i == 0) {
                    count++;
                }
            }
            if(count == 2){
                System.out.println("Prime Number");
            }
            else{
                System.out.println("Composite Number");
            }

        }
        else{
            System.out.println("Please Enter positive integer");
        }
        scanner.close();
    }

}
