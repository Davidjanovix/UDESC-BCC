package ex1;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import ex1.*;

public class App 
{
    public static void main( String[] args )
    {
        List<IOperacaoInteira> operacoes = new ArrayList<>();
        operacoes.add(new Soma());
        operacoes.add(new Multiplicacao());
        operacoes.add(new MDC());
        operacoes.add(new Mod());
        Random random = new Random();
        int a = random.nextInt(100);
        int b = random.nextInt(100);
        System.out.println("Gerados: " + a + " e " + b);
        for (IOperacaoInteira operacao : operacoes) {
            int resultado = operacao.executar(a, b);
            System.out.println("Resultado da operação " + operacao.getClass().getSimpleName() + ": " + resultado);
        }
    }
}
