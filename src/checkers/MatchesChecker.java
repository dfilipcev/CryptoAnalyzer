package checkers;

import java.util.Set;

import static converters.StringArrayConverter.convertToStringArray;

public class MatchesChecker {

    public static boolean wordIsInFreqDictionary (char[] symbols, Set<String> dictionary) {
        String[] words = convertToStringArray(symbols);
        for (String word : words) {
            if (dictionary.contains(word)) {
                return true;
            }
        }
        return false;
    }
}
