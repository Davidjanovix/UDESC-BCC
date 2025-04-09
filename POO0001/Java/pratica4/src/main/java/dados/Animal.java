package dados;

public class Animal {
    private String nome;
    private String cor;
    private String especie;
    private int idade;
    protected float largura;
    protected float comprimento;

    public Animal(String nome, String cor, String especie, int idade) {
        this.nome = nome;
        this.cor = cor;
        this.especie = especie;
        this.idade = idade;
    }
    public Animal() {}

    public float calculaEspacoOcupado() {
        return largura * comprimento;
    }

}
