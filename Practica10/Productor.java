package Practica10;

public class Productor implements Runnable{
    private BufferCompartido buffer;
    private String nombre;

    public Productor(BufferCompartido buffer, String nombre) {
        this.buffer = buffer;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                buffer.producir(i, nombre);
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
