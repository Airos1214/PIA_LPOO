package Practica10;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolIbarra {
    private BlockingQueue<Runnable> colaDeTareas;
    private WorkerThreadVazquez[] trabajadores;
    private boolean activo = true;

    public ThreadPoolIbarra(int numHilos) {
        colaDeTareas = new LinkedBlockingQueue<>();
        trabajadores = new WorkerThreadVazquez[numHilos];

        for (int i = 0; i < numHilos; i++) {
            trabajadores[i] = new WorkerThreadVazquez(colaDeTareas);
            trabajadores[i].setName("Worker-Vazquez-" + i);
            trabajadores[i].start();
        }
    }

    public void ejecutar(Runnable tarea) throws InterruptedException {
        if (activo) {
            colaDeTareas.put(tarea);
        }
    }

    public void shutdown() {
        activo = false;
        for (WorkerThreadVazquez worker : trabajadores) {
            worker.interrupt();
        }
    }
}

class WorkerThreadVazquez extends Thread {
    private BlockingQueue<Runnable> colaDeTareas;

    public WorkerThreadVazquez(BlockingQueue<Runnable> cola) {
        this.colaDeTareas = cola;
    }

    @Override
    public void run() {
        while (true) {
            try {

                Runnable tarea = colaDeTareas.take();
                System.out.println("[" + getName() + "] Iniciando Tarea...");
                tarea.run();
                System.out.println("[" + getName() + "] Tarea Finalizada.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
