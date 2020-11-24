import java.util.concurrent.Semaphore;

public class PSP_B3_P5 {

    private final int MEETS = 0;
    private final int DISCORD = 1;

    public class Control {

        public Semaphore meets = new Semaphore(0);
        public Semaphore discord = new Semaphore(0);
    }

    Control control = new Control();

    class Aurelio implements Runnable {

        @Override
        public void run() {

            while (true) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (control.meets.getQueueLength() > control.discord.getQueueLength()) {

                    System.out.println("Aurelio ha atendido a un estudiante en Meets.");
                    control.meets.release();
                } else if (control.meets.getQueueLength() == control.discord.getQueueLength()) {

                    int numero = (int) (Math.random() * 1);

                    if (numero == DISCORD) {

                        System.out.println("Aurelio ha atendido a un estudiante por Discord.");
                        control.discord.release();
                    } else {

                        System.out.println("Aurelio ha atendido a un estudiante por Meets.");
                        control.meets.release();
                    }
                } else {

                    System.out.println("Aurelio ha atendido a un estudiante por Discord.");
                    control.discord.release();
                }

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Alumno implements Runnable {

        int id;
        int app;

        public Alumno(int id) {
            this.id = id;
        }

        @Override
        public void run() {

            app = (int) (Math.random() * 2);

            if (app == DISCORD) {

                System.out.println("El alumno va a ser atendido por Discord.");

                try {
                    control.discord.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {

                System.out.println("El alumno va a ser atendido por Meets.");
                try {
                    control.meets.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("El alumno ha sido atendido.");
        }
    }

    private void ExecuteMultithreading() throws InterruptedException {

        int contador = 0;

        while (true) {

            new Thread(new Alumno(contador)).start();
            new Thread(new Aurelio()).start();
            contador++;
            Thread.sleep(4000);
        }

    }

    public static void main(String[] args) throws InterruptedException {

        PSP_B3_P5 p5 = new PSP_B3_P5();
        p5.ExecuteMultithreading();
    }
}
