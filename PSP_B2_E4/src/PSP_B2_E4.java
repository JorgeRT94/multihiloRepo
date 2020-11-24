import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PSP_B2_E4 {

    public static void main(String[] args) {

        List<Thread> lisThreads = new ArrayList<Thread>();

        lisThreads.add(new Thread(new HiloCadena()));
        lisThreads.add(new Thread(new HiloEntero()));
        lisThreads.add(new Thread(new HiloDouble()));

        for (int i = 0; i < lisThreads.size(); i++) {
            lisThreads.get(i).start();
            try {
                lisThreads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("--------------------------------------------");
        }

        System.out.println("Programa finalizado.");

    }
}
