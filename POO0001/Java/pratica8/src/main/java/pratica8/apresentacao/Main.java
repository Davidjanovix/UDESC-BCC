package pratica8.apresentacao;
import java.util.Scanner;
import pratica8.negocio.ListaTelefonica;
import pratica8.dados.Contato;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Main 
{
    ListaTelefonica listaTelefonica = new ListaTelefonica();
    Scanner scanner = new Scanner(System.in);
    public static void main( String[] args )
    {
        Main main = new Main();
        main.menu();
    }
    public void adicionarContato() {
        System.out.println("Digite o nome do contato:");
        String nome = scanner.nextLine();
        System.out.println("Digite o telefone do contato:");
        String telefone = scanner.nextLine();
        listaTelefonica.adicionarContato(new Contato(nome, telefone));
        System.out.println("Contato adicionado com sucesso!");
    }
    public void removerContato() {
        System.out.println("Digite a inicial do nome do contato:");
        char letra = scanner.nextLine().charAt(0);
        List<Contato> lista = listaTelefonica.buscarContato(Character.toUpperCase(letra));
        for(Contato c : lista) {
            System.out.println(c);
        }
        System.out.println("Digite o nome do contato a ser removido:");
        String nome = scanner.nextLine();
        listaTelefonica.removerContato(listaTelefonica.buscarPorNome(nome));
        System.out.println("Contato removido com sucesso!");
    }
    public void exibirContatos() {
        System.out.println("Lista de contatos:");
        for(char letra = 'A'; letra <= 'Z'; letra++) {
            List<Contato> lista = listaTelefonica.buscarContato(letra);
            if (lista != null && !lista.isEmpty()) {
                System.out.println("Contatos com a letra " + letra + ":");
                for (Contato c : lista) {
                    System.out.println("\t" + c);
                }
            }
        }
    }
    public void menu() {
        int opcao;
        do {
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Exibir contatos");
            System.out.println("0 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            switch (opcao) {
                case 1:
                    adicionarContato();
                    break;
                case 2:
                    removerContato();
                    break;
                case 3:
                    exibirContatos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
