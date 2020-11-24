import lib.JavaProcess;
import lib.LibFrontend;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Consola {

    public static void main(String[] args) {

        List<String> jvmArgs = new ArrayList<>();
        List<String> argsM = new ArrayList<>();

        try {

            String ruta = LibFrontend.leer("Introduce la ruta del fichero o carpeta que desea lee: ");
            File file = new File(ruta);
            argsM.add(0, ruta);

            if (file.exists() && file.isFile()) {
                Process archivo = JavaProcess.exec(ProcesoArchivo.class, jvmArgs, argsM);
            } else if (file.exists() && file.isDirectory()) {
                Process directorio = JavaProcess.exec(ProcesoCarpeta.class, jvmArgs, argsM);
            } else {
                System.out.println("La ruta introducida no corresponde a ningun fichero o carpeta");
            }

        } catch (IOException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}
