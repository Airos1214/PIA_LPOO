package Practica10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static void iniciarExecutorService() {
        System.out.println("\n\n==============");
        System.out.println("Pool de Hilos ");
        System.out.println("==================");

        System.out.println("\n--- Demostración 1: Uso de ExecutorService");
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new Tarea("A", 2));
        executor.execute(new Tarea("B", 1));
        executor.execute(new Tarea("C", 3));
        executor.execute(new Tarea("D", 1));

        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nExecutorService finalizado después de todas las tareas.\n");
        System.out.println("---Demostración 2: Uso del ThreadPool Personalizado");

        // Uso del Pool Personalizado
        ThreadPoolIbarra poolPersonalizado = new ThreadPoolIbarra(2);

        try {
            poolPersonalizado.ejecutar(new Tarea("P1", 2));
            poolPersonalizado.ejecutar(new Tarea("P2", 1));
            poolPersonalizado.ejecutar(new Tarea("P3", 3));

            Thread.sleep(6000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        poolPersonalizado.shutdown();
        System.out.println("====================================================");
        System.out.println("\nThreadPoolIbarra apagado.");
        System.out.println("====================================================");
    }
}
