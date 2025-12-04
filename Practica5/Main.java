package Practica5;

public class Main {
    public static void main(String[] args) {
        Figura14[] figuras;

        try {
            figuras = new Figura14[3];

            figuras[0] = new CirculoIbarra(2);
            figuras[1] = new RectanguloIbarra(4, 4);
            figuras[2] = new TrianguloIbarra(3.0);

        } catch (IllegalArgumentException e) {
            System.err.println("Error en los datos ingresados: " + e.getMessage());
            return;
        } catch (NullPointerException e) {
            System.err.println("Se intento usar un valor nulo: " + e.getMessage());
            return;
        } catch (Exception e) {
            System.err.println("Ocurrió un error inesperado: " + e.getMessage());
            return;
        }

        if (figuras == null) {
            System.err.println("No se pudo crear el arreglo de figuras.");
            return;
        }

        CalculadoraGeometrica4647.calcularFiguras(figuras);

    }
}
