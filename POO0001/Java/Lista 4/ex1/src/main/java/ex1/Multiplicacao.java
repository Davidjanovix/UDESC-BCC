package ex1;

public class Multiplicacao extends Soma {
    public Multiplicacao() {
    }

    @Override
    public int executar(int valor1, int valor2) {
        return valor1 * valor2;
    }
    
}
