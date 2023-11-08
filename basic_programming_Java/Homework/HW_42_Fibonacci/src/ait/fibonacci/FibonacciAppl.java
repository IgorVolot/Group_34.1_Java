package ait.fibonacci;

import ait.fibonacci.model.Fibonacci;

import java.util.Iterator;

public class FibonacciAppl {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci(8);
        // print all numbers and calculate sum
        // 1,1,2,3,5,8,13,21
        // sum = 54


        Iterator<Integer> iterator = fibonacci.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            int n = iterator.next();
            System.out.print(n + " |");
            sum += n;
        }
        System.out.println();
        System.out.println("Sum = " + sum);

    }
}
