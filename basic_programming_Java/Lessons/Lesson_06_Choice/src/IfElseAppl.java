public class IfElseAppl {
    public static void main(String[] args) {
        int height = 185;
        checkHeight(height);
        height = 195;
        checkHeight(height);
        double res = max(0.2, 0.1);
        System.out.println("Max = " + res);
        res = max(3.8, 5.4);
        System.out.println("Max = " + res);
        res = max(-2.3, -3.5);
        System.out.println("Max = " + res);
    }

    public static double max(double a, double b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void checkHeight(int height) {
        System.out.println("Hello");
        if (height > 192) {
            System.out.println("I am very tall");
            System.out.println("Please feed me");
        } else {
            System.out.println("I have ordinary height");
        }
        System.out.println("My height is: " + height + " sm");
        System.out.println("Bye, bye!");
    }
}
