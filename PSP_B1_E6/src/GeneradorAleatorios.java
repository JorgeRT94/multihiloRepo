import java.util.Random;

public class GeneradorAleatorios {
    public static void main(String[] args) {

        Random r1 = new Random();

        int randomHijo = 0 + r1.nextInt(10 - 0 + 1);
        int randomPadre = Integer.parseInt(args[0]);

        if (randomHijo == randomPadre) {
            System.out.println(randomHijo);
            System.out.println(randomPadre);
            System.out.println("¡Los numeros coinciden!");
        } else {
            System.out.println(randomHijo);
            System.out.println(randomPadre);
            System.out.println("Los numeros no coinciden.");
        }
    }
}
