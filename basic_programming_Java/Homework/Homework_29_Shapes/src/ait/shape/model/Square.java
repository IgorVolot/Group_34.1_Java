package ait.shape.model;

public class Square extends Shape {
    private double perimeter;
    private double area;

    public Square(String shape, double side) {
        super(shape, side);
    }

    @Override
    public double calcArea() {
        area = side * side;
        return area;
    }

    @Override
    public double calcPerimeter() {
        perimeter = side * 2;
        return perimeter;
    }
}
