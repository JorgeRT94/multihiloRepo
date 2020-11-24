import java.util.ArrayList;

public class PSP_B2_E1 {

    private static final int NUMHILOS = 5;

    public static void main(String[] args) {

        String separador = "-----------------------------------------------------------------------------";
        int[] valores = new int[NUMHILOS];
        int contador;
        ArrayList<Hilo> listRunnables = new ArrayList<Hilo>();
        ArrayList<Thread> listThreads = new ArrayList<Thread>();


        //Creamos los runnables
        for (contador = 0; contador < NUMHILOS; contador++) {
            listRunnables.add(new Hilo(contador, 0));
            System.out.println("Hilo " + contador + " creado.");
        }

        //Creamos los hilos
        for (contador = 0; contador < NUMHILOS; contador++) {
            listThreads.add(new Thread(listRunnables.get(contador)));
            System.out.println("Hilo " + contador + " creado.");
        }

        //Iniciamos los hilos (ahora los runnables estan dentro de los hilos)
        for (contador = 0; contador < NUMHILOS; contador++) {
            listThreads.get(contador).start();
        }

        System.out.println(separador);

        //Creamos los Joins
        for (contador = 0; contador < NUMHILOS; contador++) {
            try {
                listThreads.get(contador).join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        //Mostramos el contenido del array antes de ser cambiado.
        for (contador = 0; contador < NUMHILOS; contador++) {
            System.out.println("Valor del array en la posicion " + contador + ": " + valores[contador]);
        }

        System.out.println(separador);

        //Recorremos el vector y le asignamos el valor de la variable valor del hilo correspondiente
        for (contador = 0; contador < NUMHILOS; contador++) {
            System.out.println("Cambiando valor de la posicion " + contador + "...");
            valores[contador] = (int) listRunnables.get(contador).getValor();
        }

        System.out.println(separador);

        //Mostramos el array con los valores cambiados
        for (contador = 0; contador < 5; contador++) {
            System.out.println("Valor del array en la posicion " + contador + ": " + valores[contador]);
        }
    }
}
