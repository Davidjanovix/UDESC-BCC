package pratica6;
import java.util.List;
import java.util.ArrayList;

public abstract class Gerador {
    protected List<Integer> sequencia = new ArrayList<Integer>();
    public void gerar(int quantidade) {}
    public List<Integer> getSequencia() {
        return sequencia;
    }
}
