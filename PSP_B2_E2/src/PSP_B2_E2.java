import java.util.ArrayList;
import java.util.List;

public class PSP_B2_E2 {

    public static void main(String[] args) {

        List<Thread> listThreads = new ArrayList<Thread>();

        HiloBucle hiloBucle = new HiloBucle("Hilo Bucle.");
        HiloProducto hiloProducto = new HiloProducto("Hilo Producto.");
        HiloCadena hiloCadena = new HiloCadena("Hilo Cadena.");

        listThreads.add(0, new Thread(hiloBucle));
        listThreads.add(1, new Thread(hiloProducto));
        listThreads.add(2, new Thread(hiloCadena));

        for (int i = 0; i < listThreads.size(); i++) {
            listThreads.get(i).start();
            try {
                listThreads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nHilo principal terminado.");
    }
}

