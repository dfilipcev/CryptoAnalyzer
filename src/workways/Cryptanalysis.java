package workways;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static constants.Alphabets.RU_ALPHABET;
import static constants.Phrases.*;

public class Cryptanalysis {
    protected static Path getFileToInput(Scanner scanner) {
        System.out.println(INPUT_FILE);
        Path path = null;
        while (scanner.hasNextLine()) {
            String consoleInput = scanner.nextLine();
            if (EXIT.equalsIgnoreCase(consoleInput)) {
                System.exit(0);
            } else {
                path = Path.of(consoleInput);
                boolean isTxt = FilenameUtils.getExtension(consoleInput).equalsIgnoreCase("txt");
                if (Files.notExists(path)) {
                    System.out.println(NEED_EXISTING_FILE_OR_CORRECT_PATH);
                } else if (!isTxt) {
                    System.out.println(NEED_TXT);
                } else {
                    break;
                }
            }
        }
        return path;
    }

    protected static Path getFileToOutput(Scanner scanner) {
        System.out.println(OUTPUT_FILE);
        Path path = null;
        while (scanner.hasNextLine()) {
            String consoleInput = scanner.nextLine();
            if (EXIT.equalsIgnoreCase(consoleInput)) {
                System.exit(0);
            } else {
                path = Path.of(consoleInput);
                boolean isTxt = FilenameUtils.getExtension(consoleInput).equalsIgnoreCase("txt");
                if (EXIT.equalsIgnoreCase(consoleInput)) {
                    System.exit(0);
                } else if (Files.notExists(path)) {
                    System.out.println(NEED_EXISTING_FILE_OR_CORRECT_PATH);
                } else if (!isTxt) {
                    System.out.println(NEED_TXT);
                } else {
                    break;
                }
            }
        }
        return path;
    }

    protected static int getKey(Scanner scanner) {
        System.out.println(INPUT_KEY);
        int key = 0;
        while (scanner.hasNextLine()) {
            String consoleInput = scanner.nextLine();
            if (EXIT.equalsIgnoreCase(consoleInput)) {
                System.exit(0);
            } else {
                try {
                    key = Integer.parseInt(consoleInput);
                    if (key > RU_ALPHABET.length - 1 || key < 1) {
                        System.out.println(INCORRECT_RADIX);
                    } else {
                        break;
                    }
                } catch (NumberFormatException exception) {
                    System.out.println(INCORRECT_FORMAT);
                }
            }
        }
        return key;
    }
}
