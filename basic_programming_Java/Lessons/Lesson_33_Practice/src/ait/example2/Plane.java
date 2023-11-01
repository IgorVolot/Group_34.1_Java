package ait.example2;

public class Plane extends Transport {

    @Override
    public void move() {
        System.out.println("Plane is moving");
    }

    public void fly() {
        System.out.println("Plane is flying");
        move();
    }
}
