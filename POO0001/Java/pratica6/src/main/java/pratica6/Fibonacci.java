package pratica6;

public class Fibonacci extends Gerador {

    public void gerar(int quantidade) {
        sequencia.add(0);
        sequencia.add(1);
        int n1 = 0, n2 = 1;
        for(int i = 3 ; i <= quantidade ; i ++) {
            int n = n1 + n2;
            sequencia.add(n);
            n1 = n2;
            n2 = n;
        }
    }
}
