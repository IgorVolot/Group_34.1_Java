package ait.equation;
/*
      Create a QuadraticEquation class in the ait.equation.model package. In this class, define the fields private
      double a; private double b; private double c;. Create a public QuadraticEquation(double a, double b, double c)
      constructor to initialize the fields. Create getters and setters. Create a public void display() method to print a
      quadratic equation to the console. Create methods public double delta() and public int quantityRoots() to calculate
      the discriminant and the number of uranium solutions, respectively. Create a class EquationAppl in the ait.equation package
      with the main method. In the main method, create several instances of QuadraticEquation and print for each of which are
      the results of the display, delta, quantityRoots methods.
 */

import ait.equation.model.QuadraticEquation;

public class EquationAppl {
    public static void main(String[] args) {

        QuadraticEquation equation1 = new QuadraticEquation(-16.4, 3.1, 4.5);
        QuadraticEquation equation2 = new QuadraticEquation(2, -4, 2);
        QuadraticEquation equation3 = new QuadraticEquation(3, 4, 5);
        System.out.println("------------- equation1 ---------------");
        equation1.display();
        System.out.println("------------- equation2 ---------------");
        equation2.display();
        System.out.println("------------- equation3 ---------------");
        equation3.display();
    }
}
