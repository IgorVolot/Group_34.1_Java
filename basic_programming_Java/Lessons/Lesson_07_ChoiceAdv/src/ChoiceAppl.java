public class ChoiceAppl {
    public static void main(String[] args) {
        int x = 10;
        int y = -x;
        System.out.println(y);
        y = -y;
        System.out.println(y);
        int age = 28;
        double res = barmen(age);
        System.out.println("You max vol. = " + res);
        age = 15;
        res = barmen(age);
        System.out.println("You max vol. = " + res);
        res = max(0.2, 0.1);
        System.out.println("Max = " + res);
        res = max(3.8, 5.4);
        System.out.println("Max = " + res);
        res = max(-2.3, -3.5);
        System.out.println("Max = " + res);
        res = abs(5);
        System.out.println("abs = " + res);
        res = abs(-7);
        System.out.println("abs = " + res);
        res = meal(188, 300);
        System.out.println("Meal = " + res);
        res = meal(195, 300);
        System.out.println("Meal = " + res);
        res = min(0.2, 0.1);
        System.out.println("Min = " + res);
        res = min(3.8, 5.4);
        System.out.println("Min = " + res);
        res = min(-2.3, -3.5);
        System.out.println("Min = " + res);
        int b = sign(7);
        System.out.println("Sign = " + b);
        b = sign(-5);
        System.out.println("Sign = " + b);
        b = sign(0);
        System.out.println("Sign = " + b);
    }

    public static double min(double a, double b) {
//        return a < b ? a : b;
//        return a + b - max(a, b);
//        return -max(-a, -b);
        return (a + b - abs(a - b)) / 2;
    }

    public static int sign(double x) {
        return x > 0 ? 1 : (x < 0 ? -1 : 0);
//        if (x > 0) {
//            return 1;
//        }
//        if (x < 0) {
//            return -1;
//        }
//        return 0;
    }

    public static double barmen(int age) {
        double vol = age >= 18 ? 42 : 2.5;
        return vol;
    }

    public static double max(double a, double b) {
        return a > b ? a : b;
    }

    public static double abs(double a) {
        return a >= 0 ? a : -a;
    }

    public static double meal(int height, double dish) {
        return height <= 192 ? dish : dish * 1.5;
    }
}
