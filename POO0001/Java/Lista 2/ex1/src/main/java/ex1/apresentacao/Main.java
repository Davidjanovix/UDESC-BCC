package ex1.apresentacao;

import ex1.dados.Pessoa;
import ex1.sistema.Sistema;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.InputStream;

public class Main {
    Sistema sistema = new Sistema();
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        
        Main m = new Main();

        System.out.println("Deseja ler pessoas de um arquivo? (s/n): ");
        String resposta = m.sc.nextLine();

        if (resposta.equalsIgnoreCase("s")) {
            m.lerPessoasDoCSV();
            m.exibirListas();
        } 

        while (true) {
            System.out.println("\nDigite os dados da pessoa (ou -1 para parar):");

            System.out.print("Nome: ");
            String nome = m.sc.nextLine();
            if (nome.equals("-1")) break;

            System.out.print("Idade: ");
            int idade = Integer.parseInt(m.sc.nextLine());

            System.out.print("CPF: ");
            String cpf = m.sc.nextLine();

            System.out.print("Cidade: ");
            String cidade = m.sc.nextLine();

            Pessoa p = new Pessoa(nome, idade, cpf, cidade);

            m.sistema.adicionarPessoa(p);
            m.exibirListas();
        }

        System.out.println("\nEncerrando programa.");
    }
    
    public void exibirListas() {
        System.out.println("\n--- Pessoas cadastradas ---");
        exibirGrupo("Crianças", sistema.getCriancas());
        exibirGrupo("Adolescentes", sistema.getAdolescentes());
        exibirGrupo("Jovens", sistema.getJovens());
        exibirGrupo("Adultos", sistema.getAdultos());
        exibirGrupo("Idosos", sistema.getIdosos());
    }

    private void exibirGrupo(String tipo, List<Pessoa> grupo) {
        if (!grupo.isEmpty()) {
            System.out.println(tipo + ":");
            Collections.sort(grupo);
            for (Pessoa p : grupo) {
                System.out.println("\t– " + p);
            }
        }
    }

    public void lerPessoasDoCSV() {
        InputStream is = Main.class.getResourceAsStream("/ex1/arquivo/pessoas.csv");
        if (is == null) {
            System.out.println("Arquivo não encontrado.");
            return;
        }
    
        try (Scanner sc = new Scanner(is)) {
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] dados = linha.split(",");
    
                if (dados.length == 4) {
                    String nome = dados[0].trim();
                    int idade = Integer.parseInt(dados[1].trim());
                    String cpf = dados[2].trim();
                    String cidade = dados[3].trim();
    
                    Pessoa pessoa = new Pessoa(nome, idade, cpf, cidade);
                    sistema.adicionarPessoa(pessoa);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: ");
        }
    }
    
}
