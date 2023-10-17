package ait.shape.model;

public class Circle extends Shape {
    private double area;
    private double perimeter;

    public Circle(String shape, double side) {
        super(shape, side);
    }

    @Override
    public double calcArea() {
        return area = Math.PI * side * side;
    }

    @Override
    public double calcPerimeter() {
        return perimeter = 2 * Math.PI * side;
    }
}
