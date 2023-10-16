package ait.shape;

import ait.shape.model.Circle;
import ait.shape.model.Shape;
import ait.shape.model.Square;
import ait.shape.model.Triangle;

public class FigureAppl {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];

        shapes[0] = new Circle("circle",2.0);
        shapes[1] = new Circle("circle",15.4);
        shapes[2] = new Triangle("triangle",4.0);
        shapes[3] = new Square("square",10);
        System.out.println(shapes[0]);
        System.out.println(shapes[1]);
        System.out.println(shapes[2]);
        System.out.println(shapes[3]);
        System.out.println();

        System.out.println("Total area of shapes is " + totalArea(shapes));
        System.out.println("Total perimeter of shapes is " + totalPerimeter(shapes));
        System.out.println("Total area of circles is " + totalAreaOfCircles(shapes));
    }

    public static void printArray(Shape[] shapes) {
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] != null) {
                System.out.println(shapes[i]);
            }
        }
    }

    public static double totalArea(Shape[] shapes) {
        double sum = 0;
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] != null) {
                sum += shapes[i].calcArea();
            }
        }
        return sum;
    }

    public static double totalPerimeter(Shape[] shapes) {
        double sum = 0;
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] != null) {
                sum += shapes[i].calcPerimeter();
            }
        }
        return sum;
    }

    public static double totalAreaOfCircles(Shape[] shapes) {
        double sum = 0;
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] instanceof Circle) {
                sum += shapes[i].calcArea();
            }
        }
        return sum;
    }
}
