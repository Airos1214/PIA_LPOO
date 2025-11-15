package Practica1;

import java.time.LocalDate;

public class HolaMundoAIR {

    public static void main(String[] args) {
        try {
            String nombre = "Alexis Ibarra Rodriguez";
            int matricula = 2094647;

            LocalDate fecha = LocalDate.now();

            if (nombre == null) {
                throw new IllegalArgumentException("El nombre no puede estar vacío");
            }

            if (matricula <= 0) {
                throw new IllegalArgumentException("La matricula debe ser un número positivo");
            }

            if (fecha == null) {
                throw new NullPointerException("No se pudo obtener la fecha actual");
            }

            System.out.println("--- Datos Validados Correctamente ---");
            System.out.println("Nombre completo: " + nombre);
            System.out.println("Matrícula: " + matricula);
            System.out.println("Fecha actual: " + fecha);

        } catch (IllegalArgumentException e) {
            System.err.println("Error en los datos (IllegalArgument): " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Se ha producido un error inesperado: " + e.getMessage());
        }
    }
}
