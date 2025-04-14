package dados;

public class Peixe extends Animal {
    private float temperaturaIdeal;

    public Peixe(String nome, String cor, String especie, int idade) {
        super();
        setNome(nome);
        setCor(cor);
        setEspecie(especie);
        setIdade(idade);
    }

    public Peixe() {
        super();
    }

    public float getTemperaturaIdeal() {
        return temperaturaIdeal;
    }

    public void setTemperaturaIdeal(float temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }

    public float calculaEspacoOcupado() {
        return comprimento * largura * altura;
    }

}
