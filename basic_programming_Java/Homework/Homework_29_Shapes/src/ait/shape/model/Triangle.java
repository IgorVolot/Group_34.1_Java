package ait.shape.model;

public class Triangle extends Shape {
    private double perimeter;
    private double area;

    public Triangle(String shape, double side) {
        super(shape, side);
    }

    @Override
    public double calcArea() {
        area = (Math.sqrt(3) * side * side) / 4;
        return area;
    }

    @Override
    public double calcPerimeter() {
        perimeter = side * 3;
        return perimeter;
    }
}
