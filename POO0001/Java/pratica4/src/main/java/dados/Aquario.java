package dados;
import java.util.List;
import java.util.ArrayList;

public class Aquario extends Viveiro {
    private float altura;
    private float temperatura;
    private List<Peixe> peixes = new ArrayList<Peixe>();

    public Aquario() {
        super();
    }

    public float getAltura() {
        return altura;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float calculaEspaco() {
        return super.calculaEspaco() * altura;
    }

    public float espacoOcupado() {
        float ocupado = 0;
        for(Peixe peixe : peixes) {
            ocupado += peixe.calculaEspacoOcupado();
        }
        return ocupado;
    }

    public float espacoDisponivel() {
        return calculaEspaco() - espacoOcupado();
    }

}