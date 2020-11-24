import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ProcesoArchivo {
    public static void main(String[] args) {
        Path path = Paths.get(args[0]);
        String content = null;

        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            content = String.join(System.lineSeparator(), lines);
        } catch (
                IOException e) {
            System.out.println(e);
        }
        System.out.println(content);
    }
}

