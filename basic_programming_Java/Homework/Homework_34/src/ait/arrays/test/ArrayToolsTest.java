package ait.arrays.test;

import ait.arrays.utils.ArrayTools;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ArrayToolsTest {
    Integer[] arrNum;
    String[] arrStr;

    @BeforeEach
    void setUp() {
        arrNum = new Integer[]{1, 4, 3, 2, 5, 6, 9, 8, 0, 7, 3};
        arrStr = new String[]{"one", "two", "three", "four", "five"};
    }

    @Test
    void testPrintArray() {
        System.out.println("===== testPrintArray =====");
        ArrayTools.printArray(arrNum);
        ArrayTools.printArray(arrStr);
    }

    @Test
    void testSearch() {
        System.out.println("========== testSearch ==========");
        int index = ArrayTools.search(arrStr, "four");
        System.out.println("index = " + index);
        index = ArrayTools.search(arrStr, "six");
        System.out.println("index = " + index);
        index = ArrayTools.search(arrNum, "4");
        index = ArrayTools.search(arrStr, 4);
        System.out.println("index = " + index);
        index = ArrayTools.search(arrNum, 6);
        System.out.println("index = " + index);
    }

    @Test
    void testFindByPredicate() {
        System.out.println("========== testFindByPredicate ==========");
        Integer num = ArrayTools.findByPredicate(arrNum, n -> n < 5);
        System.out.println(num);
        num = ArrayTools.findByPredicate(arrNum, n -> n % 5 == 0);
        System.out.println(num);
        String str = ArrayTools.findByPredicate(arrStr, s -> s.length() == 4);
        System.out.println(str);
    }

    @Test
    void testBubbleSort() {
        System.out.println("========== testBubbleSort ==========");
        ArrayTools.bubbleSort(arrNum);
        ArrayTools.printArray(arrNum);
        ArrayTools.bubbleSort(arrStr);
        ArrayTools.printArray(arrStr);
    }

    @Test
    void testBubbleSortComparator() {
        System.out.println("========== testBubbleSortComparator ==========");
        ArrayTools.bubbleSort(arrNum, (n1, n2) -> n2 - n1);
        ArrayTools.printArray(arrNum);
        ArrayTools.bubbleSort(arrStr, (s1, s2) -> s1.length() - s2.length());
        ArrayTools.printArray(arrStr);
    }

    @Test
    void testOddEvenComparator() {
        System.out.println("========== testOddEvenComparator ==========");
        ArrayTools.oddEvenComparator(arrNum, (n1, n2) -> n1 % 2 - n2 % 2);
        ArrayTools.printArray(arrNum);
    }

    @Test
    void testOddEvenComparator1() {
        System.out.println("========== testOddEvenComparator1 ==========");
        Comparator<Integer> oddEvenComp = (n1, n2) -> {
            if (n1 % 2 == 0 && n2 % 2 != 0) {
                return -1;
            }
            if (n1 % 2 != 0 && n2 % 2 == 0) {
                return 1;
            }
            if (n1 % 2 == 0 && n2 % 2 ==0){
                return n1 - n2;
            }
            if (n1 % 2 != 0 && n2 % 2 !=0){
                return n2 - n1;
            }
            return 0;
        };
        Integer[] origin = {1, 4, 3, 2, 5, 6, 0, 9, 8, 7, 3};
        Integer[] expected = {0, 2, 4, 6, 8, 9, 7, 5, 3, 3, 1};
//        Arrays.sort(origin, oddEvenComp);
        ArrayTools.bubbleSort(origin, oddEvenComp);
        ArrayTools.printArray(origin);
        assertArrayEquals(expected, origin);
    }
}