package ex2;

public class Circulo extends FormaGeometrica{
    public Circulo(int raio) {
        super(raio, raio * 2);
    }
    public Circulo() {
        super();
    }
    public void setRaio(int valor) {
        this.medida1 = valor;
        this.medida2 = valor * 2;
    }
    public int getRaio() {
        return this.medida1;
    }
    public String toString() {
        return "Circulo: raio = " + this.medida1 + ", diametro = " + this.medida2 + ", area = " + this.calculaArea() + ", perimetro = " + this.calculaPerimetro();
    }
    @Override
    public int calculaArea() {
        return (int) (Math.PI * Math.pow(medida1, 2));
    }
    @Override
    public int calculaPerimetro() {
        return (int) (Math.PI * medida2);
    }
}
