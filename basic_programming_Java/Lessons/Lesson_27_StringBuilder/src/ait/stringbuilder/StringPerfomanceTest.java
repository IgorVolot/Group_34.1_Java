package ait.stringbuilder;

public class StringPerfomanceTest {
    private static final int MAX_ITERATION = 100000;
    private static final String WORD = "meow";

    public StringPerfomanceTest() {
    }

    public static void main(String[] args) {
        String str = "";
        long t1 = System.currentTimeMillis();

        for(int i = 0; i < 100000; ++i) {
            str = str + "meow";
        }

        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        StringBuilder builder = new StringBuilder("");
        t1 = System.currentTimeMillis();

        for(int i = 0; i < 100000; ++i) {
            builder.append("meow");
        }

        str = builder.toString();
        t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        StringBuffer buffer = new StringBuffer("");
        t1 = System.currentTimeMillis();

        for(int i = 0; i < 100000; ++i) {
            buffer.append("meow");
        }

        str = buffer.toString();
        t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }
}
