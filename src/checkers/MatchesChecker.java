package checkers;

import java.util.Set;

public class MatchesChecker {

    public static boolean wordIsInFreqDictionary (String[] words, Set<String> dictionary) {
        for (String word : words) {
            if (dictionary.contains(word)) {
                return true;
            }
        }
        return false;
    }
}
