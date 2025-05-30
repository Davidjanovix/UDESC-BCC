package pratica7;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public abstract class Gerador implements ISequencia{
    protected List<Integer> sequencia = new ArrayList<Integer>();
    public void gerar(int quantidade) {}
    public List<Integer> getSequencia() {
        return sequencia;
    }
    public int sortear() {
        Random random = new Random();
        return sequencia.get(random.nextInt(sequencia.size()));
    }
    public long somatorio() {
        long soma = 0;
        for(Integer i : sequencia) {
            soma += i;
        }
        return soma;
    }
    public double mediaAritmetica() {
        return somatorio() / sequencia.size();
    }
    public double mediaGeometrica() {
        double produtorio = 1.0;
        for(Integer i : sequencia) {
            produtorio *= (double) i;
        }
        return Math.pow(produtorio, 1.0 / (double) sequencia.size());
    }
    public double variancia() {
        double somatorio = 0;
        double media = mediaAritmetica();
        for(Integer i : sequencia) {
            somatorio += Math.pow(i - media, 2);
        }
        return somatorio / (double) (sequencia.size() - 1);
    }
    public double desvioPadrao() {
        return Math.sqrt(variancia());
    }
    public long amplitude() {
        int maior = sequencia.get(0), menor = sequencia.get(0);
        for(Integer i : sequencia) {
            if (maior < i)
                maior =  i;
            if (menor > i)
                menor = i;
        }
        return maior - menor;
    }
}
