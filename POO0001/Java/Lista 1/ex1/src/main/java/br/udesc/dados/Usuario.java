package br.udesc.dados;
public class Usuario {
    private String nome;
    private String email;
    private int matricula;
    private static int numeroUsuarios = 0;  //Contador de usuários e gerador de matrícula

    public Usuario() {
        this.matricula = numeroUsuarios++;
    }

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.matricula = numeroUsuarios++;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Usuario) {
            Usuario outro = (Usuario) obj;
            return this.matricula == outro.matricula;
        }
        return false;
    }

    public String toString() {
        return "Usuario: " + nome + ", Email: " + email + ", Matrícula: " + matricula;
    }
}
