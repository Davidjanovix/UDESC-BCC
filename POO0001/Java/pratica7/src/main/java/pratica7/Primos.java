package pratica7;

public class Primos extends Gerador {
    public void gerar(int quantidade) {
        int n = 1, contador = 0;
        while(contador <= quantidade) {
            int divisores = 0;
            for(int i = 1 ; i <= n/2 ; i ++) { //  n/2 é sempre o maior divisor
                if (n % i == 0) {
                    divisores++;
                }
            }
            if (divisores < 2) {
                sequencia.add(n);
                contador++;
            }
            n++;
        }
    }
}
