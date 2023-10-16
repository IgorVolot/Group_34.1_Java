package homework;

public class StackAppl {
    public static void main(String[] args) {
        System.out.println("Method main has started");
        method1();
        System.out.println("Method main has finished");
    }

    private static void method1() {
        System.out.println("Method method1 has started");
        method2();
        System.out.println("Method method1 has finished");
    }

    private static void method2() {
        System.out.println("Method method2 has started");
        method3();
        System.out.println("Method method2 has finished");
    }

    private static void method3() {
        System.out.println("Method method3 has started");
        System.out.println("Method method3 has finished");
    }
}
