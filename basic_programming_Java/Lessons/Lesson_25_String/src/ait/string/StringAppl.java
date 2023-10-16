package ait.string;

public class StringAppl {
    public static void main(String[] args) {
        String str = "Hello";
        char[] chars = new char[]{' ', 'w', 'o', 'r', 'l', 'd'};
        String str1 = new String(chars);
        System.out.println(str);
        System.out.println(str1);
        str = str + str1;
        System.out.println(str);
        System.out.println(str.length());
        char c = str.charAt(2);
        System.out.println(c);

        for(int i = 0; i < str.length(); ++i) {
            System.out.println(str.charAt(i));
        }

        String str2 = " WORLD";
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
        String str3 = str.toUpperCase();
        System.out.println(str3);
        System.out.println(str);
        str3 = str.toLowerCase();
        System.out.println(str3);
        int index = str.indexOf(108);
        System.out.println(index);
        index = str.lastIndexOf(108);
        System.out.println(index);
        index = str.indexOf(108, 4);
        System.out.println(index);
        index = str.indexOf("lo");
        System.out.println(index);
        index = str.indexOf("lo", 4);
        System.out.println(index);
        System.out.println(str.substring(2));
        System.out.println(str.substring(2, 4));
        System.out.println(str.replace('l', 'L'));
        System.out.println(str.replace("o", "OOO"));
    }
}
