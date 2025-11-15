package Practica2;

public class Main {
    public static void main(String[] args) {
        try {
            EstudianteAIR estudiante1 = new EstudianteAIR();
            EstudianteAIR estudiante2 = new EstudianteAIR("Isabella Villareal", 2057484);
            EstudianteAIR estudiante3 = new EstudianteAIR(3, "LMAD");
            EstudianteAIR estudiante4 = new EstudianteAIR(3, "LA");
            EstudianteAIR estudiante5 = new EstudianteAIR("Rafael", 3849182);

            if (estudiante1 == null || estudiante2 == null || estudiante3 == null ||
                    estudiante4 == null || estudiante5 == null) {
                throw new NullPointerException("Uno o más objetos Estudiante no se crearon correctamente");
            }

            estudiante1.imprimir();
            estudiante2.imprimir();
            estudiante3.imprimir();
            estudiante4.imprimir();
            estudiante5.imprimir();

            estudiante1.aniosCarrera();
            estudiante2.cambiarCarrera("LA");
            estudiante3.mayorEdad();
            estudiante4.cambiarSemestre(4);
            estudiante5.aniosCarrera();
        } catch (NullPointerException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}