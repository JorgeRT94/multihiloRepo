
public class HiloBucle implements  Runnable{

    private final int LIMIT = 100;
    private String nombreHilo;

    public HiloBucle(String nombreHilo) {
        this.nombreHilo = nombreHilo;
    }

    public String getNombreHilo() {
        return nombreHilo;
    }

    public void setNombreHilo(String nombreHilo) {
        this.nombreHilo = nombreHilo;
    }

    private void imprimeBucle () {
        for (int i = 0; i < LIMIT; i++) {
            System.out.println(i);
        }
    }

    @Override
    public void run() {
        imprimeBucle();
    }
}
