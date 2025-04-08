package br.udesc.dados;
public class Livro {
    private String titulo;
    private String isbn;
    private Autor autor;
    private boolean emprestado;

    public Livro() {}

    public Livro(String titulo, String isbn, Autor autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Livro) {
            Livro outro = (Livro) obj;
            return this.isbn.equals(outro.isbn);
        }
        return false;
    }

    public String toString() {
        return "Livro: " + titulo + ", ISBN: " + isbn + ", Autor: " + autor;
    }

    public boolean isEmprestado() {
        return emprestado;
    }
    
    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
}
