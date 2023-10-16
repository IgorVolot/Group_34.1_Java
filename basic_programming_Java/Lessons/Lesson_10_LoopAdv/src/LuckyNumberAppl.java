public class LuckyNumberAppl {
    public static void main(String[] args) {
        int count = countDigits1(8315482);
        System.out.println("Count digits = " + count);
        count = countDigits1(123);
        System.out.println("Count digits = " + count);
        count = countDigits1(8);
        System.out.println("Count digits = " + count);
        count = countDigits1(0); //FIXME Homework 1
        System.out.println("Count digits = " + count);
        luckyNumber2(1738649);//1 + 3 + 6 + 9 == 7 + 8 + 4 -> lucky
        luckyNumber2(173854);//1 + 3 + 5 != 7 + 8 + 4 -> unlucky

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
        return res != 0 ? res : 1;
    }

    public static int countDigits1(int num) {
        int res = 0;
        do {
            num = num / 10;
            res++;
        } while (num != 0);
        return res;
    }

    public static void luckyNumber(int num) {
        int res1 = 0;
        int res2 = 0;
        int pos = 1;
        while (num != 0) {
            int digit = num % 10;
            num = num / 10;
            if (pos % 2 == 0) {
                res1 += digit; // res1 = res1 + digit;
            } else {
                res2 += digit; // res2 = res2 + digit;
            }
            pos++;// pos = pos + 1;
        }
        if (res1 == res2) {
            System.out.println("Lucky");
        } else {
            System.out.println("Unlucky");
        }
    }

    public static void luckyNumber1(int num) {
        int res1 = 0;
        int res2 = 0;
        while (num != 0) {
            int digit = num % 10;
            num = num / 10;
            res1 += digit; // res1 = res1 + digit;
            digit = num % 10;
            num = num / 10;
            res2 += digit; // res2 = res2 + digit;
        }
        if (res1 == res2) {
            System.out.println("Lucky");
        } else {
            System.out.println("Unlucky");
        }
    }

    public static void luckyNumber2(int num) {
        int res = 0;
        while (num != 0) {
            res = num % 10 - res;
            num = num / 10;
        }
        if (res == 0) {
            System.out.println("Lucky");
        } else {
            System.out.println("Unlucky");
        }
    }
}
