package filework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Reader {
    public static char[] readFromFile(Path inputPath) throws IOException {
        return Files.readAllLines(inputPath).toString()
                .replace("[", "").replace("]", "")
                .toCharArray();
    }
}
