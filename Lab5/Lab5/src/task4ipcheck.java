import java.util.regex.*;

public class task4ipcheck {
    public static void main(String[] args) {
        String ip = "215.215.215.215";
        try {
            if (ip.isEmpty()) {
                throw new IllegalArgumentException("Пустая строка");
            }

            if (isValidIP(ip)) {
                System.out.println("IP корректен");
            } else {
                throw new IllegalArgumentException("IP некорректен, недопустимые значения");
            }
        } catch (NullPointerException e) {
            System.err.println("Пустая строка (null)");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static boolean isValidIP(String ip) {
        String ipPattern = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
        Pattern p = Pattern.compile(ipPattern);
        Matcher m = p.matcher(ip);

        return m.matches();
    }
}