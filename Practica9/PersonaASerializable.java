package Practica9;

import java.io.Serializable;

public class PersonaASerializable implements Serializable {
    private static final long serialVersionUID = 1L;
    public String nombre;
    public String apellido;
    public int edad;
    public String id;

    public PersonaASerializable(String nombre, String apellido, int edad, String id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + "]";
    }
}
