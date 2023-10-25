package filework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class Reader {
    public static char[] readCharsFromFile(Path inputPath) throws IOException {
        return Files.readAllLines(inputPath).toString()
                .replace("[", "").replace("]", "")
                .toCharArray();
    }

    public static Set<String> readFreqDictionary(Path dictionary) throws IOException {
        return new HashSet<>(Files.readAllLines(dictionary));
    }
}
