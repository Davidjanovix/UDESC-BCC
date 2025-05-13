package ex1;

public class Gato extends Animal {
    public Gato(String nome) {
        super(nome);
    }
    public String emitirSom() {
        return super.getNome() + ": Miau!";
    }
}
