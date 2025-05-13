package ex2;
import java.util.ArrayList;
import java.util.List;

public class Main 
{
    public static void main( String[] args )
    {
        List<FormaGeometrica> formas = new ArrayList<>();
        formas.add(new Circulo(5));
        formas.add(new Circulo(10));
        formas.add(new Losango(4, 5));
        formas.add(new Losango(2, 3));
        formas.add(new TrianguloEquilatero(5));
        formas.add(new TrianguloEquilatero(7));
        for(FormaGeometrica forma : formas) {
            System.out.println(forma);
        }
    }
}
