package ait.wrapper;

public class Wrappers {
    public static void main(String[] args) {
        int intNumber = 10;
        Integer integerNumber = Integer.valueOf(intNumber);
        String stringNumber = String.valueOf(intNumber);
        Integer parsedInteger = Integer.parseInt(stringNumber);
        char[] chars = new char[]{'H', 'e', 'l', 'l', 'o'};
        String stringValueOfChar = String.valueOf(chars);
        System.out.println(stringValueOfChar);
        String line = "12344 #566+788Max15000.99";
        System.out.println(getDigits(line));
    }

    public static String getDigits(String source) {
        if (source == null) {
            return null;
        } else {
            String res = "";

            for(int i = 0; i < source.length(); ++i) {
                char currentChar = source.charAt(i);
                if (currentChar >= '0' && currentChar <= '9') {
                    res = res + currentChar;
                }
            }

            return res;
        }
    }
}
