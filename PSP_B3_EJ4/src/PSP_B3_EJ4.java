import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class PSP_B3_EJ4 {

    public final int SILLAS = 5;

    public class Control {


        public Semaphore semaphoreSilla = new Semaphore(SILLAS);
        public Semaphore semaphoreDentista = new Semaphore(0);
        public Semaphore semaphorePacientes = new Semaphore(0);
        public Queue<Paciente> colaPacientes = new LinkedList<Paciente>();
    }

    Control control = new Control();

    class Paciente implements Runnable {
        private int id;

        public Paciente(int id) {
            this.id = id;
        }

        @Override
        public void run() {

            System.out.println("Paciente " + id + " entra en la sala de espera ");

            if (control.colaPacientes.size() > SILLAS) {
                System.out.println("No hay sillas libres. El paciente " + id + " se va.");
            } else {
                try {
                    control.semaphoreSilla.acquire();
                    System.out.println("El paciente " + id + " se sienta.");
                    control.semaphoreDentista.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                control.colaPacientes.add(this);
                control.semaphorePacientes.release();
            }

        }
    }

    class Dentista implements Runnable {


        @Override
        public void run() {

            System.out.println("Dentista disponible.");

            while (true) {

                if (control.colaPacientes.size() == 0) {
                    try {
                        control.semaphoreDentista.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {

                    int pacienteLibre = control.colaPacientes.poll().id;
                    Thread.interrupted();
                    System.out.println("El paciente " + pacienteLibre + " ha llamado al dentista.");
                    control.semaphoreSilla.release();
                    try {
                        control.semaphoreSilla.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("El paciente " + pacienteLibre + " esta siendo atendida.");

                    int dormir = (int) (Math.random() * 10);
                    try {
                        Thread.sleep(dormir * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("El paciente: " + pacienteLibre + " se ha ido. El dentista esta libre.");

                }
            }
        }
    }

    private void executeMultiThreading() throws InterruptedException {

        int paciente = 0;

        new Thread(new Dentista()).start();

        while (true) {

            Thread.sleep(2000);
            new Thread(new Paciente(paciente)).start();
            paciente++;
        }

    }

    public static void main(String[] args) {

        PSP_B3_EJ4 ej4 = new PSP_B3_EJ4();
        try {
            ej4.executeMultiThreading();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

