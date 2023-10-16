package ait.user.passwordvalidator;

public class UserAppl {
    public static void main(String[] args) {
        int minLowerCase = 2;
        int minUpperCase = 2;
        int minDigits = 1;
        int minLength = 12;
        String symbolList = "!@#$%^";
        int minSymbolCount = 2;
        PasswordValidator validator1 = new PasswordValidator(minLowerCase, minUpperCase, minDigits, minLength, symbolList, minSymbolCount);
        PasswordValidator validator2 = new PasswordValidator(5, 1, 2, 10, symbolList, 3);
        String password = "MyP@ssword123!";
        boolean isValid1 = validator1.isValid(password);
        validator2.isValid(password);
        validator1.isPasswordValid(password);
        validator2.isPasswordValid(password);
        if (isValid1) {
            System.out.println("Пароль верный.");
        } else {
            System.out.println("Пароль не соответствует требованиям.");
        }

    }
}
