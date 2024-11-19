import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        String str = "se7men 123.12. Oleni stoyat 45. Kefir4ik. The price of the product is $-19.99.";
        findNumbers(str);
    }

    public static void findNumbers(String str) {
        try {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("Пустая строка");
            }

            Pattern p = Pattern.compile("-?\\d+(\\.\\d+)?");
            Matcher m = p.matcher(str);

            System.out.println("Найденные числа:");
            boolean found = false;
            while (m.find()) {
                System.out.println(m.group());
                found = true;
            }
            if (!found) {
                System.out.println("Чисел нет");
            }
        } catch (NullPointerException e) {
            System.err.println("Пустая строка (null)");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}