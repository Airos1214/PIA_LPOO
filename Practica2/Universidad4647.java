package Practica2;

public class Universidad4647 {
    EstudianteAIR[] listaEstudiantil;
    int cantidad;

    public Universidad4647(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0");
        }
        this.listaEstudiantil = new EstudianteAIR[capacidad];
        this.cantidad = 0;
    }

    public void agregarEstudiantes(EstudianteAIR estudiante) {
        try {
            if (estudiante == null) {
                throw new NullPointerException("El estudiante no puede ser nulo");
            }
            if (cantidad >= listaEstudiantil.length) {
                throw new IllegalStateException("No se pueden agregar más estudiantes, la lista está llena");
            }
            listaEstudiantil[cantidad] = estudiante;
            cantidad++;
            System.out.println("Se ha agregado un estudiante correctamente");
        } catch (NullPointerException | IllegalStateException e) {
            System.err.println("Error al agregar estudiante: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    public EstudianteAIR buscarEstudiantes(int matricula) {
        try {
            if (matricula <= 0) {
                throw new IllegalArgumentException("La matrícula debe ser un número positivo");
            }
            for (int i = 0; i < cantidad; i++) {
                if (listaEstudiantil[i] != null && listaEstudiantil[i].matricula == matricula) {
                    System.out.println("🔍 Estudiante encontrado");
                    return listaEstudiantil[i];
                }
            }
            System.out.println("No se encontró un estudiante con esa matrícula");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
        return null;
    }

    public void mostrarEstudiantes() {
        try {
            if (cantidad == 0) {
                System.out.println("No hay estudiantes registrados");
                return;
            }

            System.out.println("Lista Estudiantil:");
            for (int i = 0; i < cantidad; i++) {
                if (listaEstudiantil[i] != null) {
                    listaEstudiantil[i].imprimir();
                } else {
                    System.out.println("Estudiante vacío en posición " + i);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al mostrar estudiantes: " + e.getMessage());
        }
    }
}
