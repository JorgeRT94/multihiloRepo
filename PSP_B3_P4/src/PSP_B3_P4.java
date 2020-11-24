import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class PSP_B3_P4 {

    public final int MAX_ESTUDIANTE = 10;

    public class Control {

        public Semaphore sube = new Semaphore(MAX_ESTUDIANTE);
        public Semaphore baja = new Semaphore(MAX_ESTUDIANTE);

        public int contSubir = 0;
        public int contBajar = 0;

    }

    Control control = new Control();

    class AlumnoSube implements Runnable {

        private int id = 0;

        public AlumnoSube(int id) {
            this.id = id;
        }

        @Override
        public void run() {

            if (control.baja.availablePermits() == MAX_ESTUDIANTE) {

                control.contSubir++;

                try {
                    control.sube.acquire();

                    System.out.println("El alumno " + id + " de la cola de subida va a subir despues de que AURELIO LE TOME LA TEMPERATURA.");
                    System.out.println("Alumno " + id + " no tiene covid, por lo tanto ha subido.");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            if (control.contSubir == 10) {

                System.out.println("Han subido los 10 alumnos.");
                control.contSubir = 0;

                control.sube.release(MAX_ESTUDIANTE);


            }
        }
    }

    class AlumnoBaja implements Runnable {

        int id = 0;

        public AlumnoBaja(int id) {
            this.id = id;
        }

        @Override
        public void run() {

            if (control.sube.availablePermits() == MAX_ESTUDIANTE) {

                control.contBajar++;

                try {
                    control.baja.acquire();

                    System.out.println("El alumno " + id + " de la cola de bajada va a bajar.");
                    System.out.println("Alumno " + id + " ha bajado.");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            if (control.contBajar == MAX_ESTUDIANTE) {

                System.out.println("Han bajado los 10 alumnos.");
                control.contBajar = 0;

                control.baja.release(10);


            }
        }
    }


    private void executeMultithreading() throws InterruptedException {

        int idSube = 0;

        while (true) {

            new Thread(new AlumnoSube(idSube)).start();
            Thread.sleep(300);
            idSube++;
            new Thread(new AlumnoBaja(idSube - 10)).start();
            Thread.sleep(300);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        PSP_B3_P4 p4 = new PSP_B3_P4();
        p4.executeMultithreading();
    }
}
