package ex3;

public abstract class Arquivo {
    private String nome;
    private String extensao;

    public Arquivo(String nome) {
        if (!nomeValido(nome)) {
            throw new IllegalArgumentException("Nome de arquivo inválido: " + nome);
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getExtensao() {
        return extensao;
    }

    private boolean nomeValido(String nome) {
        if (nome == null) return false;
        if (nome.length() < 10 || nome.length() > 256) return false;
        if (nome.contains("\n") || nome.contains("\r")) return false;
        if (nome.contains("[") || nome.contains("]")) return false;
        if (nome.contains("(") || nome.contains(")")) return false;
        if (nome.contains("\"") || nome.contains("'")) return false;
        return true;
    }
}
