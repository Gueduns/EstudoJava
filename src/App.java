package Execution;

import java.util.Scanner;

public class App {
    public App() {
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        boolean continueExecution = true;

        do {
            System.out.println("My first Menu");
            System.out.println("1 - Concessionaire");
            System.out.println("2 - Execution calculator");
            System.out.println("3 - Shop");
            System.out.println("0 - Exit");
            int menuOption = ler.nextInt();
            ler.nextLine();
            switch (menuOption) {
                case 0 -> continueExecution = confirmExit(ler);
                case 1 -> Vehicular.abrirConcessionaria(ler);
                case 2 -> Calculator.executeCalculator(ler);
                case 3 -> Produto.Loja(ler);
                default -> System.out.println("Invalid option");
            }
        } while(continueExecution);

    }

    public static boolean confirmExit(Scanner ler) {
        System.out.println("Are you sure you want to quit? (1 - Sim, 2 - Não)");
        int choose = ler.nextInt();
        ler.nextLine();
        return choose != 1;
    }
}
