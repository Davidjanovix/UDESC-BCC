package br.udesc.pratica2.dados;

public class Animal {
    private String nome;
    private String especie;
    private String descricao;
    private Dono dono;



    //Construtor

    public Animal(String nome, String especie, String descricao) {
        this.nome = nome;
        this.especie = especie;
        this.descricao = descricao;
    }


    //Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDono(String nome, String cpf) {
         dono = new Dono(nome, cpf);
    }


    //Getters

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getDescricao() {
        return descricao;
    }

    public Dono getDono() {
        return dono;
    }
}
