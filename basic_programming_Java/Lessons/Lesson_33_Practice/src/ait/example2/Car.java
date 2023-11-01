package ait.example2;

public class Car extends Transport {
    @Override
    public void move() {
        System.out.println("My car is moving");
    }

    public void drive() {
        System.out.println("My car is driving");
        super.move();
        this.move();
        move();
    }
}
