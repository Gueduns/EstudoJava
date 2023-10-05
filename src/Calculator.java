package Execution;
import java.util.Scanner;

public class Calculator {
    public static void executeCalculator(Scanner ler) {
        double[] vector = new double[3];
        boolean calculatorContinue = true;

        while(calculatorContinue) {
            System.out.println("\nExecution.Calculator menu");
            System.out.println("1 - Sum");
            System.out.println("2 - Subtract");
            System.out.println("3 - Multiply");
            System.out.println("4 - Divide");
            System.out.println("0 - Exit");
            int menuOption = ler.nextInt();
            ler.nextLine();
            switch (menuOption) {
                case 0 -> calculatorContinue = App.confirmExit(ler);
                case 1 -> {
                    System.out.print("Insert n1: ");
                    vector[0] = ler.nextDouble();
                    ler.nextLine();
                    System.out.print("Insert n2: ");
                    vector[1] = ler.nextDouble();
                    ler.nextLine();
                    sum(vector);
                }
                case 2 -> {
                    System.out.print("Insert n1: ");
                    vector[0] = ler.nextDouble();
                    ler.nextLine();
                    System.out.print("Insert n2: ");
                    vector[1] = ler.nextDouble();
                    ler.nextLine();
                    subtract(vector);
                }
                case 3 -> {
                    System.out.print("Insert n1: ");
                    vector[0] = ler.nextDouble();
                    ler.nextLine();
                    System.out.print("Insert n2: ");
                    vector[1] = ler.nextDouble();
                    ler.nextLine();
                    multiply(vector);
                }
                case 4 -> {
                    System.out.print("Insert n1: ");
                    vector[0] = ler.nextDouble();
                    ler.nextLine();
                    System.out.print("Insert n2: ");
                    vector[1] = ler.nextDouble();
                    ler.nextLine();
                    if (vector[1] == 0.0) {
                        System.out.println("Logical error");
                    } else {
                        division(vector);
                    }
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    public static void sum(double[] vector) {
        System.out.println("Sum of 2 numbers");
        vector[0] += vector[1];
        System.out.println("The sum is " + vector[0] + "\nThe value of variables n1 e n2 is respectively: " + vector[0] + " " + vector[1]);
    }

    public static void subtract(double[] vector) {
        System.out.println("Subtract of 2 numbers");
        vector[0] -= vector[1];
        System.out.println("The subtract is " + vector[0] + "\nThe value of variables n1 e n2 is respectively: " + vector[0] + " " + vector[1]);
    }

    public static void multiply(double[] vector) {
        System.out.println("Multiply of 2 numbers");
        vector[0] *= vector[1];
        System.out.println("The multiply is" + vector[0] + "\nThe value of variables n1 e n2 is respectively: " + vector[0] + " " + vector[1]);
    }

    public static void division(double[] vector) {
        System.out.println("Division of 2 numbers");
        vector[0] /= vector[1];
        System.out.println("The division is " + vector[0] + "\nThe value of variables n1 and n2 are respectively: " + vector[0] + " " + vector[1]);
    }
}
