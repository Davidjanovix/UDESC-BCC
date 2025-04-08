package br.udesc;
import java.util.Random;

public class Sorteador {
    private Random random = new Random();;
    private Pessoa[] pessoas;
    private int numPessoas;

    public Sorteador(Pessoa[] pessoas) {
        this.pessoas = pessoas;
        this.random = new Random();
        numPessoas = pessoas.length;
    }

    public Pessoa sortearProximo() {
        if (numPessoas == 0) {
            return null;
        }
        int index = random.nextInt(numPessoas);
        Pessoa sorteado = pessoas[index];
        for (int i = index; i < numPessoas - 1; i++) {
            pessoas[i] = pessoas[i + 1];
        }
        numPessoas--;
        return sorteado;
    }
}
