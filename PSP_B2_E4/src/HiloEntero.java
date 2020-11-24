import lib.LibFrontend;

public class HiloEntero implements Runnable{

    @Override
    public void run() {
        int entero = (int) LibFrontend.valida("Introduce un numero: ", 1, 10000, 1);
        System.out.println(entero + 10);
    }
}
