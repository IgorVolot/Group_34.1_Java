public class CircusAppl {
    public static void main(String[] args) {
        lightOn();
        entertainer();
        lightOff();
    }

    private static void entertainer() {
        singer();
        juggler();
        clown();
        clown();
    }

    private static void clown() {
        System.out.println("My name is Oleg Popov");
        System.out.println("I am a clown");
    }

    private static void singer() {
        System.out.println("My name is Philippe");
        System.out.println("I am a singer");
    }

    private static void juggler() {
        System.out.println("My name is John Smith");
        System.out.println("I am a juggler");
    }

    private static void lightOff() {
        System.out.println("Light off");
    }

    private static void lightOn() {
        System.out.println("Light on");
    }
}
