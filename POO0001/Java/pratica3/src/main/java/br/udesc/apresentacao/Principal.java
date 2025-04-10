package br.udesc.apresentacao;
import br.udesc.dados.*;
import br.udesc.negocio.ReservaPassagem;
import java.util.Scanner;
import java.util.List;

public class Principal 
{
    private static Scanner scanner = new Scanner(System.in);
    private static ReservaPassagem sistema = new ReservaPassagem();
    public static void main( String[] args )
    {
        int opt;
        do {
            System.out.println("Selecione uma das opções: ");
            System.out.println("[1] Ver lista de cidades.");
            System.out.println("[2] Cadastrar uma nova cidade.");
            System.out.println("[3] Ver lista de clientes.");
            System.out.println("[4] Cadastrar um novo cliente.");
            System.out.println("[5] Ver as reservas de um cliente.");
            System.out.println("[6] Criar uma nova reserva.");
            System.out.println("[0] Sair");
            System.out.print("Opção: ");
            opt = scanner.nextInt();
            scanner.nextLine();
            switch(opt) {
                case 1:
                    mostrarCidades();
                    System.out.print("\n");
                    break;
                case 2:
                    cadastrarCidade();
                    System.out.print("\n");
                    break;
                case 3:
                    mostrarClientes();
                    System.out.print("\n");
                    break;
                case 4:
                    cadastrarCliente();
                    System.out.print("\n");
                    break;
                case 5:
                    mostrarReservas();
                    System.out.print("\n");
                    break;
                case 6:
                    fazerReserva();
                    System.out.print("\n");
                    break;
                case 0:
                System.out.print("\n");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    System.out.print("\n");
                    break;
            }
        } while (opt != 0);
    }

    public static void fazerReserva() {
        List<Cliente> clientes = sistema.mostrarClientes();
        Cliente clienteReserva = null;
        System.out.println("Lista de clientes cadastrados: "); 
        for (Cliente cliente : clientes) {      //Lista os clientes pelo CPF e nome          
            System.out.println(cliente.getCpf() + "    " + cliente.getNome());
        }
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {     //Encontra o cliente pelo CPF
                clienteReserva = cliente;
                break;
            }
        }
        if (clienteReserva == null) {
            System.out.println("Cliente não encontrado!");
            return;     //Encerra a execução se não encontrar o CPF no banco de clientes
        }
        
        System.out.print("Digite o número da reserva: ");
            int numReserva = scanner.nextInt();     
            scanner.nextLine(); //Limpeza do buffer
            System.out.print("Digite a data do voo: ");
            String dataVoo = scanner.nextLine();
            System.out.print("Digite a hora do voo: ");
            String horaVoo = scanner.nextLine();
            System.out.print("Digite o preço da passagem: ");
            float preco = scanner.nextFloat();
            scanner.nextLine(); //Limpeza do buffer
            System.out.print("Digite a classe: ");
            String classeVoo = scanner.nextLine();
            System.out.print("Digite o número da poltrona: ");
            int poltrona = scanner.nextInt();
            scanner.nextLine();
            for (Cidade cidade : sistema.mostrarCidades()) {    //Lista as cidades
                System.out.println(cidade.getNome() + "\n");
            }
            System.out.print("Digite o nome da cidade de origem: ");
            String cidadeOrigem = scanner.nextLine();
            System.out.print("Digite o nome da cidade de destino: ");
            String cidadeDestino = scanner.nextLine();
            Cidade origem = null, destino = null;
            for (Cidade cidade : sistema.mostrarCidades()) {
                if (cidade.getNome().equals(cidadeOrigem)) {
                    origem = cidade;
                } else {
                    if (cidade.getNome().equals(cidadeDestino)) {
                        destino = cidade;
                    }
                }
            }
            if (origem == null || destino == null) {    //Se alguma cidade não for encontrada, encerra a execução
                System.out.println("Algo deu errado, digite os nomes corretamente.");
                return;
            }
            System.out.println("Selecione uma das opções: ");
            System.out.println("[1] Viagem de ida.");
            System.out.println("[2] Viagem de volta.");
            int opt = scanner.nextInt();
            scanner.nextLine(); //Limpeza do buffer
            Reserva newReserva = new Reserva(numReserva, dataVoo, horaVoo, preco, classeVoo, poltrona, origem, destino);
        if (opt == 1) {     //Se for selecionado viagem de ida, apenas cria uma nova reserva de ida
            clienteReserva.reservarIda(newReserva);
        } else{
            if (opt == 2) {     //Se for selecionado viagem de volta, solicita a qual ida a volta pertence
                System.out.println("Lista de reservas do cliente: ");
                for (Reserva reserva : clienteReserva.getReservas()) {
                    System.out.println(reserva.getNumReserva() + " - de " + reserva.getOrigem().toString() + " a " + reserva.getDestino().toString());
                }
                System.out.println("Informe o número da reserva de ida referente a essa volta: ");
                numReserva = scanner.nextInt();
                scanner.nextLine(); //Limpeza do buffer
                Reserva ida = null;
                for (Reserva reserva : clienteReserva.getReservas()) {
                    if (reserva.getNumReserva() == numReserva) {    //Encontra a reserva de ida
                        ida = reserva;
                    }
                }
                if (ida == null) {
                    System.out.println("Reserva não encontrada.");
                    return; //Se não encontrar a ida, encerra a execução
                }
                clienteReserva.reservarVolta(ida, newReserva);  //Registra a reserva de volta
            } else {    //Para opções diferentes de 1 ou 2, encerra a execução
                System.out.println("Opção inválida.");
                return;
            }

        }
    }

    public static void cadastrarCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o cpf do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o endereco do cliente: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        sistema.cadastrarCliente(new Cliente(cpf, nome, endereco, telefone));
    }

    public static void cadastrarCidade() {
        System.out.print("Digite o nome da cidade: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o estado da cidade: ");
        String estado = scanner.nextLine();
        sistema.cadastrarCidade(new Cidade(nome, estado));
    }

    public static void mostrarReservas() {
        List<Cliente> clientes = sistema.mostrarClientes();
        Cliente clienteReserva = null;
        System.out.println("Lista de clientes cadastrados: ");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getCpf() + "    " + cliente.getNome());
        }
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                clienteReserva = cliente;
                break;
            }
        }
        if (clienteReserva == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }
        //List<Reserva> reservas = sistema.mostrarReservas(cpf);
        System.out.println(clienteReserva.toString());
    }

    public static void mostrarCidades() {
        List<Cidade> cidades = sistema.mostrarCidades();
        for (Cidade cidade : cidades) {
            System.out.println(cidade.toString());
        }
    }

    public static void mostrarClientes() {
        List<Cliente> clientes = sistema.mostrarClientes();
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome() + "   Cpf: " + cliente.getCpf());
        }
    }
}
