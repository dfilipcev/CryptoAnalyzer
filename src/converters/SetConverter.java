package converters;

import java.util.HashSet;
import java.util.Set;

public class SetConverter {
    public static Set<Character> convertToSet(char[] symbols) {
        Set<Character> letters = new HashSet<>(symbols.length);
        for (Character character : symbols) {
            letters.add(character);
        }
        return letters;
    }
}
