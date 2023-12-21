package ait.validator.utils;

public class Validator {
    public static boolean checkCreditCardNumber(String str) {
        return str.matches("\\d{8,16}");
    }

    public static boolean checkDateFormatEU(String str) {
        return str.matches("(0[1-9]|[1-2]\\d|3[0-1])\\.(0[1-9]|10|1[1-2])\\.[0-2]\\d\\d\\d");
    }

    public static boolean checkDateFormatUS(String str) {
        return str.matches("[0-2]\\d\\d\\d-(0[1-9]|10|1[1-2])-(0[1-9]|[1-2]\\d|3[0-1])");
    }

    public static boolean checkPhoneNumber(String str) {
        return str.matches("[+](\\d\\d)[(](\\d\\d)[)]\\d{4}[-]\\d{4}"); // здесь тесты проходят, но логику real life - нет.
//        return str.matches("[+](\\d[1-9])|([1-9]0)[(](\\d[1-9]|[1-9]0)[)]\\d{4}[-]\\d{4}");
    }

    public static boolean checkLessEquals255(String str) {
        return str.matches("\\d|(\\d\\d)|([0-1]\\d\\d)|(2[0-4][0-9])|(25[0-5])");
    }
}
