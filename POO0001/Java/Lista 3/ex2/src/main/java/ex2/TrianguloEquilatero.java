package ex2;

public class TrianguloEquilatero extends FormaGeometrica {
    public TrianguloEquilatero(int lado) {
        super(lado);
    }
    public TrianguloEquilatero() {
        super();
    }
    public void setLado(int valor) {
        this.medida1 = valor;
    }
    public int getLado() {
        return this.medida1;
    }
    public String toString() {
        return "Triangulo Equilatero: lado = " + this.medida1 + ", area = " + this.calculaArea() + ", perimetro = " + this.calculaPerimetro();
    }
    @Override
    public int calculaArea() {
        return (int) ((Math.sqrt(3) / 4) * Math.pow(medida1, 2));
    }

    @Override
    public int calculaPerimetro() {
        return 3 * medida1;
    }
}
