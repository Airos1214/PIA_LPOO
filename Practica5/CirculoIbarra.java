package Practica5;

public class CirculoIbarra extends Figura14{
    private double radio;

    public CirculoIbarra(double radio) {
        super("Circulo");
        if (radio <= 0) {
            throw new IllegalArgumentException("El radio debe ser mayor que 0");
        }
        this.radio = radio;
    }

    public CirculoIbarra() {this(1.0);}
    public CirculoIbarra(String nombre, double radio) {
        super(nombre);
        if (radio <= 0) {
            throw new IllegalArgumentException("El radio debe ser mayor que 0");
        }
        this.radio = radio;
    }

    @Override
    public double obtenerArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double obtenerPerimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public void imprimirInfo() {
        System.out.println("El radio del circulo es de: " + radio);
    }
}