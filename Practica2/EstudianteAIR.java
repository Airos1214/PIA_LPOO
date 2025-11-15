package Practica2;

public class EstudianteAIR {
    String nombre;
    int matricula;
    int edad;
    String carrera;
    int semestre;

    public EstudianteAIR() {
        this.nombre = "Alexis Ibarra Rodríguez";
        this.matricula = 2094647;
        this.edad = 19;
        this.carrera = "LCC";
        this.semestre = 5;
    }

    public EstudianteAIR(String nombre, int matricula) {
        if (nombre == null) {
            throw new IllegalArgumentException("El nombre no puede estar nulo");
        }
        if (matricula <= 0) {
            throw new IllegalArgumentException("La matrícula debe ser un número positivo");
        }
        this.nombre = nombre;
        this.matricula = matricula;
        this.edad = 19;
        this.carrera = "LCC";
        this.semestre = 1;
    }

    public EstudianteAIR(int semestre, String carrera) {
        if (semestre <= 0 || semestre > 10) {
            throw new IllegalArgumentException("El semestre debe ser entre 1 y 10");
        }
        if (carrera == null) {
            throw new IllegalArgumentException("La carrera no puede estar nula");
        }
        this.nombre = "Sergio Alejandro Solis Perez";
        this.matricula = 1945854;
        this.edad = 20;
        this.carrera = carrera;
        this.semestre = semestre;
    }

    public void cambiarSemestre(int nuevoSemestre) {
        try {
            if (nuevoSemestre <= 0 || nuevoSemestre > 10) {
                throw new IllegalArgumentException("El semestre debe ser entre 1 y 10");
            }
            semestre = nuevoSemestre;
            System.out.println(nombre + " ahora cursa el semestre " + semestre);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void cambiarCarrera(String nuevaCarrera) {
        try {
            if (nuevaCarrera == null) {
                throw new IllegalArgumentException("La carrera no puede estar nula");
            }
            carrera = nuevaCarrera;
            System.out.println(nombre + " ahora cursa la carrera " + carrera);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void imprimir() {
        try {
            if (nombre == null || carrera == null) {
                throw new NullPointerException("Los datos del estudiante no están completos");
            }
            System.out.println("Nombre: " + nombre + ", Matrícula: " + matricula +
                    ", Edad: " + edad + ", Carrera: " + carrera +
                    ", Semestre: " + semestre);
        } catch (Exception e) {
            System.err.println("Error al imprimir los datos: " + e.getMessage());
        }
    }

    public void mayorEdad() {
        if (edad >= 18) {
            System.out.println(nombre + " es mayor de edad");
        } else {
            System.out.println(nombre + " todavía es menor de edad");
        }
    }

    public void aniosCarrera() {
        try {
            if (semestre <= 0) {
                throw new IllegalArgumentException("El semestre no puede ser menor o igual a 0");
            }
            System.out.println(nombre + " lleva " + (semestre / 2.0f) + " años en la carrera");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
