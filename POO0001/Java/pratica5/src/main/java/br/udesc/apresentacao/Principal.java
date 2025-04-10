package br.udesc.apresentacao;
import br.udesc.dados.Contato;
import br.udesc.negocio.ListaTelefonica;
import java.util.Scanner;

public class Principal 
{
    private ListaTelefonica lista = new ListaTelefonica();
    private Scanner scanner = new Scanner(System.in);

    public ListaTelefonica getLista() {
        return lista;
    }
    public void setLista(ListaTelefonica lista) {
        this.lista = lista;
    }
    public char menu() {
        System.out.println("1 - Adicionar contato");
        System.out.println("2 - Remover contato");
        System.out.println("3 - Exibir contatos");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextLine().charAt(0);
    }

    public void exibirContatos() {
        System.out.print(lista);
    }

    public void removerContato() {
        System.out.print("Digite a inicial do nome do contato: ");
        char inicial = Character.toUpperCase(scanner.nextLine().charAt(0));
        for (Contato c : lista.buscarContatos(inicial)) {
            System.out.println(c + "\n");
        }
        System.out.print("Digite o nome do contato: ");
        String nome = scanner.nextLine();
        Contato c = lista.getContato(nome);
        if (c != null) {
            lista.removerContato(c);
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
    
    public void adicionarContato() {
        System.out.print("Digite o nome do contato: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o telefone do contato: ");
        String telefone = scanner.nextLine();
        Contato c = new Contato(nome, telefone);
        lista.adicionarContato(c);
        System.out.println("Contato adicionado com sucesso!");
    }
    public static void main( String[] args ) {
        Principal p = new Principal();
        char opt;
        do {
            opt = p.menu();
            switch (opt) {
                case '1':
                    p.adicionarContato();
                    break;
                case '2':
                    p.removerContato();
                    break;
                case '3':
                    p.exibirContatos();
                    break;
                case '0':
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opt != '0');
    }
}
