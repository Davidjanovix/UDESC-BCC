package br.udesc.apresentacao;
import br.udesc.dados.*;
import br.udesc.sistema.Biblioteca;
import java.util.Date;

public class Main {
    Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        Main m = new Main();
        Usuario usuario1 = new Usuario();
        usuario1.setNome("João");
        m.biblioteca.adicionarUsuario(usuario1);
        usuario1.setEmail("joaozinho123@gmail.com");

        Usuario usuario2 = new Usuario("Maria", "maria321@gmail.com");
        m.biblioteca.adicionarUsuario(usuario2);

        Autor autor1 = new Autor();
        autor1.setNome("J.R.R. Tolkien");
        m.biblioteca.adicionarAutor(autor1);
        m.biblioteca.getAutor("J.R.R. Tolkien").setNacionalidade("Britânico");
        autor1.setAnoNascimento(1892);

        Autor autor2 = new Autor("J.K. Rowling", "Britânica", 1965);
        m.biblioteca.adicionarAutor(autor2);

        Livro livro1 = new Livro();
        livro1.setTitulo("O Hobbit");
        livro1.setAutor(autor1);
        livro1.setIsbn("978-3-16-148410-0");
        m.biblioteca.adicionarLivro(livro1);

        Livro livro2 = new Livro("Harry Potter e a Pedra Filosofal", "978-3-16-148410-1", autor2);
        m.biblioteca.adicionarLivro(livro2);

        Emprestimo emprestimo1 = new Emprestimo();
        emprestimo1.setUsuario(usuario1);
        emprestimo1.setLivro(livro1);
        m.biblioteca.adicionarEmprestimo(emprestimo1);
        emprestimo1.setDataEmprestimo(new Date());

        Emprestimo emprestimo2 = new Emprestimo(livro2, usuario2, new Date());
        m.biblioteca.adicionarEmprestimo(emprestimo2);

        System.out.println("Empréstimos:");
        for (Emprestimo emprestimo : m.biblioteca.getEmprestimos()) {
            System.out.println(emprestimo);
        }
        System.out.println("Livros:");
        for (Livro livro : m.biblioteca.getLivros()) {
            System.out.println(livro);
        }
        System.out.println("Autores:");
        for (Autor autor : m.biblioteca.getAutores()) {
            System.out.println(autor);
        }
        System.out.println("Usuários:");
        for (Usuario usuario : m.biblioteca.getUsuarios()) {
            System.out.println(usuario);
        }
    }
}
