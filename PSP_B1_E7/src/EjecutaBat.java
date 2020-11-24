import java.io.IOException;

public class EjecutaBat {
    public static void main(String[] args) {
        Runtime ejecutar = Runtime.getRuntime();

        try {
            ejecutar.exec("cmd.exe /c > ping ficheros\\EjecutaBat.bat >> ficheros\\SalidaBat.txt 2>> ficheros\\ErrorBat.txt");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
