package br.udesc.pratica2.dados;

public class Dono {
    private String nome;
    private String cpf;
    Endereco endereco;



    //Construtor

    public Dono(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }


    //Setters

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    //Getters

    public Endereco getEndereco(){
        return endereco;
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
}
