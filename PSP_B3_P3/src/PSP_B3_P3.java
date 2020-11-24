import java.util.concurrent.Semaphore;

public class PSP_B3_P3 {

    private final int TABACO = 1;
    private final int PAPEL = 2;
    private final int CERILLA = 3;

    public class Control {

        public Semaphore tabaco = new Semaphore(0);
        public Semaphore cerilla = new Semaphore(0);
        public Semaphore papel = new Semaphore(0);

    }

    Control control = new Control();

    class MArlboro implements Runnable {

        @Override
        public void run() {


            while (true) {
                String resultado = "";

                if (control.tabaco.availablePermits() == 0 && control.papel.availablePermits() == 0 && control.cerilla.availablePermits() == 0) {

                    try {
                        Thread.sleep(100);
                        int num1 = 0;
                        int num2 = 0;

                        while (num1 == num2) {

                            num1 = (int) (1 + Math.random() * 3);
                            num2 = (int) (1 + Math.random() * 3);
                        }

                        if (num1 == TABACO && num2 == CERILLA) {
                            resultado = "TABACO y CERILLA";
                            control.tabaco.release();
                            control.cerilla.release();
                        }
                        if (num1 == TABACO && num2 == PAPEL) {
                            resultado = "TABACO y PAPEL";
                            control.tabaco.release();
                            control.papel.release();
                        }
                        if (num1 == PAPEL && num2 == CERILLA) {
                            resultado = "PAPEL y CERILLA";
                            control.papel.release();
                            control.cerilla.release();
                        }
                        if (num1 == PAPEL && num2 == TABACO) {
                            resultado = "PAPEL y TABACO";
                            control.papel.release();
                            control.tabaco.release();
                        }
                        if (num1 == CERILLA && num2 == PAPEL) {
                            resultado = "CERILLA y PAPEL";
                            control.cerilla.release();
                            control.papel.release();
                        }
                        if (num1 == CERILLA && num2 == TABACO) {
                            resultado = "CERILLA y TABACO";
                            control.cerilla.release();
                            control.tabaco.release();
                        }

                        System.out.println("La mesa se ha rellenado con " + resultado);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }


        }
    }

    class Alumno implements Runnable {

        int id = 0;

        public Alumno(int id) {
            this.id = id;
        }

        @Override
        public void run() {

                try {
                    Thread.sleep(100);

                    int cigarros = 0;
                    int papel = (int) (Math.random() * 5);
                    int tabaco = (int) (Math.random() * 5);
                    int cerilla = (int) (Math.random() * 5);

                     while (cigarros < 10) {

                         if (papel == 0) {
                             if (control.papel.availablePermits() == 0) {
                                 control.papel.acquire();
                                 System.out.println("Cogiendo papel.");
                                 papel++;
                             }
                         }

                         if (tabaco == 0) {
                             if (control.tabaco.availablePermits() == 0) {
                                 control.tabaco.acquire();
                                 System.out.println("Cogiendo tabaco.");
                                 tabaco++;
                             }
                         }

                         if (cerilla == 0) {
                             if (control.cerilla.availablePermits() == 0) {
                                 control.cerilla.acquire();
                                 System.out.println("Cogiendo cerilla.");
                                 cerilla++;
                             }
                         }

                         if (papel > 0 && cerilla > 0 && tabaco > 0) {

                             System.out.println("QUIEN SE LO FUMA? EL PUMA!!");
                             System.out.println("Ya en serio, el alumno se ha fumado el cigarrete");
                             System.out.println("El alumno " + id + " se ha fumado " + cigarros);
                             tabaco--;
                             papel--;
                             cerilla--;
                             cigarros++;
                         }
                     }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    private void executeMultithreading () throws InterruptedException {

        int contador = 0;

        new Thread (new MArlboro()).start();
        while (true) {
            Thread.sleep(300);
            new Thread(new Alumno(contador)).start();
            contador++;
        }

    }

    public static void main(String[] args) throws InterruptedException {

        PSP_B3_P3 p3 = new PSP_B3_P3();
        p3.executeMultithreading();
    }
}
