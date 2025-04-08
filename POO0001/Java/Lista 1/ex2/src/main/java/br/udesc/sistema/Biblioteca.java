package br.udesc.sistema;
import java.util.ArrayList;
import java.util.List;

import br.udesc.dados.*;

public class Biblioteca {

    private List<Autor> autores = new ArrayList<Autor>();
    private List<Livro> livros = new ArrayList<Livro>();
    private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public Biblioteca() {}

    public void adicionarAutor(Autor autor) {
            autores.add(autor);
    }

    public void adicionarLivro(Livro livro) {
            livros.add(livro);
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
            emprestimos.add(emprestimo);
            emprestimo.getLivro().setEmprestado(true);
    }

    public void adicionarUsuario(Usuario usuario) {
            usuarios.add(usuario);
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Autor getAutor(String nome) {
        for (Autor autor : autores) {
            if (autor.getNome().equalsIgnoreCase(nome)) {
                return autor;
            }
        }
        return null;
    }

    public Livro getLivro(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }

    public Usuario getUsuario(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                return usuario;
            }
        }
        return null;
    }

    public Emprestimo getEmprestimo(Livro livro) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivro().equals(livro)) {
                return emprestimo;
            }
        }
        return null;
    }

    public void removerAutor(Autor autor) {
        autores.remove(autor);
    }

    public void removerLivro(Livro livro) {
        livros.remove(livro);
    }

    public void removerEmprestimo(Emprestimo emprestimo) {
        emprestimo.getLivro().setEmprestado(false);
        emprestimos.remove(emprestimo);
    }

    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }
    
    public List<Emprestimo> emprestimosPorUsuario(Usuario usuario) {
        List<Emprestimo> emprestimosUsuario = new ArrayList<Emprestimo>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().equals(usuario)) {
                emprestimosUsuario.add(emprestimo);
            }
        }
        return emprestimosUsuario;
    }

    public Usuario livroEmprestadoPara(Livro livro) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivro().equals(livro)) {
                return emprestimo.getUsuario();
            }
        }
        return null;
    }

}

