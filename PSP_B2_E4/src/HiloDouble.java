import lib.LibFrontend;

public class HiloDouble implements Runnable{

    @Override
    public void run() { ;
        double dNumero = LibFrontend.validaNumeroDouble("Introduce un numero: ", 0.1, 100000.0);
        System.out.println(dNumero / 10);

    }
}
