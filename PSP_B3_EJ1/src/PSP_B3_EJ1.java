import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class PSP_B3_EJ1 {

    public class Control {

        byte platos = 5;
        public Semaphore semaphoreComensales = new Semaphore(0);
        public Semaphore semaphorePlatos = new Semaphore(platos);
        public Queue<Comensal> colaComensales = new LinkedList<Comensal>();


    }

    Control control = new Control();

    class Comensal implements Runnable {
        private int id = 0;

        public Comensal(int id) {
            this.id = id;
        }

        @Override
        public void run() {

            int tiempo = (int) ((Math.random() * 10));

            System.out.println("Comensal " + id + "  llega a la mesa en "+ tiempo + " segundos.");
            try {
                Thread.sleep(tiempo * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            control.colaComensales.add(this);
            control.semaphoreComensales.release();

        }
    }

    class Plato implements Runnable {

        private int id = 0;

        public Plato(int id) {
            this.id = id;
        }

        @Override
        public void run() {

            while (true) {
                System.out.println("Plato " + id + " servido.");
                try {
                    control.semaphorePlatos.acquire();
                    control.semaphoreComensales.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int comensalId = control.colaComensales.poll().id;
                System.out.println("Comensal " + comensalId + "comiendose el plato " + id);

                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Plato " + id + " retirado.");
                System.out.println("Comensal " + comensalId + " ha terminado.");
                control.semaphoreComensales.release();
            }

        }
    }

    private void executeMultiThreading() throws InterruptedException {

        int contador = 0;

        for (int i = 0; i < control.platos; i++) {
            new Thread(new Plato(i)).start();
        }
        while (true) {
            Thread.sleep(500);
            new Thread(new Comensal(contador)).start();
            contador ++;
        }
    }

    public static void main(String[] args) {

        try {
            PSP_B3_EJ1 ej1 = new PSP_B3_EJ1();
            ej1.executeMultiThreading();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
