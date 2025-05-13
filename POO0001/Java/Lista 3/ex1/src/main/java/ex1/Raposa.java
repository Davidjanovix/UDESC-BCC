package ex1;

public class Raposa extends Animal {
    public Raposa(String nome) {
        super(nome);
    }
    public String emitirSom() {
        return super.getNome() + ": WHAT DOES THE FOX SAY?!";
    }
}
