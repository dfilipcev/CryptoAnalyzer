package converters;

public class StringArrayConverter {

    public static String[] convertToStringArray (char[] symbols) {
        StringBuilder builder = new StringBuilder();
        for (char symbol : symbols) {
            if (Character.isLetter(symbol) || symbol == ' ') {
                builder.append(symbol);
            }
        }
        return builder.toString().trim().split(" ");
    }
}
