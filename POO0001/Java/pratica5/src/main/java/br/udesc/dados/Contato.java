package br.udesc.dados;

public class Contato {
    private String nome;
    private String telefone;


    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
    public Contato() {

    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String toString() {
        return "Nome: " + nome + "\tTelefone: " + telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public boolean equals(Object obj) {
        Contato c;
        if(obj instanceof Contato) {
            c = (Contato) obj;
            if(c.getNome().equals(this.getNome())) {
                return true;
            }
        }
        return false;
    }
}
