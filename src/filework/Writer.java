package filework;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Writer {
    public static void writeInFile(char[] symbols, Path outputPath) throws IOException {
        try (BufferedWriter bf = Files.newBufferedWriter(outputPath)) {
            bf.write(symbols);
        }
    }
}
