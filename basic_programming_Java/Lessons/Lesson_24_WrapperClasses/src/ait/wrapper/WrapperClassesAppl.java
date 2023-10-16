package ait.wrapper;

public class WrapperClassesAppl {
    public static void main(String[] args) {
        int a = 42;
        Integer b = 20;
        System.out.println(a);
        System.out.println(b);
        b = b - a;
        System.out.println(b);
        System.out.println("-------------------------");
        System.out.println(127);
        System.out.println(32767);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Long.MIN_VALUE);
        System.out.println("==============================");
        String strB = b.toString();
        System.out.println(strB);
        System.out.println(strB instanceof String);
        String strA = Integer.toString(a);
        System.out.println(strA);
        strA = "125";
        int c = Integer.parseInt(strA);
        System.out.println(c);
        c -= 10;
        System.out.println(c);
        strB = "121.5";
        double d = Double.parseDouble(strB);
        System.out.println(d);
        strB = "true";
        boolean check = Boolean.parseBoolean(strB);
        System.out.println(check);
        double res = 0.5;
        if (!Double.isInfinite(res) && !Double.isNaN(res)) {
            System.out.println(res);
        } else {
            System.out.println("Wrong result");
        }

    }
}
