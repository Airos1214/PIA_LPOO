package Practica10;

public class ProductorConsumidor {
    public static void main(String [] args) {
        System.out.println("Patron Productor-Consumidor\n");
        BufferCompartido buffer = new BufferCompartido();

        Thread p1 = new Thread(new Productor(buffer, "Productor-Alexis"));
        Thread p2 = new Thread(new Productor(buffer, "Productor-Beto"));

        Thread c1 = new Thread(new Consumidor(buffer, "Consumidor-Alex"));
        Thread c2 = new Thread(new Consumidor(buffer, "Consumidor-Aldo"));

        p1.start();
        p2.start();
        c1.start();
        c2.start();

        try {
            p1.join();
            p2.join();
            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("==================================================================================");
        System.out.println("\nANÁLISIS DE EJECUCIÓN DEL PC");
        System.out.println("El patrón Productor-Consumidor finalizó. El buffer se vació y llenó varias veces.");
        System.out.println("==================================================================================");

        DeadLockDemo.demostrarDeadlock();
    }

    public static void iniciarDemostracion() {
        System.out.println("\n\n=======================================================================");
    }
}
