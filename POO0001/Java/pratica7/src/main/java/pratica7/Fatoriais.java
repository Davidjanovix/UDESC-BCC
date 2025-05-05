package pratica7;

public class Fatoriais extends Gerador {

    public void gerar(int quantidade) {
        int acumulador = 1;
        for(int i = 1 ; i <= quantidade ; i ++) {
            acumulador *= i;
            sequencia.add(acumulador);
        }
    }
}
