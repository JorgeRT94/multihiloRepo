import lib.JavaProcess;
import lib.LibFrontend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Principal {

    public static void main(String[] args) {

        List<String> jvmArgs = new ArrayList<>();
        List<String> argsM = new ArrayList<>();

        try {
                    /*aniadimos el valor que devuelve el metodo random a la primera posicion del
        array "argsm" para pasarselo por parametro a la clase hija.*/
            argsM.add(0, String.valueOf(generadorAleatorios()));
            Process p = JavaProcess.exec(GeneradorAleatorios.class, jvmArgs, argsM);

            int repeat = (int) LibFrontend.valida("¿Desea volver a generar numeros aleatorios?\n1 para repetir\n0 para salir.", 0, 1, 1);

            while (repeat == 1) {
                argsM.add(0, String.valueOf(generadorAleatorios()));
                p = JavaProcess.exec(GeneradorAleatorios.class, jvmArgs, argsM);
                repeat = (int) LibFrontend.valida("¿Desea volver a generar numeros aleatorios?\n1 para repetir\n0 para salir.", 0, 1, 1);
            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }

    private static int generadorAleatorios() {
        int min = 0;
        int max = 10;
        Random r1 = new Random();

        int randomPadre = min + r1.nextInt(max - min + 1);

        return randomPadre;

    }
}