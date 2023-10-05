package workways;

import org.apache.commons.io.FilenameUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static constants.Alphabets.RU_ALPHABET;
import static constants.Phrases.*;

public class Encrypt {
    private static Path getFileToInput(Scanner scanner) {
        Path path = null;
        System.out.println(INPUT_FILE);
        while (scanner.hasNextLine()) {
            String consoleInput = scanner.nextLine();
            if (EXIT.equalsIgnoreCase(consoleInput)) {
                System.exit(0);
            } else {
                path = Path.of(consoleInput);
                boolean isTxt = FilenameUtils.getExtension(path.toString()).equalsIgnoreCase("txt");
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

    private static Path getFileToOutput(Scanner scanner) {
        Path path = null;
        System.out.println(OUTPUT_FILE);
        while (scanner.hasNextLine()) {
            String consoleInput = scanner.nextLine();
            if (EXIT.equalsIgnoreCase(consoleInput)) {
                System.exit(0);
            } else {
                path = Path.of(consoleInput);
                boolean isTxt = FilenameUtils.getExtension(path.toString()).equalsIgnoreCase("txt");
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

    private static int getKey(Scanner scanner) {
        System.out.println(INPUT_KEY);
        int key = 0;
        while (scanner.hasNextLine()) {
            String consoleInput = scanner.nextLine();
            if (EXIT.equalsIgnoreCase(consoleInput)) {
                System.exit(0);
            } else {
                try {
                    key = Integer.parseInt(consoleInput);
                    if (key > RU_ALPHABET.size() - 1 || key < 1) {
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

    private static char[] readFromFile(Path inputPath) throws IOException {
        return Files.readAllLines(inputPath).toString()
                .replace("[", "").replace("]", "")
                .toCharArray();
    }

    private static List<Character> toList(Set<Character> alphabet) {
        List<Character> letters = new ArrayList<>(alphabet);
        Collections.sort(letters);
        return letters;
    }

    private static void writeEncryptInFile(char[] chars, Path outputPath) throws IOException {
        try (BufferedWriter bf = Files.newBufferedWriter(outputPath)) {
            bf.write(chars);
        }
    }

    public static void encryption() {
        Path inputPath = getFileToInput(new Scanner(System.in));
        Path outputPath = getFileToOutput(new Scanner(System.in));
        int key = getKey(new Scanner(System.in));
        try {
            char[] symbols = readFromFile(inputPath);
            List<Character> letters = toList(RU_ALPHABET);
            for (int i = 0; i < symbols.length; i++) {
                //Проверяем, содержит ли алфавит символ и берем его индекс
                if (RU_ALPHABET.contains(Character.toLowerCase(symbols[i]))) {
                    int index = letters.indexOf(Character.toLowerCase(symbols[i]));
                    //проверяем, больше ли смещение, чем размера алфавита
                    if (index + key > letters.size() - 1) {
                        symbols[i] = letters.get((index + key) % letters.size());
                    } else {
                        //Если символ в алфавите прописной, то добавляем в массив смещение с прописным символом
                        if (Character.isUpperCase(symbols[i])) {
                            symbols[i] = Character.toUpperCase(letters.get(index + key));
                            //Иначе берем строчный символ
                        } else {
                            symbols[i] = letters.get(index + key);
                        }
                    }
                }
            }
            writeEncryptInFile(symbols, outputPath);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
