package ait.map;

import java.lang.reflect.Array;
import java.util.*;

public class DigitsFreqAppl {
    static Random random = new Random();

    public static void main(String[] args) {
        /*
        Homework: Generate 1_000_000 random int positive numbers
        and calculate digits frequency
        example - 18374, 9832, 67, 3525
        [1] -> 1
        [2] -> 2
        [3] -> 3
        [4] -> 1
        ...
         */
        Map<String, Integer> res = new HashMap<>();
        for (int i = 0; i < 1_000_000; i++) {
            Integer number = random.nextInt(Integer.MAX_VALUE);
            String[] digits = number.toString().split("");
            for (String string : digits) {
                res.merge(string, 1, (a, b) -> a + b);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(res.entrySet());
        list.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));
        list.forEach(e -> System.out.println(e));

    }

}
