import de.rhistel.logic.ConsoleReader;

public class Main {
    public static void main(String[] args) {
        startApplication();
    }

    private static void startApplication() {
        printNameApp();
        runCalcApp();
    }

    private static void printNameApp() {
        System.out.println("Welcome to my Calculator Application");
    }

    private static void runCalcApp() {
        boolean isValidAns = false;

        while(!isValidAns){
            printOption();
            System.out.println("Choose 1, 2 or 3?");
            int userChoose = ConsoleReader.in.readInt();
            if(userChoose > 3 || userChoose<1){
                System.out.println("You can either chose 1 or 2, please redo");
            }else if( userChoose == 3){
                isValidAns = true;
            }else {
                if(userChoose == 1) preferedProcessFirst();
                if(userChoose == 2) preferedProcessSecond();
            }
        }
    }

    private static void preferedProcessFirst() {
        System.out.println("Enter your calculation?");
        String input = ConsoleReader.in.readString();
        processStringCalculation(input);
    }

    private static void processStringCalculation(String input) {
        char[] operators = {'+','-','*','/'};
        for(char operator : operators){
            if (input.indexOf(operator) != -1){
                double leftOperand = Double.parseDouble(input.substring(0, input.indexOf(operator)));
                double rightOperand = Double.parseDouble(input.substring(input.indexOf(operator)+1));

                switch(operator){
                    case '+' -> addition(leftOperand, rightOperand);
                    case '-' -> subtraction(leftOperand, rightOperand);
                    case '*' -> multiplication(leftOperand, rightOperand);
                    case '/' -> division(leftOperand, rightOperand);
                    default -> System.out.println("not implemented yet!");
                }
            }
        }
    }

    private static void preferedProcessSecond() {
        boolean isOn = false;
        while (!isOn){
            double[] userInputs = new double[2];
            System.out.println();

            for (int i = 0; i < userInputs.length; i++) {
                System.out.printf("Enter your %d double value?%n", i+1);
                double firstUserInput = ConsoleReader.in.readDouble();
                userInputs[i] = firstUserInput;
            }

            printOptionOperator();
            System.out.println("Choose either 1, 2, 3, 4 or 5 as the operator?");
            int operator = ConsoleReader.in.readPositivInt();
            if (operator > 5 || operator < 1){
                System.out.println("You are not choosing the option available, restart!");
                runCalcApp();
            }else if(operator == 5){
                System.out.println("Thank you, goodbye!");
                isOn = true;
            }
            else{
                if(operator == 1) addition(userInputs);
                if(operator == 2) subtraction(userInputs);
                if(operator == 3) multiplication(userInputs);
                if(operator == 4) division(userInputs);
            }
        }
    }

    private static void printOption() {
        String[] options = {
                "1. Typing into console",
                "2. Classic option",
                "3. End the app"
        };
        for( String a: options) System.out.println(a);
    }

    private static void division(double[] userInputs) {
        if (userInputs[1] == 0){
            System.out.println("Division by null is not allowed, termination!");
        }
        System.out.println("Multiplication result is "+ userInputs[0]/userInputs[1]);
    }

    private static void multiplication(double[] userInputs) {
        System.out.println("Multiplication result is "+ userInputs[0]*userInputs[1]);
    }

    private static void subtraction(double[] userInputs) {
        System.out.printf("Subtraction result is %2.2f %n" , userInputs[0]-userInputs[1]);
    }

    private static void addition(double[] inputs) {
        System.out.println("Addition result is "+ inputs[0]+inputs[1]);
    }
    private static void addition(double a, double b) {
        System.out.printf("Addition result is %2.2f %n",a+b);
    }
    private static void subtraction(double a, double b) {
        System.out.printf("Subtraction result is %2.2f %n", a-b);
    }
    private static void multiplication(double a, double b) {
        System.out.printf("Multiplication result is %2.2f %n", a*b);
    }
    private static void division(double a, double b) {
        if(b != 0) {
            System.out.printf("Division result is %2.2f %n" , a / b);
        } else{
            System.out.println("division by null is not allowed!");
        }
    }

    private static void printOptionOperator() {
        String[] operators = {
                "1. Add",
                "2. Subtract",
                "3. Multiply",
                "4. Divide",
                "5. Quit"
        };
        for (String a: operators){
            System.out.println(a);
        }
    }
}