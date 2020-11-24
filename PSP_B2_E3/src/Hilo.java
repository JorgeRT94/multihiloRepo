import java.util.Arrays;
import java.util.Random;

public class Hilo implements  Runnable{
    private final int MAXARRAY = 10;

    private int id;
    private int[] arrayHijo = new int [MAXARRAY];

    public Hilo(int id, int[] arrayHijo) {
        this.arrayHijo = arrayHijo;
        this.id = id;
    }

    public int[] getArrayHijo() {
        return arrayHijo;
    }

    public void setArrayHijo(int[] arrayHijo) {
        this.arrayHijo = arrayHijo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < MAXARRAY; i++) {
            Random random = new Random();
            this.arrayHijo[i] += 1;
        }

    }
}
