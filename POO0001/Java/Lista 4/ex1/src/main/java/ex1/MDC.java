package ex1;

public class MDC implements IOperacaoInteira {
    public MDC() {
    }
    @Override
    public int executar(int valor1, int valor2) {
        int menor, maior;
        if (valor1 < valor2) {
            menor = valor1;
            maior = valor2;
        } else {
            menor = valor2;
            maior = valor1;
        }
        for(int i = menor; i > 0; i--) {
            if (maior % i == 0 && menor % i == 0) {
                return i;
            }
        }
        return 1;
    }

}
