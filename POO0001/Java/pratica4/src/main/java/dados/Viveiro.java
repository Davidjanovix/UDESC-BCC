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

    public String getNome() {
        return nome;
    }

    public float getComprimento() {
        return comprimento;
    }

    public float getLargura() {
        return largura;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

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

    public float espacoDisponivel() {
        return calculaEspaco() - espacoOcupado();
    }

    public boolean adicionarAnimal(Animal animal) {
        if(!(animal instanceof Peixe)) {
            if(animal.calculaEspacoOcupado() * 0.7 < espacoDisponivel()) {
                animais.add(animal);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
        
    }
}
