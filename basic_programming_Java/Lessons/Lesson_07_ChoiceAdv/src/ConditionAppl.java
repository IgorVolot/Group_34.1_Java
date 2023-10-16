public class ConditionAppl {
    public static void main(String[] args) {
        checkArmy1(15);
        checkArmy1(28);
        checkArmy1(60);
    }

    public static void checkArmy(int age) {
        if (age >= 18 && age < 45) {
            System.out.println("Go to army");
        } else {
            System.out.println("Go to home");
        }
    }

    public static void checkArmy1(int age) {
        if (age < 18 || age >= 45) {
            System.out.println("Go to home");
        } else {
            System.out.println("Go to army");
        }
    }
}
