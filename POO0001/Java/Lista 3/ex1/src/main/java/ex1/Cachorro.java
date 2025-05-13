package ex1;

public class Cachorro extends Animal {
    public Cachorro(String nome) {
        super(nome);
    }
    public String emitirSom() {
        return super.getNome() + ": Au au!";
    }
}
