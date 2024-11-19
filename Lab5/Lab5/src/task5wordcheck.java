import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class task5wordcheck {
    public static void main(String[] args) {
        String str = "Apple banana apricot orange Avocado blueberry a";
        char letter = 'a';

        try {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("Пустая строка");
            }

            List<String> words = findWordsStartingWith(str, letter);

            if (words.isEmpty()) {
                System.out.println("Слова, начинающиеся с '" + letter + "', не найдены.");
            } else {
                System.out.println("Слова, начинающиеся с '" + letter + "': " + words);
            }
        } catch (NullPointerException e) {
            System.err.println("Пустая строка (null)");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static List<String> findWordsStartingWith(String str, char letter) {
        Pattern p = Pattern.compile("\\b" + Character.toLowerCase(letter) + "\\w*\\b|\\b" + Character.toUpperCase(letter) + "\\w*\\b");
        Matcher m = p.matcher(str);

        List<String> words = new ArrayList<>();
        while (m.find()) {
            words.add(m.group());
        }
        return words;
    }
}