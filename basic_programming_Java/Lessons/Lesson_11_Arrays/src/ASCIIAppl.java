public class ASCIIAppl {
    public static void main(String[] args) {
        char c = 65;
        System.out.println(c);
        c = 'b';
        System.out.println(c);
        c++;
        System.out.println(c);
        c = 27;
        System.out.println(c);
        System.out.println("=============");
        for (char i = 128; i < 512; i++) {
            System.out.println(i);
        }
    }
}
