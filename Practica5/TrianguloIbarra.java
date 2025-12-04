package Practica5;

public class TrianguloIbarra extends Figura14{
    private double lado;

    public TrianguloIbarra(double lado) {
        super("Triangulo");
        if(lado <= 0) {
            throw new IllegalArgumentException("El lado debe ser mayor que 0");
        }
        this.lado = lado;
    }

    public TrianguloIbarra() {
        this(3.0);
    }

    @Override
    public double obtenerArea(){
        return (Math.sqrt(3) / 4) * lado * lado;
    }

    @Override
    public double obtenerPerimetro() {
        return lado * 3;  // Nota: debe ser un triangulo equilatero
    }

    @Override
    public void imprimirInfo() {
        System.out.println("El lado del triangulo equilatero es igual a: " + String.format("%.2f", lado));
    }
}
