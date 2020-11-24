import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcesoCarpeta {
    public static void main(String[] args) {

        Path path = Paths.get(args[0]);
        File directorio = new File(String.valueOf(path));
        List<String> listarDirectorio = new ArrayList<>();
        listarDirectorio = Arrays.asList(directorio.list());
        System.out.println(listarDirectorio);

    }
}
