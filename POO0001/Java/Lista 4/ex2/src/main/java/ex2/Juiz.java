package ex2;
import ex2.Processo;
import ex2.Pilha;
import ex2.PilhaCheiaException;

public class Juiz {
    private String nome;
    private Pilha processos;
    public Juiz(int limite) {
        processos = new Pilha(limite);
    }
    void adicionarProcesso(Processo processo) throws PilhaCheiaException {
        processos.inserir(processo);
    }
    void setNome(String nome) {
        this.nome = nome;
    }
    String getNome() {
        return nome;
    }
}
