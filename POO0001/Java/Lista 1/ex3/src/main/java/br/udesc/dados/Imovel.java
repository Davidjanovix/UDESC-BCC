package br.udesc.dados;

public class Imovel {
    private float largura;
    private float comprimento;
    private float preco;

    public Imovel(float largura, float comprimento, float preco) {
        this.largura = largura;
        this.comprimento = comprimento;
        this.preco = preco;
    }

    public Imovel() {}

    public float area() {
        return largura * comprimento;
    }
    public String toString() {
        return "Largura: " + largura + "m, Comprimento: " + comprimento + "m, Preço: " + preco + "R$, Área: " + area() + "m²";
    }
    public float getLargura() {
        return largura;
    }
    public float getComprimento() {
        return comprimento;
    }
    public float getPreco() {
        return preco;
    }
    public void setLargura(float largura) {
        this.largura = largura;
    }
    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
}
