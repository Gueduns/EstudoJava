package Execution;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Scanner;

public class Produto {
    Scanner ler;
    static ArrayList<Produto> listaProduto = new ArrayList<>();
    private int id;
    private String nome;
    private float preco;
    boolean menuProduto;

    public Produto(int id, String nome, float preco) {
        this.ler = new Scanner(System.in);
        this.menuProduto = true;
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public static void Loja(Scanner ler) {
        boolean menuLoja = true;
        while(menuLoja) {
            System.out.println("MENU LOJA");
            System.out.println("1 - Registrar produto: ");
            System.out.println("2 - Lista de produtos ");
            System.out.println("3 - Editar produto: ");
            System.out.println("4 - Excluir produto: ");
            System.out.println("0 - Sair");
            int opcaoMenu = ler.nextInt();
            ler.nextLine();
            switch (opcaoMenu) {
                case 0 -> menuLoja = App.confirmExit(ler);
                case 1 -> novoProduto(ler);
                case 2 -> getListaProduto(listaProduto);
                case 3 -> editarProduto(listaProduto, ler);
                case 4 -> excluirProduto(listaProduto, ler);
                default -> System.out.println("Opção inválida");
            }
        }

    }

    public static void novoProduto(Scanner ler) {
        System.out.print("Insira o ID: ");
        int id = ler.nextInt();
        ler.nextLine();
        System.out.println("Insira o nome do produto: ");
        String nome = ler.nextLine();
        System.out.println("Preço do produto:");
        float preco = ler.nextFloat();
        ler.nextLine();
        Produto produto = new Produto(id, nome, preco);
        listaProduto.add(produto);
    }

    public float getPrecoDollar(float preco) {
        this.setPreco(preco * 5.0F);
        return 0.0F;
    }

    public static void getListaProduto(ArrayList<Produto> listaProduto) {
        int i = 0;
        if (!listaProduto.isEmpty()){
            for(Produto p : listaProduto) {
                System.out.println(i + "º Produto");
                System.out.println("Produto ID: " + p.getId()  +
                        "Produto nome: " + p.getNome() +
                        "Produto preço: " + p.getPreco());
                System.out.println("Preço em dollaro : " + p.getPrecoDollar(p.getPreco()));
            }
        }
    }

    public static void editarProduto(ArrayList<Produto> listaProduto, Scanner ler) {
        System.out.println("Escolha o carro que deseja editar:");
        getListaProduto(listaProduto);
        int i = ler.nextInt() - 1;
        ler.nextLine();
        Produto produtoParaEditar = listaProduto.get(i);
        boolean continuarEdicao = true;

        while(continuarEdicao) {
            System.out.println("Escolha o que deseja editar:");
            System.out.println("1 - Nome: ");
            System.out.println("2 - Preço: ");
            System.out.println("0 - Sair");
            int opcaoEditar = ler.nextInt();
            ler.nextLine();
            switch (opcaoEditar) {
                case 0 -> {
                    System.out.println("Deseja para a edição? (1 - Sim 2 - Não)");
                    i = ler.nextInt();
                    ler.nextLine();
                    continuarEdicao = i != 1;
                }
                case 1 -> {
                    System.out.print("Novo nome  (" + produtoParaEditar.getNome() + "): ");
                    String novoNome = ler.nextLine();
                    if (!novoNome.isEmpty()) {
                        produtoParaEditar.setNome(novoNome);
                    }
                }
                case 2 -> {
                    System.out.print("Novo preço  (" + produtoParaEditar.getPreco() + "): ");
                    float novoPreco = ler.nextFloat();
                    if (novoPreco > 0.0F) {
                        produtoParaEditar.setPreco(novoPreco);
                    } else {
                        System.out.println("Preço inválido");
                    }
                }
                default -> System.out.println("Opção inválida");
            }
        }
    }

    public static void excluirProduto(ArrayList<Produto> listaProduto, Scanner ler) {
        try{
            if (listaProduto.isEmpty()) {
                throw new Exception("Não existem produtos na lista");
            } else {
                System.out.println("Escolha o carro que deseja excluir:");
                getListaProduto(listaProduto);
                int indice = ler.nextInt() - 1;
                ler.nextLine();
                if (indice >= 0 && indice < listaProduto.size()) {
                    listaProduto.remove(indice);
                    System.out.println("Veículo excluído com sucesso!");
                } else {
                    throw new Exception("Não existe veiculo nesse indice");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public float getPreco() {
        return this.preco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
