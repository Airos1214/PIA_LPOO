package Practica5;

public class RectanguloIbarra extends Figura14{
    private double base;
    private double altura;

    public RectanguloIbarra(double base, double altura) {
        super("Rectangulo");
        if(base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("La base y la altura deben ser mayores que 0");
        }
        this.base = base;
        this.altura = altura;
    }

    public RectanguloIbarra() {this(2.0, 3.0);}
    public RectanguloIbarra(double lado) {this(lado, lado);}

    @Override
    public double obtenerArea() {
        return base * altura;
    }

    @Override
    public double obtenerPerimetro() {
        return (base + altura) * 2;
    }

    @Override
    public void imprimirInfo() {
        System.out.println("La base del rectangulo es de: " +
                base + " y la altura es de: " + altura);
    }
}
