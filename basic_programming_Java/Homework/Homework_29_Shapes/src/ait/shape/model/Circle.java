package ait.shape.model;

public class Circle extends Shape {
    private double area;
    private double perimeter;

    public Circle(String shape, double side) {
        super(shape, side);
    }

    @Override
    public double calcArea() {
        area = Math.PI * side * side;
        return area;
    }

    @Override
    public double calcPerimeter() {
        perimeter = 2 * Math.PI * side;
        return perimeter;
    }
}
