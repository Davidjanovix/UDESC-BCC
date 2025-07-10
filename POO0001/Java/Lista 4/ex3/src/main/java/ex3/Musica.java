package ex3;

public class Musica extends Arquivo {
    private String artista;
    private String album;
    private int duracao; // em segundos

    public Musica(String nome, String artista, String album, int duracao) throws NomeInvalidoException {
        super(nome);
        if (artista == null || artista.isEmpty()) {
            throw new NomeInvalidoException("Artista não pode ser nulo ou vazio.");
        }
        if (album == null || album.isEmpty()) {
            throw new NomeInvalidoException("Álbum não pode ser nulo ou vazio.");
        }
        if (duracao <= 0) {
            throw new NomeInvalidoException("Duração deve ser um valor positivo.");
        }
        this.artista = artista;
        this.album = album;
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "nome='" + getNome() + '\'' +
                ", extensao='" + getExtensao() + '\'' +
                ", artista='" + artista + '\'' +
                ", album='" + album + '\'' +
                ", duracao=" + duracao +
                '}';
    }
    
}
