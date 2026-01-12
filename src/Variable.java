public class Variable {

    public static void main(String[] args){
        String name = "Sujan Dangol";
        int age =17;
        double percentage = 20.13;
        boolean isTalented = false;
        boolean isForsale = false;
        char rating = 'F';

        System.out.println("Hi, my name is "+ name);
        System.out.println("And my age is "+ age);
        System.out.println("I got "+ percentage +"% in class 1.");
        System.out.println("Am I talented in anything?"+ isTalented);
        System.out.println("My overall rating is "+ rating);
        System.out.println("Combining variables " + name + " " + age + " " + percentage);

        if(isForsale){
            System.out.println("This is for sale");
        }
        else{
            System.out.println("This is not for sale");
        }

    }
    // variable = a reusable container for a value
    // a variable behaves as if it was the value it contains

    // Primitive = simple value stored directly in memory (stack)
    // Reference = memory address (stack) that points to the (heap)

    //Primitive vs Reference
    //int           //string
    //double        //array
    //char          //object
    //boolean
}
