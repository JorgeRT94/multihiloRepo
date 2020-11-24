package principal;

import lib.*;
import java.io.IOException;

public class NavegadorWeb {

    public static void main(String[] args) throws InterruptedException, IOException {

        String sRutaProceso = LibFrontend.leer("Introduce la ruta del navegador: ");
        String sUrl = LibFrontend.leer("¿Que pagina web desea visitar?");
        ProcessBuilder pb = new ProcessBuilder(sRutaProceso, "https://www." + sUrl + ".com");
        int iReturn = 0;
        Process process = pb.start();

        try {

            iReturn = process.waitFor();
            System.out.println("La ejecucion de " + sRutaProceso + " devuelve " + iReturn);

        } catch (InterruptedException ex) {
            System.out.println("ERROR IE: " + ex.getMessage());
            System.exit(-1);
        }

        while (iReturn == 0) {
            Thread.sleep(10000);
            sUrl = LibFrontend.leer("¿Que pagina web desea visitar?");
            pb = new ProcessBuilder(sRutaProceso, "https://www." + sUrl + ".com");
            process = pb.start();
            iReturn = process.waitFor();
            System.out.println("La ejecucion de " + sRutaProceso + " devuelve " + iReturn);
        }
    }
}