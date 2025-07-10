package ex3;
import ex3.Qualidade;

public class Video extends Arquivo {
    private Qualidade qualidade;

    public Video(String nome, Qualidade qualidade) throws NomeInvalidoException {
        super(nome);
        if (qualidade == null) {
            throw new NomeInvalidoException("Qualidade do vídeo não pode ser nula.");
        }
        this.qualidade = qualidade;
    }

    public Qualidade getQualidade() {
        return qualidade;
    }

    @Override
    public String toString() {
        return "Video{" +
                "nome='" + getNome() + '\'' +
                ", extensao='" + getExtensao() + '\'' +
                ", qualidade=" + qualidade.getResolucao() +
                '}';
    }
    
}
