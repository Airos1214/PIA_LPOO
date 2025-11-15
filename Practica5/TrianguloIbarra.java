package Practica5;

public class TrianguloIbarra extends Figura14{
    private double base;
    private double altura;

    public TrianguloIbarra(double base, double altura) {
        super("Triangulo");
        if(base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("La base y la altura deben ser mayores que 0");
        }
        this.base = base;
        this.altura = altura;
    }

    public TrianguloIbarra() {this(1.0, 2.0);}
    public TrianguloIbarra(double lado) {this(lado, lado);}

    @Override
    public double obtenerArea(){
        return (base * altura) / 2;
    }

    @Override
    public double obtenerPerimetro() {
        return base * 3;  // Nota: debe ser un triangulo equilatero
    }

    @Override
    public void imprimirInfo() {
        System.out.println("La base del triangulo es de: " + base
        + " y la altura es de: " + altura);
    }
}
