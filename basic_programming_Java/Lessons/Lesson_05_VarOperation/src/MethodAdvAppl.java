public class MethodAdvAppl {
    public static void main(String[] args) {


        long d = day();
        System.out.println(d);

        printResult(d);
        double a = circleLength(10);
        printResult(a);
        a = circleLength(25);
        printResult(a);
    }

    public static double circleLength(double radius) {
        double result = 2 * pi() * radius;
        return result;
    }

    public static double pi() {
//        double res = 3.1415926;
//        return res;
        return 3.1415926;
    }

    public static long day() {
//        long duration = 1000 * 60 * 60 * 24;
//        return duration;
        return 1000 * 60 * 60 * 24;
    }

    public static void printResult(double a) {
        System.out.print("Result = ");
        System.out.println(a);
    }
}
