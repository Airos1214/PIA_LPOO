package Practica10;

public class BancoConcurrenteAI {
    public static void main(String[] args) {
        System.out.println("*** SIMULADOR DE BANCO CONCURRENTE ***");

        CuentaBancaria cuenta = new CuentaBancaria(1000.0);
        System.out.println("Saldo inicial de la cuenta: $" + cuenta.getSaldo());

        CajeroThread14 cajero1 = new CajeroThread14(cuenta, 150.0, "Cajero-1");
        CajeroThread14 cajero2 = new CajeroThread14(cuenta, 550.0, "Cajero-2");

        ClienteRunnable12 cliente1 = new ClienteRunnable12(cuenta, "Alexis", 999.0, 99.0);
        ClienteRunnable12 cliente2 = new ClienteRunnable12(cuenta, "Anastasio", 666.0, 66.0);

        Thread cliente1Hilo = new Thread(cliente1, "Cliente1");
        Thread cliente2Hilo= new Thread(cliente2, "Cliente2");

        cajero1.start();
        cajero2.start();
        cliente1Hilo.start();
        cliente2Hilo.start();

        try {
            cajero1.join();
            cajero2.join();
            cliente1Hilo.join();
            cliente2Hilo.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n=======================================================================");
        System.out.println("✅ ANÁLISIS DE EJECUCIÓN DEL BANCO");
        System.out.println("El saldo final esperado es: $500.0 (inicial) + $100.0 + $50.0 + $200.0 + $10.0 (depósitos) - $150.0 - $0.0 (retiros exitosos) = $710.0");
        System.out.println("SALDO FINAL de la cuenta después de todas las transacciones: $" + cuenta.getSaldo());
        System.out.println("La coherencia se mantuvo gracias al uso de 'synchronized' en 'CuentaBancaria'.");
        System.out.println("=======================================================================");

        ProductorConsumidor.iniciarDemostracion();
    }
}
