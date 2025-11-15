package Practica10;

public class ClienteRunnable12 implements Runnable {
    private CuentaBancaria cuenta;
    private String nombre;
    private double deposito;
    private double retiro;

    public ClienteRunnable12(CuentaBancaria cuenta, String nombre, double deposito, double retiro) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.deposito = deposito;
        this.retiro = retiro;
    }

    @Override
    public void run() {
        System.out.println("\n*** Cliente: " + nombre + " ha iniciado sus transacciones. ***\n");
        cuenta.depositar(deposito, nombre);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        cuenta.retirar(retiro, nombre);
        System.out.println("\n*** Cliente: " + nombre + " ha finalizado sus transacciones. ***\n");
    }
}
