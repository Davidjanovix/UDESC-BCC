package ex2;
import java.util.ArrayList;
import java.util.List;
import ex2.Juiz;
import ex2.ProcessoSemJuizException;
public class SistemaProcessos {
    private List<Juiz> juizes;
    private List<Processo> processos;

    public SistemaProcessos() {
        this.juizes = new ArrayList<>();
        this.processos = new ArrayList<>();
    }

    public void cadastrarJuiz(Juiz juiz) {
        juizes.add(juiz);
    }
    public void cadastrarProcesso(Processo processo) {
        processos.add(processo);
    }
    public void distribuirProcessos() throws ProcessoSemJuizException {
        if (juizes.isEmpty()) {
            throw new ProcessoSemJuizException("Nenhum juiz cadastrado para distribuir os processos.");
        }
        for (Processo processo : processos) {
            boolean distribuido = false;
            for (Juiz juiz : juizes) {
                try {
                    juiz.adicionarProcesso(processo);
                    distribuido = true;
                    break;
                } catch (PilhaCheiaException e) {
                    // Se o juiz estiver cheio, tenta o próximo
                }
            }
            if (!distribuido) {
                throw new ProcessoSemJuizException("Não foi possível distribuir o processo: " + processo);
            }
        }
    }
}
