package ex2;
import ex2.PilhaCheiaException;
import ex2.PilhaVaziaException;
import java.util.List;
import java.util.ArrayList;

public class Pilha {
    private int limite;
    private List<Object> elementos;

    public Pilha(int limite) {
        this.limite = limite;
        this.elementos = new ArrayList<>(limite);
    }
    public void inserir(Object objeto) throws PilhaCheiaException {
        if (elementos.size() >= limite) {
            throw new PilhaCheiaException();
        }
        elementos.add(objeto);
    }
    public Object remover() throws PilhaVaziaException {
        if (elementos.isEmpty()) {
            throw new PilhaVaziaException();
        }
        return elementos.remove(elementos.size() - 1);
    }
    public int getSize() {
        return elementos.size();
    }
}
