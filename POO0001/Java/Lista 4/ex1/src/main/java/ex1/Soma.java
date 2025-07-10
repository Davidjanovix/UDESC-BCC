package ex1;

public class Soma implements IOperacaoInteira {
    public Soma() {
    }
    @Override
    public int executar(int valor1, int valor2) {
        return valor1 + valor2;
    }
    
}
