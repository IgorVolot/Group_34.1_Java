package ait.homework.task_02.test;

public class ComparatorAppl {
    public static void main(String[] args) {
        String str1 = "1.2.3";
        String str2 = "2.0.1";
        System.out.println(digitsInStringsComparator(str1, str2));
    }

    public static String digitsInStringsComparator(String str1, String str2) {
        String res = "";
        return !getDigits(str1).equals(getDigits(str2)) ? "Числа " + str1 + " и " + str2 + " не равны." : "Числа " + str1 + " и " + str2 + " равны.";
    }

    public static String getDigits(String string) {
        if (string == null) {
            return null;
        } else {
            String res = "";

            for(int i = 0; i < string.length(); ++i) {
                char c = string.charAt(i);
                if (c >= '0' && c <= '9') {
                    res = res + c;
                }
            }

            return res;
        }
    }
}
