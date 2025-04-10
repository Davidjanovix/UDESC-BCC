package br.udesc.dados;

public class Reserva {
    private int numReserva;
    private String dataVoo;
    private String horaVoo;
    private float preco;
    private String classeVoo;
    private boolean idaEvolta;
    private int poltrona;
    private Reserva volta;
    private Cidade origem;
    private Cidade destino;


    public Reserva(int numReserva, String dataVoo, String horaVoo, float preco, String classeVoo, int poltrona, Cidade origem, Cidade destino) {
        this.numReserva = numReserva;
        this.dataVoo = dataVoo;
        this.horaVoo = horaVoo;
        this.preco = preco;
        this.classeVoo = classeVoo;
        this.poltrona = poltrona;
        this.origem = origem;
        this.destino = destino;
    }

    public Reserva(int numReserva) {
    }

    public String toString() {
        return "Reserva: " + numReserva + " Data: " + dataVoo + 
        " Hora: " + horaVoo + " Preço: " + preco + " Classe: " + classeVoo + 
        " Ida e volta: " + idaEvolta + " Poltrona: " + poltrona;
    }

    public int getNumReserva() {
        return numReserva;
    }

    public String getDataVoo() {
        return dataVoo;
    }

    public String getHoraVoo() {
        return horaVoo;
    }

    public float getPreco() {
        return preco;
    }

    public String getClasseVoo() {
        return classeVoo;
    }

    public boolean isIdaEvolta() {
        return idaEvolta;
    }

    public int getPoltrona() {
        return poltrona;
    }

    public Cidade getOrigem() {
        return origem;
    }

    public Cidade getDestino() {
        return destino;
    }

    public Reserva getVolta() {
        return volta;
    }

    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }

    public void setDataVoo(String dataVoo) {
        this.dataVoo = dataVoo;
    }

    public void setHoraVoo(String horaVoo) {
        this.horaVoo = horaVoo;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setClasseVoo(String classeVoo) {
        this.classeVoo = classeVoo;
    }

    public void setIdaEvolta(boolean idaEvolta) {
        this.idaEvolta = idaEvolta;
    }

    public void setPoltrona(int poltrona) {
        this.poltrona = poltrona;
    }

    public void setOrigem(Cidade origem) {
        this.origem = origem;
    }

    public void setDestino(Cidade destino) {
        this.destino = destino;
    }

    public void setVolta(Reserva volta) {
        this.volta = volta;
    }
}
