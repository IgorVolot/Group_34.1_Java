package ait.changeling;

public class WordChangeling {
    public static void main(String[] args) {
        String str = "mama mila ramu";
        System.out.println(str);
        System.out.println(changelingWord(str));
    }

    public static String changelingWord(String string) {
        StringBuilder builder = new StringBuilder();

        for(int i = string.length() - 1; i >= 0; --i) {
            builder = builder.append(string.charAt(i));
        }

        return builder.toString();
    }
}
