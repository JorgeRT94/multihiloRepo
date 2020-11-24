import lib.LibFrontend;

public class HiloCadena implements  Runnable{

    @Override
    public void run() {
        String cadena = LibFrontend.leer("Escribe algo: ");
        System.out.println(cadena);
    }
}
