import lib.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException {

        List<String> jvmArgs = new ArrayList<>();
        List<String> argsM = new ArrayList<>();

        Process p = JavaProcess.exec(ProcesoHijo.class, jvmArgs, argsM);
        int repeat = (int) LibFrontend.valida("¿Desea volver a repetir el proceso?\n0 Para salir\n1 Para repetir", 0, 1, 1);

        while (repeat == 1) {
            p = JavaProcess.exec(ProcesoHijo.class, jvmArgs, argsM);
            repeat = (int) LibFrontend.valida("¿Desea volver a repetir el proceso?\n0 Para salir\n1 Para repetir", 0, 1, 1);
        }
    }
}
