package ait.fibonacci.model;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {
    private int size;
    private int currPos;

    private int prev;
    private int prevPrev;

    public FibonacciIterator(int size) {
        this.size = size;
        prev = 1;
        prevPrev = 1;
        currPos = 1;
    }

    @Override
    public boolean hasNext() {
        return currPos <= size;
    }

//    @Override
//    public Integer next() {
//        int fibo = 0;
//        int num1 = currPos;
//        int num2 = ++currPos;
//        if (currPos <= 1){
//            fibo = num1 + num2;
//        } else {
//            fibo = (currPos - 2) + (currPos - 1);
//        }
//        return fibo;
//    }

    @Override
    public Integer next() {
        if (currPos++ <= 2) {
            return 1;
        }
        int curr = prev;
        prev = prev + prevPrev;
        prevPrev = curr;
        return prev;
    }
}
