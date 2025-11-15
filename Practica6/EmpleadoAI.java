package Practica6;

public abstract class EmpleadoAI {
    protected String nombre;
    protected int edad;
    protected String genero;
    protected double salario;

    public EmpleadoAI(String nombre, int edad, String genero, double salario) {
        if (nombre == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        if (edad < 18) {
            throw new IllegalArgumentException("El empleado debe de ser mayor de edad");
        }
        if (genero == null) {
            throw new IllegalArgumentException("El género no puede ser nulo o vacío");
        }
        if (salario < 0) {
            throw new IllegalArgumentException("El salario no puede ser negativo");
        }
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.salario = salario;
    }

    public abstract void trabajar();

    public void imprimirInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Género: " + genero);
        System.out.println("Salario: " + salario);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario < 0) {
            throw new IllegalArgumentException("El salario no puede ser negativo");
        }
        this.salario = salario;
    }
}
