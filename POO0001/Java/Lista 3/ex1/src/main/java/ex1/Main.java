package ex1;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        List<Animal> animais = new ArrayList<>();
        animais.add(new Cachorro("Rex"));
        animais.add(new Cachorro("Bobby"));
        animais.add(new Gato("Mingau"));
        animais.add(new Gato("Tom"));
        animais.add(new Raposa("Raposinha"));
        animais.add(new Raposa("Raposo"));

        for(Animal animal : animais) {
            System.out.println(animal.emitirSom());
        }

    }
}
