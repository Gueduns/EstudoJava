import java.util.ArrayList;
import java.util.Scanner;

public class App
{
	public static void main(String[] args) {

        ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
        Scanner ler = new Scanner(System.in);

	    int opcaoMenu = 0;
	    boolean continuarExecucao = true;

        
	    do{
	        System.out.println("Meu Primeiro Menu");
            System.out.println("1 - Inserir");
            System.out.println("2 - Editar");
            System.out.println("3 - Exluir");
            System.out.println("4 - Pesquisar");
            System.out.println("5 - Calculadora");
            System.out.println("0 - Sair");

            opcaoMenu = ler.nextInt();
            ler.nextLine(); // Consumir a nova linha pendente
            
	        switch(opcaoMenu){
	            case 1:
                    create(ler,listaVeiculos);
                break;
	            case 2:
                    editar(listaVeiculos, ler);
                break;
	            case 3:
                    excluir(listaVeiculos,ler);
                break;
	            case 4:
                    pesquisar(listaVeiculos);
                break;
                case 5:
                    executarCalculadora(ler);
                break;
	            case 0: continuarExecucao = confirmarSaida(ler); break;
	            default:System.out.println("Opção inválida");
	        }   
	        
	    }while(continuarExecucao); 
	}

    public static boolean confirmarSaida(Scanner ler) {
        System.out.println("Tem certeza que deseja sair? (1 - Sim, 2 - Não)");
        int escolha = ler.nextInt();
        ler.nextLine(); // Consumir a nova linha pendente
        return escolha != 1;
    }
    public static void create(Scanner ler, ArrayList<Veiculo> listaVeiculos) {
        System.out.println("ADICIONAR NOVO VEICULO\nO veiculo é 0KM? (1 - Sim, 2 - Não)");
        int escolha = ler.nextInt();
        ler.nextLine(); // Consumir a nova linha pendente
 
        boolean veiculo0km = (escolha == 1);
    
        if (veiculo0km) {
            criarVeiculo0KM(listaVeiculos, ler);
        } else {
            criarVeiculoNao0KM(listaVeiculos, ler);
        }
    }
    
    private static void criarVeiculo0KM(ArrayList<Veiculo> listaVeiculos, Scanner ler) {
        System.out.print("Marca: ");
        String marca = ler.nextLine();
        System.out.print("Cor: ");
        String cor = ler.nextLine();
        System.out.print("Modelo: ");
        String modelo = ler.nextLine();
        System.out.print("Ano: ");
        int ano = ler.nextInt();
        ler.nextLine(); // Consumir a nova linha pendente
    
        Veiculo novoVeiculo = new Veiculo(marca, modelo, cor, ano);
        listaVeiculos.add(novoVeiculo);
    }
    
    private static void criarVeiculoNao0KM(ArrayList<Veiculo> listaVeiculos, Scanner ler) {
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
        ler.nextLine(); // Consumir a nova linha pendente
    
        Veiculo novoVeiculo = new Veiculo(marca, modelo, cor, placa, ano);
        listaVeiculos.add(novoVeiculo);
    }
    public static void editar(ArrayList<Veiculo> listaVeiculos, Scanner ler) {
        System.out.println("Escolha o carro que deseja editar:");
        pesquisar(listaVeiculos);
        int i = ler.nextInt() - 1;
        ler.nextLine(); // Consumir a nova linha pendente
        
        Veiculo veiculoParaEditar = listaVeiculos.get(i); // Obtém o objeto da lista

        boolean continuarEdicao = true;
        
        while(continuarEdicao){
            System.out.println("Escolha o que deseja editar:");
            System.out.println("1 - Marca");
            System.out.println("2 - Modelo");
            System.out.println("3 - Cor");
            System.out.println("4 - Placa");
            System.out.println("5 - Ano");
            System.out.println("0 - Sair");

            int opacaoEditar = ler.nextInt();
            ler.nextLine(); // Consumir a nova linha pendente

            switch(opacaoEditar){
                case 1 ->{
                    System.out.print("Nova Marca (" + veiculoParaEditar.getMarca() + "): ");
                    String novaMarca = ler.nextLine();
                    if (!novaMarca.isEmpty()) {
                        veiculoParaEditar.setMarca(novaMarca);
                    }
                }
                case 2 ->{
                    System.out.print("Novo Modelo (" + veiculoParaEditar.getModelo() + "): ");
                    String novoModelo = ler.nextLine();
                    if (!novoModelo.isEmpty()) {
                        veiculoParaEditar.setModelo(novoModelo);
                    }
                }
                case 3 ->{
                    System.out.print("Nova Cor (" + veiculoParaEditar.getCor() + "): ");
                    String novaCor = ler.nextLine();
                    if (!novaCor.isEmpty()) {
                        veiculoParaEditar.setCor(novaCor);
                    }
                }
                case 4 ->{
                    System.out.print("Nova placa (" + veiculoParaEditar.getPlaca() + "): ");
                    String novaPlaca = ler.nextLine();
                    if (!novaPlaca.isEmpty()) {
                        veiculoParaEditar.setPlaca(novaPlaca);
                    }
                }
                case 5 ->{
                    System.out.print("Novo Ano (" + veiculoParaEditar.getAno() + "): ");
                    String novoAnoStr = ler.nextLine();
                    if (!novoAnoStr.isEmpty()) {
                        int novoAno = Integer.parseInt(novoAnoStr);
                        veiculoParaEditar.setAno(novoAno);
                    }
                }
                case 0 ->{
                    System.out.println("Deseja para a edição? (1 - Sim 2 - Não)");
                    i = ler.nextInt();
                    ler.nextLine(); // Consumir a nova linha pendente
                    continuarEdicao = (i !=1);
                }
                default -> System.out.println("Opção inválida");
            }

        }
    }
    
	public static void excluir(ArrayList<Veiculo> listaVeiculos, Scanner ler) {
        if(listaVeiculos.size() == 0) {System.out.println("Não existe veiculos "); return;}
        System.out.println("Escolha o carro que deseja excluir:");
        pesquisar(listaVeiculos);
        int indice = ler.nextInt() - 1;
        ler.nextLine(); // Consumir a nova linha pendente
        if (indice >= 0 && indice < listaVeiculos.size()) {
            listaVeiculos.remove(indice);
            System.out.println("Veículo excluído com sucesso!");
        } else {
            System.out.println("Índice inválido. Nenhum veículo foi excluído.");
        }
    }
	public static void pesquisar(ArrayList<Veiculo> listaVeiculos) {
        int i = 1;
        for (Veiculo veiculo : listaVeiculos) {
            System.out.println(i + "º Veiculo ");
            System.out.println("Marca: " + veiculo.getMarca() + " | Modelo: " + veiculo.getModelo() + " | Cor:" + veiculo.getCor()
            + "\n | Ano: " + veiculo.getAno());
            if(veiculo.getPlaca() != null )System.out.print("Placa: " + veiculo.getPlaca());
        }
    }
    
    public static boolean executarCalculadora (Scanner ler){
        double [] vetor = new double[3];
        int opcaoMenu = 0;
        boolean continuarCalculadora = true;

        while(continuarCalculadora){
            System.out.println("\nMenu calculadora");
            System.out.println("1 - Somar");
            System.out.println("2 - Subtrair");
            System.out.println("3 - Multiplicar");
            System.out.println("4 - Dividir");
            System.out.println("0 - Sair");
            opcaoMenu = ler.nextInt();
            ler.nextLine(); // Consumir a nova linha pendente
            switch(opcaoMenu){

                case 1:
                    System.out.print("Insira n1: ");
                    vetor [0] = ler.nextDouble();
                    ler.nextLine();
                    System.out.print("Insira n2: ");
                    vetor [1] = ler.nextDouble();
                    ler.nextLine();
                    somar(vetor);
                break;
                case 2:
                    System.out.print("Insira n1: ");
                    vetor [0] = ler.nextDouble();
                    ler.nextLine();
                    System.out.print("Insira n2: ");
                    vetor [1] = ler.nextDouble();
                    ler.nextLine();
                    subtrair(vetor);
                break;
                case 3:
                    System.out.print("Insira n1: ");
                    vetor [0] = ler.nextDouble();
                    ler.nextLine();
                    System.out.print("Insira n2: ");
                    vetor [1] = ler.nextDouble();
                    ler.nextLine();
                    multiplicar(vetor); 

                break;
                case 4:
                    System.out.print("Insira n1: ");
                    vetor [0] = ler.nextDouble();
                    ler.nextLine();
                    System.out.print("Insira n2: ");
                    vetor [1] = ler.nextDouble();
                    ler.nextLine();
                    if(vetor[1] == 0)System.out.println("Erro lógico");
                    else dividir(vetor); 
                break;
                case 0: continuarCalculadora = confirmarSaida(ler); break;
	            default:System.out.println("Opção inválida");
            }
        }
        return true;
    }
    public static void somar(double [] vetor){
        System.out.println("Soma de 2 números");
        vetor[0] = vetor[0] + vetor[1];
        System.out.println("A soma é " + vetor[0] + "\nO valor das variaveis n1 e n2 são respectivamente: " + vetor[0] + " " + vetor[1]);
    }
    public static void subtrair(double [] vetor){
        System.out.println("Subtração de 2 números");
        vetor[0] = vetor[0] - vetor[1];
        System.out.println("A subtração é " + vetor[0] + "\nO valor das variaveis n1 e n2 são respectivamente: " + vetor[0] + " " + vetor[1]);
    }
    public static void multiplicar(double [] vetor){
        System.out.println("Multiplicação de 2 números");
        vetor[0] = vetor[0] * vetor[1];
        System.out.println("A multiplicação é " + vetor[0] + "\nO valor das variaveis n1 e n2 são respectivamente: " + vetor[0] + " " + vetor[1]);
    }
    public static void dividir(double [] vetor){
        System.out.println("Divisão de 2 números");
        vetor[0] = vetor[0] / vetor[1];
        System.out.println("A divisão é " + vetor[0] + "\nO valor das variaveis n1 e n2 são respectivamente: " + vetor[0] + " " + vetor[1]);
    }   
}