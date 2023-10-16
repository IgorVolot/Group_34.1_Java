package ait;

public class Method {
    public static void main(String[] args) {

        String name = "Maria";
        String nameAndrej = "Andrej";
        String nameVasja = "Vasja";

        greet(name);
        greet("Tatiana");
        greet(nameAndrej);
        greet(nameVasja);

        int counterResult;
        counterResult = counter(); // 30

        System.out.println(counterResult); // 30

        int addResult = add(10, 30);
        System.out.println(addResult); // 40

        addResult = add(2555, 1587984);
        System.out.println(addResult); // 1590539
    }

    // метод ни чего не возвращает, но принимает 1 аргумент типа String
    public static void greet(String name) {
        // Hello my name is Andrej
        System.out.println("Hello my name is " + name);
    }

    // метод возвращает тип int, но ни чего не принимает
    public static int counter() {
        int a = 10;
        int b = 20;
        int result = a + b;

        return result; // 30
    }

    // метод возвращает тип int, и принимает 2 аргумент типа int
    public static int add(int a, int b) {
        int result = a + b;
        // result a +b;
        return result;
    }


//    public static int counter2() {
//        int a = 10;
//        int b = 20;
//        int result = a + b;
//
//        return a + b; // 30
//        return 10 + 20; // 30
//    }


//    public static void greetAndrej() {
//        System.out.println("Hello my name is Andrej");
//    }
//
//    public static void greetVasja() {
//        System.out.println("Hello my name is Vasja");
//    }
}
