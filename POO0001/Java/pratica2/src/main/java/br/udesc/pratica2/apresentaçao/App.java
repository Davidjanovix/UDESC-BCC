package br.udesc.pratica2.apresentaçao;
import java.util.Scanner;
import br.udesc.pratica2.dados.*;

public class App 
{

    private static Scanner scanner = new Scanner(System.in);
    public static SistemaPetShop sistema = new SistemaPetShop(); //Instancia um objeto SistemaPetShop para acessar os métodos da classe


    public static void main( String[] args )
    {
        int opt = 0;
        limparTela();
        do {
            System.out.println("Selecione uma das opções: ");
            System.out.println("1 - Cadastrar veterinário");
            System.out.println("2 - Mostrar veterinários");
            System.out.println("0 - Sair");
            opt = scanner.nextInt();
            scanner.nextLine(); //Limpa o buffer do teclado
            limparTela();
            switch(opt) {
                case 1:
                    cadastrarVeterinario();
                    limparTela();
                    break; 
                case 2:
                    int vet = 0;
                    do {
                        System.out.println("Veterinários cadastrados: ");
                        mostrarVeterinarios();
                        System.out.println("\n\n\n");
                        System.out.println("Digite o número do veterinário que deseja acessar ou 0 para sair: ");
                        vet = scanner.nextInt();
                        scanner.nextLine(); //Limpa o buffer do teclado

                        if (vet > 0 && vet <= sistema.getQuantidadeVeterinarios()) {
                            int opt2 = 0;
                            limparTela();
                            do {
                                System.out.println("Veterinário: " + sistema.getVeterinario(vet - 1).getNome());
                                System.out.println("Selecione uma das opções: ");
                                System.out.println("1 - Mostrar dados do veterinário");
                                System.out.println("2 - Cadastrar endereço do veterinário");
                                System.out.println("3 - Mostrar animais do veterinário");
                                System.out.println("0 - Voltar");
                                opt2 = scanner.nextInt();
                                scanner.nextLine(); //Limpa o buffer do teclado
                                limparTela();
                                Veterinario veterinario = sistema.getVeterinario(vet - 1); //Armazena o veterinário selecionado na variável veterinario

                                switch(opt2) {
                                    case 1:
                                        System.out.println("Nome: " + veterinario.getNome());
                                        System.out.println("Salário: " + veterinario.getSalario());
                                        System.out.println("Quantidade de animais atendidos: " + veterinario.quantidadeAnimaisCadastrados() + "/" + veterinario.getQuantidadeAnimais());
                                        mostrarEndereco(veterinario.getEndereco());
                                        System.out.println("\n\n\n");
                                        break;
                                    case 2:
                                        cadastrarEnderecoVeterinario(veterinario);
                                        limparTela();
                                        break;
                                    case 3:
                                        System.out.println("Animais do veterinário " + veterinario.getNome() + ": ");
                                        mostrarAnimais(veterinario);
                                        System.out.println("\n\n\n");
                                        int opt3 = 0;
                                        do {
                                            System.out.println("Selecione uma das opções: ");
                                            System.out.println("1 - Cadastrar novo animal");
                                            System.out.println("2 - Ver a ficha do animal");
                                            System.out.println("0 - Voltar");
                                            opt3 = scanner.nextInt();
                                            scanner.nextLine(); //Limpa o buffer do teclado
                                            limparTela();
                                            switch(opt3) {
                                                case 1: 
                                                    cadastrarAnimal(veterinario);
                                                    opt3 = 0;
                                                    break;
                                                case 2:
                                                    mostrarAnimais(veterinario);
                                                    System.out.println("Digite o número do animal que deseja ver: ");
                                                    int numero = scanner.nextInt();
                                                    scanner.nextLine(); //Limpa o buffer do teclado
                                                    limparTela();
                                                    numero--; //Decrementa o número digitado pelo usuário para acessar o índice correto do array de animais
                                                    Animal animal = veterinario.getAnimais()[numero]; //Acessa o animal no índice do array 
                                                    mostrarAnimal(animal);                            //e armazena na variável animal
                                                    System.out.println("Pressione enter para continuar...");
                                                    scanner.nextLine(); //Espera o usuário pressionar enter para continuar
                                                    limparTela();
                                                    if (animal != null) {
                                                        int opt4 = 0;
                                                        do {
                                                            System.out.println("Animal: " + animal.getNome());
                                                            System.out.println("Selecione uma das opções: ");
                                                            if (animal.getDono() == null) { //Se o animal não tiver dono, imprime a opção de cadastrar dono
                                                                System.out.println("\n1 - Cadastrar dono");                                                                    
                                                            } else {
                                                                if (animal.getDono().getEndereco() == null) {              //Se o animal tiver dono mas o dono não tiver endereço, 
                                                                    System.out.println("2 - Cadastrar endereço do dono");  //imprime a opção de cadastrar endereço do dono
                                                                }
                                                            }



                                                            System.out.println("0 - Voltar");
                                                            opt4 = scanner.nextInt();
                                                            if (animal.getDono() == null) { //Se for selecionado a opção de adicionar o endereço do dono 
                                                                if (opt4 == 2) {            //e não houver dono, incrementa a variável opt4 para evitar erros
                                                                    opt4++;
                                                                }
                                                            }
                                                            scanner.nextLine(); //Limpa o buffer do teclado
                                                            limparTela();
                                                            switch(opt4) {
                                                                case 1:
                                                                    cadastrarDono(animal);
                                                                    break;
                                                                case 2:
                                                                    cadastrarEnderecoDono(animal.getDono());
                                                                    break;
                                                                case 0:
                                                                    break;
                                                                default:
                                                                    System.out.println("Opção inválida!");
                                                                    break;
                                                            }
                                                        } while (opt4 != 0);
                                                    }
                                                    break;
                                                case 0:
                                                    break;
                                                default:
                                                    System.out.println("Opção inválida!");
                                                    break;
                                            }
                                        } while (opt3 != 0);
                                        break;
                                    case 0:
                                        break;
                                    default:
                                        System.out.println("Opção inválida!");
                                        break;
                                }
                            } while (opt2 != 0);
                        } else {
                            if (vet != 0) {
                                System.out.println("Veterinário não encontrado!");
                            } 
                        }  
                    } while (vet != 0);
                    break; 
                default:
                    System.out.println("Opção inválida!");
                    break;
                case 0:
                    break;
            }
        } while (opt != 0);
        scanner.close(); //Fecha o objeto Scanner

    }
    private static void cadastrarVeterinario()
    {
        int quantidadeVeterinarios = sistema.getQuantidadeVeterinarios();
        if (quantidadeVeterinarios < 50) {

            System.out.print("Digite o nome do veterinário: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o salário do veterinário: ");
            float salario = scanner.nextFloat();
            scanner.nextLine(); //Limpa o buffer do teclado

            System.out.print("Digite a quantidade de animais que o veterinário atende: ");
            int quantidadeAnimais = scanner.nextInt();
            scanner.nextLine(); //Limpa o buffer do teclado

            sistema.getVeterinarios()[quantidadeVeterinarios] = new Veterinario(nome, salario, quantidadeAnimais);

            sistema.setQuantidadeVeterinarios(++quantidadeVeterinarios);
            limparTela();
        } else {
            System.out.println("Não é possível cadastrar mais veterinários, limite atingido!");
        }
    }   
    private static void cadastrarEnderecoVeterinario(Veterinario veterinario) {
        veterinario.setEndereco(cadastrarEndereco());
    }
    private static void mostrarVeterinarios(){
        int i = 0;
        for (Veterinario veterinario : sistema.getVeterinarios()) {   //Para cada veterinário do array retornado por mostrarVeterinarios(), verifica se é nulo
            if (veterinario != null) {                                
                System.out.println(++i + " - " + veterinario.getNome());      //Se não for nulo, imprime o nome do veterinário sucedido pelo índice do array + 1
            }
            else {
                return;     //Se for nulo, finaliza o método
            }
        }
    }
    private static void mostrarAnimal(Animal animal){ //Método que mostra o animal
        if (animal != null) { //Verifica se o animal é nulo
            System.out.println("Nome: " + animal.getNome()); //Se não for nulo, imprime o nome do animal
            System.out.println("Espécie: " + animal.getEspecie()); //Imprime a espécie do animal
            System.out.println("Descrição: " + animal.getDescricao()); //Imprime a descrição do animal
            if (animal.getDono() != null) { //Verifica se o dono do animal é nulo
                System.out.println("Dono: " + animal.getDono().getNome()); //Se não for nulo, imprime o nome do dono
                System.out.println("CPF: " + animal.getDono().getCpf()); //Imprime o CPF do dono
                mostrarEndereco(animal.getDono().getEndereco()); //Chama o método mostrarEndereco passando o endereço do dono
            } else {
                System.out.println("Dono: Não consta na base de dados."); //Se o dono for nulo, imprime que o dono não consta na base de dados
            }
        } else {
            System.out.println("Animal não encontrado!"); //Se o animal for nulo, imprime que o animal não foi encontrado
        }
    }
    private static void mostrarAnimais(Veterinario veterinario){ 
        int i = 0; //Posição do animal no array
        for (Animal animal : veterinario.getAnimais()) { //Para cada animal do array retornado por getAnimais(), verifica se é nulo
            if (animal != null) {
                System.out.println((++i) + " - Nome: " + animal.getNome()); //Se não for nulo, imprime o nome do animal com sua respectiva posição no array + 1
            }
        }
    }
    private static void cadastrarAnimal(Veterinario veterinario){
        
        if (veterinario.quantidadeAnimaisCadastrados() < veterinario.getQuantidadeAnimais()) { //Verifica se a quantidade de animais cadastrados é menor que a quantidade de animais que o veterinário atende

            int numeroAnimal = veterinario.quantidadeAnimaisCadastrados(); //Armazena a quantidade de animais cadastrados

            System.out.print("Digite o nome do animal: ");
            String nome = scanner.nextLine(); //Captura o nome do animal

            System.out.print("Digite a espécie do animal: ");
            String especie = scanner.nextLine(); //Captura a espécie do animal

            System.out.print("Digite a descrição do animal: ");
            String descricao = scanner.nextLine(); //Captura a descrição do animal

            limparTela();
            veterinario.cadastrarAnimal(numeroAnimal, nome, especie, descricao); //Chama o método cadastrarAnimal passando o número do animal, nome, espécie e descrição

        } else {

            System.out.println("Não é possível cadastrar mais animais para este veterinário, limite atingido!");

        }
    }
    private static void cadastrarDono(Animal animal){
        System.out.print("Digite o nome do dono: ");
        String nome = scanner.nextLine(); //Captura o nome do dono

        System.out.print("Digite o CPF do dono: ");
        String cpf = scanner.nextLine(); //Captura o CPF do dono

        animal.setDono(nome, cpf); //Chama o método setDono passando o nome e o CPF do dono
    }
    private static void cadastrarEnderecoDono(Dono dono){
        dono.setEndereco(cadastrarEndereco());
    }
    private static Endereco cadastrarEndereco(){
        System.out.print("Digite a rua: ");
        String rua = scanner.nextLine();

        System.out.print("Digite o número: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o bairro: ");
        String bairro = scanner.nextLine();

        System.out.print("Digite a cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Digite o estado: ");
        String estado = scanner.nextLine();

        System.out.print("Digite o CEP: ");
        String cep = scanner.nextLine();
        limparTela();

        return new Endereco(rua, numero, bairro, cidade, estado, cep);
    }
    private static void mostrarEndereco(Endereco endereco) {
        if (endereco != null) {
            System.out.println("Endereço: ");
            System.out.println("\tRua: " + endereco.getRua());
            System.out.println("\tNúmero: " + endereco.getNumero());
            System.out.println("\tBairro: " + endereco.getBairro());
            System.out.println("\tCidade: " + endereco.getCidade());
            System.out.println("\tEstado: " + endereco.getEstado());
            System.out.println("\tCEP: " + endereco.getCep());
        } else {
            System.out.println("Endereço: Não consta na base de dados.");
        }
        
    }
    private static void limparTela() {
        // for (int i = 0; i < 50; i++) {
        //     System.out.println(); // Imprime várias linhas em branco
        // }
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();  // Usado no Linux/macOS
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
