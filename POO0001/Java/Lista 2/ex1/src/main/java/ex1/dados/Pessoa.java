package ex1.dados;

public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private int idade;
    private String cpf;
    private String cidade;

    public Pessoa(String nome, int idade, String cpf, String cidade) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.cidade = cidade;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int compareTo(Pessoa outra) {
        return this.nome.compareToIgnoreCase(outra.nome);
    }

    @Override
    public String toString() {
        return nome + ", " + idade + ", " + cpf + ", " + cidade;
    }
}
