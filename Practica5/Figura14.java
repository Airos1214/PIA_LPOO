package Practica5;

public abstract class Figura14 implements CalculableA {
    protected String nombre;

    public Figura14(String nombre) {
        if (nombre == null) {
            throw new NullPointerException("Se debe asignar un nombre");
        }

        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void imprimirInfo();
}