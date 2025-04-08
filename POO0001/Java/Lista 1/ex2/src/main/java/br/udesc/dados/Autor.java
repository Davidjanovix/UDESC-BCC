package br.udesc.dados;


public class Autor {
    private String nome;
    private String nacionalidade;
    private int anoNascimento;

    public Autor() {}

    public Autor(String nome, String nacionalidade, int anoNascimento) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.anoNascimento = anoNascimento;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }
    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Autor) {
            Autor outro = (Autor) obj;
            return this.nome.equals(outro.nome);
        }
        return false;
    }

    public String toString() {
        return nome + " (" + nacionalidade + ", " + anoNascimento + ")";
    }
}
