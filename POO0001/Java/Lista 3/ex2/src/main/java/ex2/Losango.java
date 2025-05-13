package ex2;

public class Losango extends FormaGeometrica {
    public Losango(int D, int d) {
        super(D, d);
    }
    public Losango() {
        super();
    }
    public void setD(int valor) {
        this.medida1 = valor;
    }
    public void setd(int valor) {
        this.medida2 = valor;
    }
    public int getD() {
        return this.medida1;
    }
    public int getd() {
        return this.medida2;
    }
    public String toString() {
        return "Losango: D = " + this.medida1 + ", d = " + this.medida2 + ", area = " + this.calculaArea() + ", perimetro = " + this.calculaPerimetro();
    }
    @Override
    public int calculaArea() {
        return (int) ((this.medida1 * this.medida2) / 2);
    }
    @Override
    public int calculaPerimetro() {
        return (int) ((Math.sqrt(Math.pow(medida1 / 2, 2) + Math.pow(medida2 / 2, 2))) * 4);
    }
    
}
