package Practica10;

import java.util.LinkedList;
import java.util.Queue;

public class BufferCompartido {
    private static final int capacidad = 5;
    private Queue<Integer> buffer = new LinkedList<>();

    public synchronized void producir(int valor, String nombreProductor) throws InterruptedException {
        while (buffer.size() == capacidad) {
            System.out.println("Log: Buffer LLENO. " + nombreProductor + " está esperando...");
            wait();
        }

        buffer.offer(valor);
        System.out.println("[P] " + nombreProductor + " produjo: " + valor + ". Tamaño actual: " + buffer.size());
        notifyAll();
    }

    public synchronized int consumir(String nombreConsumidor) throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println("Log: Buffer VACÍO. " + nombreConsumidor + " está esperando...");
            wait();
        }

        int valor = buffer.poll();
        System.out.println("[C] " + nombreConsumidor + " consumió: " + valor + ". Tamaño actual: " + buffer.size());
        notifyAll();
        return valor;
    }

}
