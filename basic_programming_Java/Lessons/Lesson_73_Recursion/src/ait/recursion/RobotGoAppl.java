package ait.recursion;
/*
    сделать метод, который эмулирует идущего робота
    на каждом шагу робот сообщает, что он сделал шаг и должен проходить n шагов, затем стоп
 */
public class RobotGoAppl {
    public static void main(String[] args) {
        int steps = 10;
        int count = 0;
        moveForward(steps, count);
        System.out.println("Mission complete");


    }

    private static void moveForward(int steps, int count) {
        if (steps > 0){
            System.out.println("Robot makes " + ++count + ", now remains -> " + --steps + " steps.");
            moveForward(steps, count);
        }
    }
}
