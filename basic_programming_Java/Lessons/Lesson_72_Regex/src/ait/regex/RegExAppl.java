package ait.regex;

public class RegExAppl {
    public static void main(String[] args) {
        String str = "Java53";
        String pattern = " *(J|j)ava([1-9]|[1-4]\\d|5[0-5])?";
        boolean check = str.matches(pattern);
        System.out.println(check);
        System.out.println("\\\\");

        System.out.println("----------------------------------------");

        String domain = "abra-kadabra.com"; // .com, .org, .de, .il
        pattern = "\\w+-?\\w+\\.(com|org|de|il)";
//        pattern = "\\w+-?\\w+[.](com|org|de|il)"; // the same
        check = domain.matches(pattern);
        System.out.println(check);

        System.out.println("========================================");

        /*
            1) @ exists and only one (done)
            2) dot after @ (done)
            3) 2 or more symbols after last dot (done)
            4) alphabetic, digits, '_', '-', '.', '@'  (done)
         */
        String email = "peter@gmail.com";
        pattern = "(\\w|-|\\.)+@[A-Za-z0-9](\\w|-|\\.)*\\.[A-Za-z]{2,6}";
        check = email.matches(pattern);
        System.out.println(check);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++");

        String text = "Java\n, RegEx ,Javascript,Typescript\t,   HTML, CSS   ,    SQL";
        String[] data = text.split("\\s*,\\s*");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }

    }
}
