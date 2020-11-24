import java.util.ArrayList;
import java.util.List;

public class PSP_B2_E3 {
    private static final int NUMHILOS = 5;
    private static final int NUMARRAY = 10;

    public static void main(String[] args) {

        int[] arrayPadre = new int[NUMARRAY];
        int id = 1;
        List<Hilo> listRunnables = new ArrayList<Hilo>();
        List<Thread> listThread = new ArrayList<Thread>();

        //Verificar elementos del array antes de cambiarlo
        for (int i = 0; i < NUMARRAY; i++) {
            System.out.print(arrayPadre[i] + " | ");
        }

        //Creamos los threads y los runnables para ejecutarlos
        for (int i = 0; i < NUMHILOS; i++) {
            listRunnables.add(i, new Hilo(id, arrayPadre));
            id++;
        }

        for (int i = 0; i < NUMHILOS; i++) {
            System.out.println("\n");
            System.out.println("Creando hilo " + listRunnables.get(i).getId() + "...");
            listThread.add(new Thread(listRunnables.get(i)));
            listThread.get(i).start();
        }

        for (int i = 0; i < NUMHILOS; i++) {
            try {
                listThread.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Cambiar valores del array
        for (int i = 0; i < NUMHILOS; i++) {
            arrayPadre[i] = listRunnables.get(i).getArrayHijo()[i];
        }

        System.out.println();

        for (int i = 0; i < NUMARRAY; i++) {
            System.out.print(arrayPadre[i] + " | ");
        }

    }
}
