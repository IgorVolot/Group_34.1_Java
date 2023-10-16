package ait.homework.task_01.test;

import java.util.Scanner;

public class PalindromeAppl {
    public static void main(String[] args) {
        System.out.println("Введите слово для проверки ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();
        System.out.println(palindromeChecker(str));
    }

    public static boolean palindromeChecker(String string) {
        if (!string.equals("")) {
            StringBuilder builder = new StringBuilder();
            String wordBackward = "";

            for(int i = string.length() - 1; i >= 0; --i) {
                builder.append(string.charAt(i));
                wordBackward = builder.toString();
            }

            if (string.contentEquals(wordBackward)) {
                return true;
            }
        }

        return false;
    }
}
