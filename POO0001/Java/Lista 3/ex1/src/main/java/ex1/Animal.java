package ex1;
public abstract class Animal {
    private String nome;
    public abstract String emitirSom();
    public Animal(String nome) {
        this.nome = nome;
    }
    public Animal() {}
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
