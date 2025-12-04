package Practica10;

public class Consumidor implements Runnable {
    private BufferCompartido buffer;
    private String nombre;

    public Consumidor(BufferCompartido buffer, String nombre) {
        this.buffer = buffer;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        int consumir = 0;
        while (consumir < 5) {
            try {
                buffer.consumir(nombre);
                consumir++;
                Thread.sleep((long) (Math.random() * 200));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
