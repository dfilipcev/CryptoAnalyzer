package converters;

public class StringArrayConverter {

    public static String[] convertToStringArray (char[] symbols) {
        String text = String.valueOf(symbols);
        text = text.replaceAll("[^а-яА-Я ]", "");
        return text.trim().split("\\s+");
    }
}
