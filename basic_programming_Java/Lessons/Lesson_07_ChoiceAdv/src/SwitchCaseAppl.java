public class SwitchCaseAppl {
    public static void main(String[] args) {
//        fan2(2);
//        bank(7);
        scheduler(100);
    }

    public static void calculator(double a, double b, int oper) {
        // Homework oper = 1 => a+b, oper = 2 => a-b, oper = 3 => a*b, oper = 4 => a/b
        // default print Wrong operation;
    }

    public static void scheduler(int week) {
        // John 1,5..., Peter 2,6..., Mary 3,7.., Rabindranate 4,8...
        if (week < 1 || week > 52) {
            System.out.println("Wrong week");;
            return;
        }
        switch (week % 4) {
            case 1:
                System.out.println("John");
                break;
            case 2:
                System.out.println("Peter");
                break;
            case 3:
                System.out.println("Mary");
                break;
            case 0:
                System.out.println("Rabindranate");
                break;
        }
    }

    public static void bank(int day) {
        switch (day) {
            case 1:
            case 3:
            case 5:
                System.out.println("8:30 - 13:30");
                break;
            case 2:
            case 4:
                System.out.println("8:30 - 13:00 and 16:00 - 18:00");
                break;
            case 6:
            case 7:
                System.out.println("Closed");
                break;
            default:
                System.out.println("Wrong day");
        }
    }

    public static void fan(int mode) {
        if (mode == 0) {
            System.out.println("Stop");
        } else if (mode == 1) {
            System.out.println("Slow");
        } else if (mode == 2) {
            System.out.println("Medium");
        } else if (mode == 3) {
            System.out.println("Fast");
        } else {
            System.out.println("Wrong mode");
        }
    }

    public static void fan1(int mode) {
        if (mode == 0) {
            System.out.println("Stop");
            return;
        }
        if (mode == 1) {
            System.out.println("Slow");
            return;
        }
        if (mode == 2) {
            System.out.println("Medium");
            return;
        }
        if (mode == 3) {
            System.out.println("Fast");
            return;
        }
        System.out.println("Wrong mode");
    }

    public static void fan2(int mode) {
        switch (mode) {
            case 0:
                System.out.println("Stop");
                break;
            case 1:
                System.out.println("Slow");
                break;
            case 2:
                System.out.println("Medium");
                break;
            case 3:
                System.out.println("Fast");
                break;
            default:
                System.out.println("Wrong operation");
                break;
        }
        System.out.println("End of function");
    }
}