package dados;
import java.util.List;
import java.util.ArrayList;

public class Viveiro {
    protected String nome;
    protected float comprimento;
    protected float largura;
    private List<Animal> animais = new ArrayList<Animal>();

    public Viveiro(String nome, float comprimento, float largura) {
        this.nome = nome;
        this.comprimento = comprimento;
        this.largura = largura;
    }
    public Viveiro() {}

    public float calculaEspaco() {
        return comprimento * largura;
    }

    private float espacoOcupado() {
        float ocupado = 0;
        for (Animal animal : animais) {
            ocupado += animal.calculaEspacoOcupado();
        }
        return ocupado;
    }

    


}
