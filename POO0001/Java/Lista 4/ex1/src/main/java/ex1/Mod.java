package ex1;

public class Mod implements IOperacaoInteira {
    public Mod() {
    }
    @Override
    public int executar(int valor1, int valor2) {
        if (valor2 == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida.");
        }
        return valor1 % valor2;
    }
}
