package br.udesc.apresentacao;
import br.udesc.negocio.Imobiliaria;
import br.udesc.dados.Imovel;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {   
    public Scanner scanner = new Scanner(System.in);
    public List<Imobiliaria> imobiliarias = new ArrayList<Imobiliaria>();

    public int menu() {
        System.out.println("1 - Cadastrar Imobiliaria");
        System.out.println("2 - Cadastrar Imovel");
        System.out.println("3 - Listar Imoveis");
        System.out.println("4 - Filtrar Imoveis por Area");
        System.out.println("5 - Listar Imobiliarias");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        return Integer.parseInt(scanner.nextLine());
    }
    public void listarImobiliarias() {
        System.out.println("Imobiliarias cadastradas:");
        for (Imobiliaria imobiliaria : imobiliarias) {
            System.out.println(imobiliaria.getNome());
        }
    }
    public Imobiliaria cadastrarImobiliaria() {
        System.out.print("Digite o nome da imobiliaria: ");
        String nome = scanner.nextLine();
        Imobiliaria imobiliaria = new Imobiliaria(nome);
        imobiliarias.add(imobiliaria);
        System.out.println("Imobiliaria cadastrada com sucesso!");
        return imobiliaria;
    }
    public void cadastrarImovel() {
        System.out.print("Digite o nome da imobiliaria: ");
        String nome = scanner.nextLine();
        Imobiliaria imobiliaria = null;
        for (Imobiliaria i : imobiliarias) {
            if (i.getNome().equals(nome)) {
                imobiliaria = i;
                break;
            }
        }
        if (imobiliaria == null) {
            System.out.println("Imobiliaria não encontrada! Cadastre-a primeiro.");
            imobiliaria = cadastrarImobiliaria();
        }
        System.out.print("Digite a largura do imovel: ");
        float largura = Float.parseFloat(scanner.nextLine());
        System.out.print("Digite o comprimento do imovel: ");
        float comprimento = Float.parseFloat(scanner.nextLine());
        System.out.print("Digite o preco do imovel: ");
        float preco = Float.parseFloat(scanner.nextLine());
        Imovel imovel = new Imovel(largura, comprimento, preco);
        imobiliaria.adicionarImovel(imovel);
        System.out.println("Imovel cadastrado com sucesso!");
    }
    public void listarImoveis() {
        System.out.print("Digite o nome da imobiliaria: ");
        String nome = scanner.nextLine();
        Imobiliaria imobiliaria = null;
        for (Imobiliaria i : imobiliarias) {
            if (i.getNome().equals(nome)) {
                imobiliaria = i;
                break;
            }
        }
        if (imobiliaria == null) {
            System.out.println("Imobiliaria não encontrada!");
            return;
        }
        System.out.println(imobiliaria.toString());
    }
    public void filtrarImoveisPorArea() {
        System.out.print("Digite o nome da imobiliaria: ");
        String nome = scanner.nextLine();
        Imobiliaria imobiliaria = null;
        for (Imobiliaria i : imobiliarias) {
            if (i.getNome().equals(nome)) {
                imobiliaria = i;
                break;
            }
        }
        if (imobiliaria == null) {
            System.out.println("Imobiliaria não encontrada!");
            return;
        }
        System.out.print("Digite a area minima: ");
        float areaMinima = Float.parseFloat(scanner.nextLine());
        List<Imovel> imoveisFiltrados = imobiliaria.filtrarPorArea(areaMinima);
        System.out.println("Imoveis filtrados:");
        for (Imovel imovel : imoveisFiltrados) {
            System.out.println(imovel.toString());
        }
    }
    public static void main( String[] args )
    {
        Main m = new Main();
        int opt;
        do {
            opt = m.menu();
            switch (opt) {
                case 1:
                    m.cadastrarImobiliaria();
                    break;
                case 2:
                    m.cadastrarImovel();
                    break;
                case 3:
                    m.listarImoveis();
                    break;
                case 4:
                    m.filtrarImoveisPorArea();
                    break;
                case 5:
                    m.listarImobiliarias();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opt != 0);
    }
}
