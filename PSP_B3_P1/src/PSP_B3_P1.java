import java.util.*;
import java.util.concurrent.Semaphore;

public class PSP_B3_P1 {

    private final int NUM_COCHES = 3;

    public class Control {

        public Semaphore semaphoreCoche = new Semaphore(NUM_COCHES);
        public Semaphore semaphoreVisitante = new Semaphore(0);
        public Queue<Visitante> colaVisitantes = new LinkedList<Visitante>();
        public volatile int idPasajero = 0;

        public int getIdPasajero() {
            return idPasajero;
        }

        public void setIdPasajero(int idPasajero) {
            this.idPasajero = idPasajero;
        }

    }

    Control control = new Control();

    class Visitante implements Runnable {
        private int id = 0;

        public Visitante(int id) {
            this.id = id;
        }

        public void run() {
            while (true) {
                int iTiempo = (int) ((Math.random() * 4) + 1);

                System.out.println("Visitante " + id + " llegando a la cola en " + iTiempo + " segundos");

                try {
                    Thread.sleep(iTiempo * 1000);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                control.colaVisitantes.add(this);
                control.semaphoreVisitante.release();
            }
        }
    }

    class Coche implements Runnable {
        private int id = 0;

        public Coche(int id) {
            this.id = id;
        }

        public void run() {

            while (true) {

                System.out.println(" Coche " + id + " esta listo");
                try {
                    control.semaphoreCoche.acquire();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    control.semaphoreVisitante.acquire();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                int visitanteId = control.colaVisitantes.poll().id;
                System.out.println(" Visitante " + visitanteId + " se monta en el coche " + id);

                System.out.println(" Coche " + id + " haciendo el recorrido");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(" Coche " + id + " ha vuelto con el visitante " + visitanteId);
                control.semaphoreCoche.release();
            }
        }

    }

    private void executeMultiThreading() throws InterruptedException {

        int iContador = 0;
        int contador = 0;
        List<Thread> listCoches = new ArrayList<Thread>();
        List<Thread> listVisitantes = new ArrayList<Thread>();


        for (contador = 0; contador < NUM_COCHES; contador ++) {
            new Thread(new Coche(contador)).start();
        }
        while (true) {
            int randomId = (int) (Math.random() * 15);
            Thread.sleep(100);
            new Thread(new Visitante(randomId)).start();
        }

        /*
        for (iContador = 0; iContador < NUM_VISITANTE; iContador++) {
            System.out.println("Visitante " + iContador + " llegando a la atraccion...");
            listVisitantes.add(new Thread(new Visitante(iContador)));
        }

        for (iContador = 0; iContador < NUM_COCHES; iContador++) {
            listCoches.add(new Thread(new Coche(iContador)));
        }

        for (iContador = 0; iContador < NUM_VISITANTE; iContador++) {
            listVisitantes.get(iContador).start();
        }

        for (iContador = 0; iContador < NUM_COCHES; iContador++) {
            listCoches.get(iContador).start();
        }

        for (iContador = 0; iContador < NUM_VISITANTE; iContador ++) {
            listVisitantes.get(iContador).join();
        }

        for (iContador = 0; iContador < NUM_COCHES; iContador ++) {
            listCoches.get(iContador).join();
        }
        
         */

    }

    public static void main(String[] args) {

        try {
            PSP_B3_P1 p1 = new PSP_B3_P1();
            p1.executeMultiThreading();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}