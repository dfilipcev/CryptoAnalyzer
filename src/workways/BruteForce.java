package workways;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

import static checkers.MatchesChecker.wordIsInFreqDictionary;
import static constants.Alphabets.RU_ALPHABET;
import static converters.SetConverter.convertToSet;
import static converters.StringArrayConverter.convertToStringArray;
import static filework.Reader.*;
import static filework.Writer.writeInFile;

public class BruteForce extends Cryptanalysis {
    public static void bruteForce() {
        Path inputPath = getFileToInput(new Scanner(System.in));
        Path outputPath = getFileToOutput(new Scanner(System.in));
        Path freqDictionary = getFrequencyDictionary();
        try {
            char[] symbols = readCharsFromFile(inputPath);
            Set<String> dictionary = readFreqDictionary(freqDictionary);
            Set<Character> letters = convertToSet(RU_ALPHABET);

            int key = 1;
            while (key < letters.size()) {
                for (int i = 0; i < symbols.length; i++) {
                    char symbol = Character.toLowerCase(symbols[i]);
                    if (letters.contains(symbol)) {
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
                //Конвертируем чары в массив строк, исключая все символы, кроме букв
                String[] words = convertToStringArray(symbols);
                if (wordIsInFreqDictionary(words, dictionary)) {
                    break;
                } else {
                    key++;
                }
            }
            writeInFile(symbols, outputPath);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
}
