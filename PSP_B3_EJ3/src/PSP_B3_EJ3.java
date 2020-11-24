import java.util.concurrent.Semaphore;

public class PSP_B3_EJ3 {

    public class Control {

        public double k = 3, n = 5, x, y;
        public Semaphore semaphore = new Semaphore(0);

        public double getK() {
            return k;
        }

        public void setK(double k) {
            this.k = k;
        }

        public double getN() {
            return n;
        }

        public void setN(double n) {
            this.n = n;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public Semaphore getSemaphore() {
            return semaphore;
        }

        public void setSemaphore(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        public double factorial (double numero) {

            if (numero == 0 || numero == 1) {
                return 1;
            } else {
                return numero * factorial(numero - 1);
            }
        }
    }

    Control control = new Control ();

    class p1 implements Runnable {

        @Override
        public void run() {

            control.x = control.factorial(control.n);
            control.semaphore.release();

            //semaforo en 0 y se libera el semaforo para que el otro hilo tome la posicion;
        }
    }

    class p2 implements Runnable {

        @Override
        public void run() {

            try {
                control.semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            control.y = control.factorial(control.k) * control.factorial(control.n - control.k);
            System.out.println("El resultado es: " + control.x / control.y);
        }
    }

    private void executeMultiThreading () {

        new Thread(new p2()).start();
        new Thread(new p1()).start();
    }

    public static void main(String[] args) {

        PSP_B3_EJ3 ej3 = new PSP_B3_EJ3();
        ej3.executeMultiThreading();
    }
}
