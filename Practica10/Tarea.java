package Practica10;

class Tarea implements Runnable {
    private String nombre;
    private long duracion;

    public Tarea(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    @Override
    public void run() {
        System.out.println("  [Tarea " + nombre + "]: Ejecutándose. Duración: " + duracion + "s.");
        try {
            Thread.sleep(duracion * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("  [Tarea " + nombre + "]: Interrumpida.");
        }
        System.out.println("  [Tarea " + nombre + "]: COMPLETADA.");
    }
}


