    public class task2passw {
        public static void main(String[] args) {
            String password = "password1234";
            try {
                if (validatePassword(password)) {
                    System.out.println("Пароль корректный");
                } else {
                    throw new IllegalArgumentException("Некорректный пароль: должен содержать 8-16 символов, хотя бы одну заглавную букву и одну цифру");
                }
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("Ошибка: "  + e.getMessage());
            }
        }

        public static boolean validatePassword(String password) {
            String pattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{8,16}$";
            return password.matches(pattern);
        }
    }