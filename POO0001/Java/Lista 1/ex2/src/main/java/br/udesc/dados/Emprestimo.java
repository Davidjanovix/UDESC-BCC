package br.udesc.dados;
import java.util.Date;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private Date dataEmprestimo;

    public Emprestimo() {}

    public Emprestimo(Livro livro, Usuario usuario, Date dataEmprestimo) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }
    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Emprestimo) {
            Emprestimo outro = (Emprestimo) obj;
            return this.livro.equals(outro.livro) && this.usuario.equals(outro.usuario);
        }
        return false;
    }

    public String toString() {
        return "Empréstimo: " + livro.getTitulo() + " para " + usuario.getNome() + " em " + dataEmprestimo;
    }
}
