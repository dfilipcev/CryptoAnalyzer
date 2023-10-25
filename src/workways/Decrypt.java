package workways;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Set;

import static constants.Alphabets.RU_ALPHABET;
import static converters.SetConverter.convertToSet;
import static filework.Reader.readCharsFromFile;
import static filework.Writer.writeInFile;

public class Decrypt extends Cryptanalysis {

    public static void decrypt() {
        Path inputPath = getFileToInput(new Scanner(System.in));
        Path outputPath = getFileToOutput(new Scanner(System.in));
        int key = getKey(new Scanner(System.in));
        try {
            char[] symbols = readCharsFromFile(inputPath);
            Set<Character> letters = convertToSet(RU_ALPHABET);
            for (int i = 0; i < symbols.length; i++) {
                //Проверяем, содержит ли алфавит символ. Приводим к нижнему регистру, т.к. в тексте могут быть симовлы в верхнем регистре
                char symbol = Character.toLowerCase(symbols[i]);
                if (letters.contains(symbol)) {
                    //Если содержит, начинаем перебор алфавита, чтобы найти идентичную букву в нем
                    for (int j = 0; j < RU_ALPHABET.length; j++) {
                        //Если нашли подходящий символ
                        if (Character.valueOf(symbol).equals(RU_ALPHABET[j])) {
                            //То расчитываем его позицию
                            int position = (j - key + RU_ALPHABET.length) % RU_ALPHABET.length;
                            symbols[i] = RU_ALPHABET[position];
                            break;
                        }
                    }
                }
            }
            writeInFile(symbols, outputPath);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
}
