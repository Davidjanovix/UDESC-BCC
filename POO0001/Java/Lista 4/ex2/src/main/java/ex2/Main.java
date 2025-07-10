package ex2;
import ex2.*;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        SistemaProcessos sistema = new SistemaProcessos();
        Juiz juiz1[] = new Juiz[3];
        juiz1[0] = new Juiz(5);
        juiz1[0].setNome("Juiz 1");
        juiz1[1] = new Juiz(5);
        juiz1[1].setNome("Juiz 2");
        juiz1[2] = new Juiz(5);
        juiz1[2].setNome("Juiz 3");
        Processo processos[] = new Processo[18];
        for (int i = 0; i < processos.length; i++) {
            processos[i] = new Processo(i, "Processo " + (i + 1));
        }
        for (Processo processo : processos) {
                sistema.cadastrarProcesso(processo);
        }
        for (Juiz juiz : juiz1) {
            sistema.cadastrarJuiz(juiz);
        }
        try {
            sistema.distribuirProcessos();
        } catch (ProcessoSemJuizException e) {
            System.out.println(e.getMessage());
        }
    }
}
