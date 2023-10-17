package ait.shape.model;

public class Square extends Shape {
    private double perimeter;
    private double area;

    public Square(String shape, double side) {
        super(shape, side);
    }

    @Override
    public double calcArea() {
        return area = side * side;
    }

    @Override
    public double calcPerimeter() {
        return perimeter = side * 4;
    }
}
