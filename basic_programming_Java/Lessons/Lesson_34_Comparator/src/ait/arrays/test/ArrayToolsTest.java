package ait.arrays.test;

import ait.arrays.utils.ArrayTools;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayToolsTest {
    Integer[] arrNum;
    String[] arrStr;

    @BeforeEach
    void setUp() {
        arrNum = new Integer[]{9, 7, 4, 7, 2, 5, 1, 0};
        arrStr = new String[]{"one","two","three","four","five"};
    }

    @Test
    void testPrintArray(){
        System.out.println("===== testPrintArray =====");
        ArrayTools.printArray(arrNum);
        ArrayTools.printArray(arrStr);
    }
}