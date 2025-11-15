package Practica10;

public class DeadLockDemo {
    private static final Object RECURSO_A = new Object();
    private static final Object RECURSO_B = new Object();

    public static void demostrarDeadlock() {
        System.out.println("\n\n========================");
        System.out.println("Demostración de Deadlock");
        System.out.println("============================");


        Thread hilo1 = new Thread(() -> {
            synchronized (RECURSO_A) {
                System.out.println("Hilo 1: Bloqueó RECURSO_A");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("Hilo 1: Esperando RECURSO_B...");
                synchronized (RECURSO_B) {
                    System.out.println("Hilo 1: Bloqueó RECURSO_B");
                }
            }
        });


        Thread hilo2 = new Thread(() -> {
            synchronized (RECURSO_B) {
                System.out.println("Hilo 2: Bloqueó RECURSO_B");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("Hilo 2: Esperando RECURSO_A...");
                synchronized (RECURSO_A) {
                    System.out.println("Hilo 2: Bloqueó RECURSO_A");
                }
            }
        });

        hilo1.start();
        hilo2.start();

        System.out.println("====================================================================================================");
        System.out.println("\nANÁLISIS DE DEADLOCK");
        System.out.println("La demostración de Deadlock está en curso. Hilo 1 tiene A y espera B. Hilo 2 tiene B y espera A.");
        System.out.println("SOLUCIÓN (ya implementada en el Banco): Establecer un orden de bloqueo de recursos estricto.");
        System.out.println("====================================================================================================");

        ThreadPoolDemo.iniciarExecutorService();
    }
}
