package Practica10;

public class CajeroThread14 extends Thread {
    private CuentaBancaria cuenta;
    private double monto;

    public CajeroThread14 (CuentaBancaria cuenta, double monto, String nombre) {
        super(nombre);
        this.cuenta = cuenta;
        this.monto = monto;
    }

    @Override
    public void run() {
        System.out.println(getName() + "ha iniciado su turno.");
        cuenta.depositar(monto, getName());
        System.out.println(getName() + "ha finalizado su acción.");
    }
}
