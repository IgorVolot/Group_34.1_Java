package ait.stringbuilder;

public class StringBuilderAppl {
    public static void main(String[] args) {
        System.out.println("======== String ===============");
        String str = new String("Java");
        str = str + "11";
        System.out.println(str);
        System.out.println("======== StringBuilder ===========");
        StringBuilder builder = new StringBuilder("Java");
        builder.append(11);
        System.out.println(builder);
        str = arrayConcatAdvanced(new String[]{"one", "two", "three", "four", "five"});
        System.out.println(str);
    }

    public static String arrayConcat(String[] arr) {
        String res = "";

        for(int i = 0; i < arr.length - 1; ++i) {
            res = res + arr[i] + "->";
        }

        res = res + arr[arr.length - 1];
        return res;
    }

    public static String arrayConcatAdvanced(String[] arr) {
        StringBuilder res = new StringBuilder("");

        for(int i = 0; i < arr.length - 1; ++i) {
            res.append(arr[i]).append("->");
        }

        res.append(arr[arr.length - 1]);
        return res.toString();
    }
}
