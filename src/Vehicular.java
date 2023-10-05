// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)

import java.util.ArrayList;
import java.util.Scanner;

public class Vehicular {
    static ArrayList<Vehicular> listVehicular = new ArrayList<>();
    private String marca;
    private String model;
    private int ano;
    private String cor;
    private String plate;

    public Vehicular(String marca, String model, String cor, String plate, int ano) {
        this.marca = marca;
        this.model = model;
        this.cor = cor;
        this.plate = plate;
        this.ano = ano;
    }

    public Vehicular(String marca, String model, String cor, int ano) {
        this.marca = marca;
        this.model = model;
        this.cor = cor;
        this.ano = ano;
    }

    public static void abrirConcessionaria(Scanner ler) {
        boolean menuConcessionaria = true;
        while(menuConcessionaria) {
            System.out.println("Escolha a opção da concessionaria:");
            System.out.println("1 - Adicionar novo veiculo");
            System.out.println("2 - Editar veiculo");
            System.out.println("3 - Excluir veiculo");
            System.out.println("4 - Pesquisar veiculo");
            System.out.println("0 - Sair");
            int opcaoConcessionaria = ler.nextInt();
            ler.nextLine();
            switch (opcaoConcessionaria) {
                case 0 -> menuConcessionaria = App.confirmExit(ler);
                case 1 -> create(listVehicular, ler);
                case 2 -> editar(listVehicular, ler);
                case 3 -> excluir(listVehicular, ler);
                case 4 -> pesquisar(listVehicular);
                default -> System.out.println("Invalid option");
            }
        }

    }

    public static void create(ArrayList<Vehicular> listaVehiculars, Scanner ler) {
        System.out.println("ADICIONAR NOVO VEICULO\nO veiculo é 0KM? (1 - Sim, 2 - Não)");
        int escolha = ler.nextInt();
        ler.nextLine();
        boolean veiculo0km = escolha == 1;
        if (veiculo0km) {
            criarVeiculo0KM(listaVehiculars, ler);
        } else {
            criarVeiculoNao0KM(listaVehiculars, ler);
        }

    }

    private static void criarVeiculo0KM(ArrayList<Vehicular> listaVehiculars, Scanner ler) {
        System.out.print("Marca: ");
        String marca = ler.nextLine();
        System.out.print("Cor: ");
        String cor = ler.nextLine();
        System.out.print("Modelo: ");
        String modelo = ler.nextLine();
        System.out.print("Ano: ");
        int ano = ler.nextInt();
        ler.nextLine();
        Vehicular novoVehicular = new Vehicular(marca, modelo, cor, ano);
        listaVehiculars.add(novoVehicular);
    }

    private static void criarVeiculoNao0KM(ArrayList<Vehicular> listaVehiculars, Scanner ler) {
        System.out.print("Marca: ");
        String marca = ler.nextLine();
        System.out.print("Cor: ");
        String cor = ler.nextLine();
        System.out.print("Modelo: ");
        String modelo = ler.nextLine();
        System.out.print("Placa: ");
        String placa = ler.nextLine();
        System.out.print("Ano: ");
        int ano = ler.nextInt();
        ler.nextLine();
        System.out.println();
        Vehicular novoVehicular = new Vehicular(marca, modelo, cor, placa, ano);
        listaVehiculars.add(novoVehicular);
    }

    public static void editar(ArrayList<Vehicular> listaVehiculars, Scanner ler) {
        System.out.println("Escolha o carro que deseja editar:");
        pesquisar(listaVehiculars);
        int i = ler.nextInt() - 1;
        ler.nextLine();
        Vehicular vehicularParaEditar = listaVehiculars.get(i);
        boolean continuarEdicao = true;

        while(continuarEdicao) {
            System.out.println("Escolha o que deseja editar:");
            System.out.println("1 - Marca");
            System.out.println("2 - Modelo");
            System.out.println("3 - Cor");
            System.out.println("4 - Placa");
            System.out.println("5 - Ano");
            System.out.println("0 - Sair");
            int opcaoEditar = ler.nextInt();
            ler.nextLine();
            String novoAnoStr;
            switch (opcaoEditar) {
                case 0 -> {
                    System.out.println("Deseja para a edição? (1 - Sim 2 - Não)");
                    i = ler.nextInt();
                    ler.nextLine();
                    continuarEdicao = i != 1;
                }
                case 1 -> {
                    System.out.print("Nova Marca (" + vehicularParaEditar.getMarca() + "): ");
                    novoAnoStr = ler.nextLine();
                    if (!novoAnoStr.isEmpty()) {
                        vehicularParaEditar.setMarca(novoAnoStr);
                    }
                }
                case 2 -> {
                    System.out.print("Novo Modelo (" + vehicularParaEditar.getModel() + "): ");
                    novoAnoStr = ler.nextLine();
                    if (!novoAnoStr.isEmpty()) {
                        vehicularParaEditar.setModel(novoAnoStr);
                    }
                }
                case 3 -> {
                    System.out.print("Nova Cor (" + vehicularParaEditar.getCor() + "): ");
                    novoAnoStr = ler.nextLine();
                    if (!novoAnoStr.isEmpty()) {
                        vehicularParaEditar.setCor(novoAnoStr);
                    }
                }
                case 4 -> {
                    System.out.print("Nova placa (" + vehicularParaEditar.getPlate() + "): ");
                    novoAnoStr = ler.nextLine();
                    if (!novoAnoStr.isEmpty()) {
                        vehicularParaEditar.setPlate(novoAnoStr);
                    }
                }
                case 5 -> {
                    System.out.print("Novo Ano (" + vehicularParaEditar.getAno() + "): ");
                    novoAnoStr = ler.nextLine();
                    if (!novoAnoStr.isEmpty()) {
                        int novoAno = Integer.parseInt(novoAnoStr);
                        vehicularParaEditar.setAno(novoAno);
                    }
                }
                default -> System.out.println("Opção inválida");
            }
        }

    }

    public static void excluir(ArrayList<Vehicular> listaVehiculars, Scanner ler) {
        if (listaVehiculars.isEmpty()) {
            System.out.println("Não existe veiculos ");
        } else {
            System.out.println("Escolha o carro que deseja excluir:");
            pesquisar(listaVehiculars);
            int indice = ler.nextInt() - 1;
            ler.nextLine();
            if (indice >= 0 && indice < listaVehiculars.size()) {
                listaVehiculars.remove(indice);
                System.out.println("Veículo excluído com sucesso!");
            } else {
                System.out.println("Índice inválido. Nenhum veículo foi excluído.");
            }

        }
    }

    public static void pesquisar(ArrayList<Vehicular> listaVehiculars) {
        int i = 1;
        if (!listaVehiculars.isEmpty()) {
            for (Vehicular listaVehicular : listaVehiculars) {
                System.out.println(i + "º Veiculo ");
                System.out.println("Marca: " + listaVehicular.getMarca() +
                        " | Modelo: " + listaVehicular.getModel() +
                        " | Cor:" + listaVehicular.getCor() +
                        " | Placa: " + listaVehicular.getPlate() +
                        " | Ano: " + listaVehicular.getAno() + "\n");
            }
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlate() {
        return this.plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
