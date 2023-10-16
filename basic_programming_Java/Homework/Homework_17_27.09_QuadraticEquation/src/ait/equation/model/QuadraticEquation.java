package ait.equation.model;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void display() {
        System.out.println(a + "x^2" + (b >= 0 ? "+" : "") + b + "x" + (c >= 0 ? "+" : "") + c + " = 0 \n" + "Delta = " + delta() + "\n" + "Number of roots = " + quantityRoots());

    }

    public double delta() {
        double D = b * b - (4 * a * c);
        return D;
    }

    public int quantityRoots() {
        int q = 0;
        if (delta() > 0) {
            q = 2;
        }
        if (delta() == 0) {
            q = 1;
        }
        if (delta() < 0) {
            q = 0;
        }
        return q;
    }
}
