import lib.*;

import java.util.Scanner;

public class HiloCadena implements Runnable {

    private String nombreHilo;

    public HiloCadena(String nombreHilo) {
        this.nombreHilo = nombreHilo;
    }

    public String getNombreHilo() {
        return nombreHilo;
    }

    public void setNombreHilo(String nombreHilo) {
        this.nombreHilo = nombreHilo;
    }

    private void imprimeCadena () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe algo: ");
        String cadena = scanner.next();
        System.out.println(cadena);
    }

    @Override
    public void run() {
        imprimeCadena();
    }
}
