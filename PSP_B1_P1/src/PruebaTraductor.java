import lib.LibFrontend;

import java.io.IOException;

public class PruebaTraductor {

    public static void main(String[] args) throws InterruptedException, IOException {

        int repeat = 1;
        int duracionPrograma = (int) LibFrontend.valida("¿Durante cuanto tiempo desea ejecutar el programa? (una vez pasado este tiempo, el programa se cerrara)", 1, 100000, 1);
        long inicio = System.currentTimeMillis();
        long fin = inicio + duracionPrograma * 1000;
        String rutaProceso = LibFrontend.leer("Introduce la ruta del navegador: ");

        while (System.currentTimeMillis() < fin && repeat == 1) {

            int duracionProceso = (int) LibFrontend.valida("¿Cuanto tiempo debe esperar el proceso para voler a funcionar? ", 1, 100000, 1) * 1000;
            String idiomaEntrada = LibFrontend.leer("En que idioma desea escribir? (en - es)");
            String idiomaSalida = LibFrontend.leer("A que idioma desea traducir? (en - es)");
            String texto = LibFrontend.leer("Ingrese el texto que desee traducir: ");

            if (System.currentTimeMillis() < fin) {
                traductor(rutaProceso, idiomaEntrada, idiomaSalida, texto, duracionProceso);
                System.out.println("Tiempo restante antes de que se cierre el programa: " + ((System.currentTimeMillis() - fin) / 1000));
                repeat = (int) LibFrontend.valida("¿Desea traducir otra palabra? \n1 - SI \n0 - NO", 0, 1, 1);
            } else {
                System.out.println("Tiempo de ejecucion del programa terminado.");
            }
        }
    }

    private static void traductor(String ruta, String idiomaEntrada, String idiomaSalida, String texto, int duracionSleep) {
        try {
            ProcessBuilder pb = new ProcessBuilder(ruta, "http://translate.google.es/?hl=" + idiomaEntrada + "#auto/" + idiomaSalida + "/" + texto + "");
            Process process = pb.start();
            Thread.sleep(duracionSleep);
        } catch (InterruptedException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("Proceso en espera durante " + duracionSleep / 1000 + " segundos");

    }

}