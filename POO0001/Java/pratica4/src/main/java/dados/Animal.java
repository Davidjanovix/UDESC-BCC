package dados;

public class Animal {
    private String nome;
    private String cor;
    private String especie;
    private int idade;
    protected float largura;
    protected float altura;
    protected float comprimento;

    public Animal(String nome, String cor, String especie, int idade) {
        this.nome = nome;
        this.cor = cor;
        this.especie = especie;
        this.idade = idade;
    }

    public Animal() {}

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public String getEspecie() {
        return especie;
    }

    public int getIdade() {
        return idade;
    }

    public float getLargura() {
        return largura;
    }

    public float getAltura() {
        return altura;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float calculaEspacoOcupado() {
        return largura * comprimento;
    }

    public String toString() {
        return "Nome: " + nome + " Cor: " + cor +                   
                " Especie: " + especie + " Idade: " + idade;
                
    }

}
