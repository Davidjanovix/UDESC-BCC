package ex4;

public class Aluno {
    private String nome;
    private int idade;
    private double notas[];

    public Aluno(String nome, int idade, double[] notas) {
        this.nome = nome;
        this.idade = idade;
        this.notas = notas;
    }
    public Aluno() {
        notas = new double[5];
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public double[] getNotas() {
        return notas;
    }
    public void setNotas(double[] notas) {
        this.notas = notas;
    }
    public double calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Idade: ").append(idade).append("\n");
        sb.append("Notas: ");
        for (double nota : notas) {
            sb.append(nota).append(" ");
        }
        sb.append("\nMédia: ").append(calcularMedia()).append("\n");
        return sb.toString();
    }
}
