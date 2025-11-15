package Practica3;

public class Pruebas {
    public static void main(String[] args) {

        CuentaBancaria1412 cuenta = new CuentaBancaria1412("2342422094647", "Alexis", 1000.0, "Ahorro");

        cuenta.setSaldo(-100);
        System.out.println("Saldo debe ser 1000: " + cuenta.getSaldo());

        // Probar número de cuenta inválido
        cuenta.setNumeroCuenta("123400037263");
        System.out.println("Número de cuenta terminar en 647: " + cuenta.getNumeroCuenta());

        // Probar número de cuenta válido
        cuenta.setNumeroCuenta("123342344647");
        System.out.println("Número de cuenta actualizado: " + cuenta.getNumeroCuenta());

        // Crear cliente
        ClienteIbarra cliente = new ClienteIbarra("Alexis", "Ibarra", 25, "alexis@email.com", cuenta);

        // Verificar que la cuenta se asoció
        System.out.println("Cuenta del cliente: " + cliente.getCuenta().getNumeroCuenta());

        // Cambiar edad del cliente
        cliente.agregarEdad(24);
        System.out.println("Edad del cliente: " + cliente.getEdad());

        // Probar método imprimir
        System.out.println("\nImprimiendo cliente...");
        cliente.imprimir();

        System.out.println("Finalizado");
    }
}
