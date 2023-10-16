public class WhileLoopAppl {
    public static void main(String[] args) {
//        gagarin();
//        printOdd(12, 37);
//        double res = pow(2, 7);
//        System.out.println("Pow = " + res);
//        res = pow(3, 4);
//        System.out.println("Pow = " + res);
//        res = pow(8, 0);
//        System.out.println("Pow = " + res);
//        int sum = sumDigits(8315482);
//        System.out.println("Sum digits = " + sum);
//        sum = sumDigits(123);
//        System.out.println("Sum digits = " + sum);
//        sum = sumDigits(8);
//        System.out.println("Sum digits = " + sum);
        int count = countDigits(8315482);
        System.out.println("Count digits = " + count);
        count = countDigits(123);
        System.out.println("Count digits = " + count);
        count = countDigits(8);
        System.out.println("Count digits = " + count);
        count = countDigits(0); //FIXME Homework 1
        System.out.println("Count digits = " + count);
        luckyNumber(1738649);//1 + 3 + 6 + 9 == 7 + 8 + 4 -> lucky
        luckyNumber(173854);//1 + 3 + 5 != 7 + 8 + 4 -> unlucky

    }

    public static void gagarin() {
        int counter = 10;
        while (counter > 0) {
            System.out.println(counter);
            counter--; //counter = counter - 1;
        }
        System.out.println("GO!");
    }

    public static void printOdd(int start, int finish) {//Even, Odd
        int i = start;
        while (i <= finish) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
            i++;
        }
    }

    public static double pow(double a, int n) {
        double res = 1;
        int i = 1;
        while (i <= n) {
            res = res * a;
            i++;
        }
        return res;
    }

    public static int sumDigits(int num) {
        int res = 0;
        while (num != 0) {
            int digit = num % 10;
            num = num / 10;
            res = res + digit;
        }
        return res;
    }

    public static int countDigits(int num) {
        int res = 0;
        while (num != 0) {
            num = num / 10;
            res++;
        }
        return res;
    }

    public static void luckyNumber(int num){
        //TODO Homework 2
    }
}
