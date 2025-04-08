package br.udesc.apresentacao;
import br.udesc.dados.*;
import br.udesc.sistema.Biblioteca;
import java.util.Date;
import java.util.Scanner;

public class Main {
    Biblioteca biblioteca = new Biblioteca();
    Scanner scanner = new Scanner(System.in);

    public int menu() {
        System.out.println("1. Adicionar Autor");
        System.out.println("2. Adicionar Livro");
        System.out.println("3. Adicionar Usuário");
        System.out.println("4. Adicionar Empréstimo");
        System.out.println("5. Remover Autor");
        System.out.println("6. Remover Livro");
        System.out.println("7. Remover Usuário");
        System.out.println("8. Remover Empréstimo");
        System.out.println("9. Listar Autores");
        System.out.println("10. Listar Livros");
        System.out.println("11. Listar Usuários");
        System.out.println("12. Listar Empréstimos");
        System.out.println("0. Sair");
        return Integer.parseInt(scanner.nextLine());
    }

    public void adicionarAutor() {
        System.out.println("Digite o nome do autor:");
        String nome = scanner.nextLine();
        System.out.println("Digite a nacionalidade do autor:");
        String nacionalidade = scanner.nextLine();
        System.out.println("Digite o ano de nascimento do autor:");
        int anoNascimento = Integer.parseInt(scanner.nextLine());
        Autor autor = new Autor(nome, nacionalidade, anoNascimento);
        biblioteca.adicionarAutor(autor);
    }

    public void adicionarLivro() {
        System.out.println("Digite o título do livro:");
        String titulo = scanner.nextLine();
        System.out.println("Digite o ISBN do livro:");
        String isbn = scanner.nextLine();
        System.out.println("Digite o nome do autor do livro:");
        String nomeAutor = scanner.nextLine();
        Autor autor = biblioteca.getAutor(nomeAutor);
        if (autor == null) {
            System.out.println("Autor não encontrado. Adicionando novo autor.");
            adicionarAutor();
            autor = biblioteca.getAutor(nomeAutor);
        }
        Livro livro = new Livro(titulo, isbn, autor);
        biblioteca.adicionarLivro(livro);
    }

    public void adicionarUsuario() {
        System.out.println("Digite o nome do usuário:");
        String nome = scanner.nextLine();
        System.out.println("Digite o email do usuário:");
        String email = scanner.nextLine();
        Usuario usuario = new Usuario(nome, email);
        biblioteca.adicionarUsuario(usuario);
    }

    public void adicionarEmprestimo() {
        System.out.println("Digite o isbn do livro:");
        String isbn = scanner.nextLine();
        Livro livro = biblioteca.getLivro(isbn);
        if (livro != null && livro.isEmprestado()) {
            Usuario usuario = biblioteca.livroEmprestadoPara(livro);
            System.out.println("Livro já emprestado para " + usuario.getNome());
            return;
        }
        if (livro == null) {
            System.out.println("Livro não encontrado. Adicionando novo livro.");
            adicionarLivro();
            livro = biblioteca.getLivro(isbn);
        }
        System.out.println("Digite o nome do usuário:");
        String nomeUsuario = scanner.nextLine();
        Usuario usuario = biblioteca.getUsuario(nomeUsuario);
        if (usuario == null) {
            System.out.println("Usuário não encontrado. Adicionando novo usuário.");
            adicionarUsuario();
            usuario = biblioteca.getUsuario(nomeUsuario);
        }
        Date dataEmprestimo = new Date();
        Emprestimo emprestimo = new Emprestimo(livro, usuario, dataEmprestimo);
        biblioteca.adicionarEmprestimo(emprestimo);
    }

    public void listarUsuarios() {
        System.out.println("Lista de Usuários:");
        for (Usuario usuario : biblioteca.getUsuarios()) {
            System.out.println(usuario);
        }
    }

    public void listarLivros() {
        System.out.println("Lista de Livros:");
        for (Livro livro : biblioteca.getLivros()) {
            System.out.println(livro);
        }
    }

    public void listarAutores() {
        System.out.println("Lista de Autores:");
        for (Autor autor : biblioteca.getAutores()) {
            System.out.println(autor);
        }
    }

    public void listarEmprestimos() {
        System.out.println("Digite o nome do usuário:");
        String nomeUsuario = scanner.nextLine();
        Usuario usuario = biblioteca.getUsuario(nomeUsuario);
        if (usuario != null) {
            System.out.println("Lista de Empréstimos do Usuário " + usuario.getNome() + ":");
            for (Emprestimo emprestimo : biblioteca.emprestimosPorUsuario(usuario)) {
                System.out.println(emprestimo);
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void removerAutor() {
        System.out.println("Digite o nome do autor a ser removido:");
        String nome = scanner.nextLine();
        Autor autor = biblioteca.getAutor(nome);
        if (autor != null) {
            biblioteca.getAutores().remove(autor);
            System.out.println("Autor removido com sucesso.");
        } else {
            System.out.println("Autor não encontrado.");
        }
    }
    public void removerLivro() {
        System.out.println("Digite o ISBN do livro a ser removido:");
        String isbn = scanner.nextLine();
        Livro livro = biblioteca.getLivro(isbn);
        if (livro != null) {
            biblioteca.getLivros().remove(livro);
            System.out.println("Livro removido com sucesso.");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }
    public void removerUsuario() {
        System.out.println("Digite o nome do usuário a ser removido:");
        String nome = scanner.nextLine();
        Usuario usuario = biblioteca.getUsuario(nome);
        if (usuario != null) {
            biblioteca.getUsuarios().remove(usuario);
            System.out.println("Usuário removido com sucesso.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
    public void removerEmprestimo() {
        System.out.println("Digite o ISBN do livro:");
        String isbn = scanner.nextLine();
        Livro livro = biblioteca.getLivro(isbn);
        if (livro != null) {
            Emprestimo emprestimo = biblioteca.getEmprestimo(livro);
            if (emprestimo == null) {
                System.out.println("O livro não está emprestado.");
                return;
            }
            biblioteca.removerEmprestimo(emprestimo);
            System.out.println("Empréstimo removido com sucesso.");
        } else {
            System.out.println("Empréstimo não encontrado.");
        }
    }
    public static void main(String[] args) {
        Main m = new Main();
        int opt;
        do {
            opt = m.menu();
            switch (opt) {
                case 1:
                    m.adicionarAutor();
                    break;
                case 2:
                    m.adicionarLivro();
                    break;
                case 3:
                    m.adicionarUsuario();
                    break;
                case 4:
                    m.adicionarEmprestimo();
                    break;
                case 5:
                    m.removerAutor();
                    break;
                case 6:
                    m.removerLivro();
                    break;
                case 7:
                    m.removerUsuario();
                    break;
                case 8:
                    m.removerEmprestimo();
                    break;
                case 9:
                    m.listarAutores();
                    break;
                case 10:
                    m.listarLivros();
                    break;
                case 11:
                    m.listarUsuarios();
                    break;
                case 12:
                    m.listarEmprestimos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opt != 0);
    }
}
