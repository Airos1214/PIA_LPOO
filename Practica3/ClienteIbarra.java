package Practica3;

public class ClienteIbarra {
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String correo;
    private final CuentaBancaria1412 cuenta;

    public ClienteIbarra(String nombre, String apellido, int edad, String correo, CuentaBancaria1412 cuenta) {
        try {
            if (nombre == null) {
                throw new IllegalArgumentException("El nombre no puede estar nulo");
            }
            if (apellido == null) {
                throw new IllegalArgumentException("El apellido no puede estar vacío");
            }
            if (edad < 18) {
                throw new IllegalArgumentException("El cliente debe ser mayor de edad");
            }
            if (correo == null || !correo.contains("@")) {
                throw new IllegalArgumentException("El correo no es válido");
            }
            if (cuenta == null) {
                throw new NullPointerException("La cuenta no puede ser nula");
            }

            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
            this.correo = correo;
            this.cuenta = cuenta;

        } catch (IllegalArgumentException | NullPointerException e) {
            System.err.println("Error al crear cliente: " + e.getMessage());
            throw e;
        }
    }

    public void imprimir() {
        try {
            System.out.println("Nombre: " + nombre + " " + apellido);
            System.out.println("Edad: " + edad);
            System.out.println("Correo: " + correo);
            System.out.println("\nSu cuenta es...\n" + cuenta.toString());
        } catch (Exception e) {
            System.err.println("Error al imprimir los datos del cliente: " + e.getMessage());
        }
    }

    protected void agregarEdad(int nuevaEdad) {
        try {
            if (nuevaEdad < 18) {
                throw new IllegalArgumentException("La edad debe ser mayor o igual a 18");
            }
            this.edad = nuevaEdad;
        } catch (IllegalArgumentException e) {
            System.err.println("Error al actualizar edad: " + e.getMessage());
        }
    }

    public CuentaBancaria1412 getCuenta() {
        return cuenta;
    }

    public int getEdad() {
        return edad;
    }
}
