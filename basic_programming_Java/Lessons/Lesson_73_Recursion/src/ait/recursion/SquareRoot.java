package ait.recursion;

public class SquareRoot {
    public static void main(String[] args) {
        double n = 169;
        double root = squareRoot(n);
        System.out.println("Square root of " + n + " = " + root);
    }

    private static double squareRoot(double n) {
        return squareRootRecursive(n, n/2);
    }

    private static double squareRootRecursive(double n, double guess) {
        double newGuess = (guess + n / guess) / 2;
        System.out.println(newGuess);
        if (Math.abs(newGuess - guess) < 0.0001) { // считаем абсолютную величину разницы, модуль
            return newGuess;
        }
        return squareRootRecursive(n, newGuess);
    }
}
