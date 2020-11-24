import lib.JavaProcess;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Proceso {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> jvmArgs = new ArrayList<>();
        List<String> argsM = new ArrayList<>();

        try {
            Process ejecutaBat = JavaProcess.exec(EjecutaBat.class,jvmArgs,argsM);
        } catch (IOException e) {
            System.out.println("Error: " +e);
        }
    }
}
