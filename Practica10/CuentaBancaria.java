package Practica10;

public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public synchronized void depositar(double cantidad, String nombreHilo) {
        System.out.println(nombreHilo + "intenta depositar: $" + cantidad);
        double saldoAnterior = saldo;

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        saldo += cantidad;
        System.out.println(nombreHilo + "depositó: $" + cantidad + ", Saldo anterior: $" + saldoAnterior + ", Saldo nuevo: $" + saldo);
    }

    public synchronized boolean retirar(double cantidad, String nombreHilo) {
        System.out.println(nombreHilo + "intenta retirar: $ " + cantidad);

        if (saldo >= cantidad) {
            double saldoAnterior = saldo;

            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            saldo -= cantidad;
            System.out.println(nombreHilo + "retiró: $ " + cantidad + ", Saldo anterior: $ " + saldoAnterior + ", Saldo nuevo: $ " + saldo);
            return true;
        } else {
            System.out.println(nombreHilo + "no pudo retirar: $ " + cantidad + ", Saldo insuficiente: $ " + saldo);
            return false;
        }
    }
}
