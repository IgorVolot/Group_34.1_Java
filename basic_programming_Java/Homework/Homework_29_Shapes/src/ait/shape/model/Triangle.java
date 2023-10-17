package ait.shape.model;

public class Triangle extends Shape {
    private double perimeter;
    private double area;

    public Triangle(String shape, double side) {
        super(shape, side);
    }

    @Override
    public double calcArea() {
        return area = Math.sqrt(3) * side * side / 4;
    }

    @Override
    public double calcPerimeter() {
        return perimeter = side * 3;
    }
}
