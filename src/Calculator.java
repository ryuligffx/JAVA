import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        int num1, num2;
        String operator;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        num1 = scanner.nextInt();
        System.out.print("Enter number 2: ");
        num2 = scanner.nextInt();
        System.out.print("Enter operator(+, -, /, *): ");
        operator = scanner.next();

        if (operator.equals("+")) {
            int sum = num1 + num2;
            System.out.println("The sum of " + num1 + " and " + num2 + " is " + sum);
        }
        else if (operator.equals("-")) {
            int difference = num2 - num1;
            System.out.println("The subtraction of " + num1 + " from " + num2 + " is " + difference);
        }
        else if(operator.equals("*")) {
            int product = num1 * num2;
            System.out.println("The product of " + num1 + " and " + num2 + " is " + product);
        }
        else if(operator.equals("/")){
            int division = num1 / num2;
            System.out.println("The quotient of " + num1 + " divided by " + num2 + " is " + division);
        }
        else{
            System.out.println("Please enter a valid operator..");
        }
    scanner.close();
    }
}
