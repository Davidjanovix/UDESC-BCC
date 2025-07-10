package ex3;
import ex3.NomeInvalidoException;

public class Documento extends Arquivo {
    private String conteudo;

    public Documento(String nome, String conteudo) throws NomeInvalidoException {
        super(nome);
        if (conteudo == null || conteudo.isEmpty()) {
            throw new NomeInvalidoException("Conteúdo do documento não pode ser nulo ou vazio.");
        }
        this.conteudo = conteudo;
    }
    @Override
    public String toString() {
        return "Documento{" +
                "nome='" + getNome() + '\'' +
                ", extensao='" + getExtensao() + '\'' +
                ", conteudo='" + conteudo + '\'' +
                '}';
    }
}
