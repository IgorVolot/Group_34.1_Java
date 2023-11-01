package ait.example1;

public class Plane extends Transport {

    public static int idCounter = 0;
    public int idCounterNonStatic = 0;

    @Override
    public void move() {
        idCounter++;
        idCounterNonStatic++;
        System.out.println("Non static var: " + idCounterNonStatic);
        System.out.println("Static var: " + idCounter);
        System.out.println("Plane is moving");
    }

    public void fly() {
        System.out.println("Plane is flying");
        move();
    }
}
