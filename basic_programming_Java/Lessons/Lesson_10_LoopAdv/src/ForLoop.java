public class ForLoop {
    public static void main(String[] args) {
//        gagarin();
//        double res = pow(2, 3);
//        System.out.println("Pow = " + res);
//        res = pow(3, 4);
//        System.out.println("Pow = " + res);
//        res = pow(5, 0);
//        System.out.println("Pow = " + res);
        int sum = sumDigits(8315482);
        System.out.println("Sum digits = " + sum);
        sum = sumDigits(123);
        System.out.println("Sum digits = " + sum);
        sum = sumDigits(8);
        System.out.println("Sum digits = " + sum);
    }

    public static void gagarin() {
        for (int counter = 10; counter > 0; counter--) {
            System.out.println(counter);
        }
        System.out.println("GO!");
    }

    public static double pow(double a, int n) {
        double res = 1;
        for (int i = 1; i <= n; i++) {
            res *= a; // res = res * a;
        }
        return res;
    }

    public static int sumDigits(int num) {
        //Scope
        //for(;;) infinity loop
        int res;
        for (res = 0; num != 0; num /= 10) {
            int digit = num % 10;
            res += digit; // res = res + digit;
        }
        return res;
    }
}
