import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();
        boolean keepRunning = true;

        System.out.println("=== Maven Calculator Started ===");

        while (keepRunning) {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter operation (+, -, *, /): ");
            char operation = scanner.next().charAt(0);

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            try {
                double result = 0;
                switch (operation) {
                    case '+': result = calc.add(num1, num2); break;
                    case '-': result = calc.subtract(num1, num2); break;
                    case '*': result = calc.multiply(num1, num2); break;
                    case '/': result = calc.divide(num1, num2); break;
                    default: 
                        System.out.println("Invalid operation."); 
                        continue;
                }
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }

            System.out.print("Calculate again? (y/n): ");
            char choice = scanner.next().charAt(0);
            if (choice == 'n' || choice == 'N') {
                keepRunning = false;
            }
            System.out.println("------------------------------");
        }
        
        System.out.println("Calculator closed.");
        scanner.close();
    }
}