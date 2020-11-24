import java.lang.reflect.Array;

public class HiloProducto implements Runnable {

    private int[] array1 = {1, 12, 33, 22, 1, 2};
    private int[] array2 = {2, 13, 22, 44, 3, 6};

    private String nombreHilo;

    public HiloProducto(String nombreHilo) {
        this.nombreHilo = nombreHilo;
    }

    public String getNombreHilo() {
        return nombreHilo;
    }

    public void setNombreHilo(String nombreHilo) {
        this.nombreHilo = nombreHilo;
    }

    public void calcularProducto(int[] a1, int[] a2) {
        int resA1 = 0;
        int resA2 = 0;
        int producto = 0;

        for (int i = 0; i < a1.length; i++) {
            resA1 += a1[i];
        }

        for (int i = 0; i < a2.length; i++) {
            resA2 += a2[i];
        }

        producto = resA1 * resA2;

        System.out.println("Resultado: " + producto);
    }

    @Override
    public void run() {
        calcularProducto(array1, array2);
    }

}
