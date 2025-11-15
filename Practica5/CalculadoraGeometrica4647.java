package Practica5;

public class CalculadoraGeometrica4647 {
    public static void calcularFiguras(Figura14[] figuras) {
        if (figuras == null) {
            throw new NullPointerException("El arreglo no puede ser nulo");
        }
        for (Figura14 figura : figuras) {
            figura.imprimirInfo();
            System.out.println("El area es de: " + figura.obtenerArea());
            System.out.println("El perimetro es de: " + figura.obtenerPerimetro());
            System.out.println("*****************************");
        }
    }
}
