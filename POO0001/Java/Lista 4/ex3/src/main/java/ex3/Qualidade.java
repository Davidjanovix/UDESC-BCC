package ex3;

public enum Qualidade {
    P240(240),
    P360(360),
    P720(720),
    P1080(1080);

    private int resolucao;

    private Qualidade(int resolucao) {
        this.resolucao = resolucao;
    }

    public int getResolucao() {
        return resolucao;
    }
}