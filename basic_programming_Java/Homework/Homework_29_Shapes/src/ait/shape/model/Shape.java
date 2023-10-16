package ait.shape.model;
     /*
        Создайте абстрактный класс Shape с полем side типа double и абстрактными методами calcArea и calcPerimeter.
     Создайте классы Circle, Triangle, Square, которые наследуют классу Shape и реализуют абстрактные методы.
     Напишите класс FigureAppl с методом main. В методе создайте массив фигур. Добавьте в массив два круга,
     один треугольник и один квадрат. Рассчитайте общую площадь и общий периметр всех фигур из массива фигур.
        Вычислите общую площадь кругов. (*)
      */

public abstract class Shape {

    protected String shape;
    protected double side;

    public Shape(String shape, double side) {
        this.shape = shape;
        this.side = side;
    }

    public String getShape() {
        return shape;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public abstract double calcArea();

    public abstract double calcPerimeter();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Shape ").append(shape);
        sb.append(", with side (radius) = ").append(side);
        sb.append(" has a perimeter = ").append(calcPerimeter());
        sb.append(" and an area = ").append(calcArea());
        return sb.toString();
    }
}
