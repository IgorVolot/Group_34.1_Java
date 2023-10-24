package ait.arrays.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DateSortTest {
    Comparator<String> comparator;

    @BeforeEach
    void setUp() {
        comparator = (s1, s2) -> {
            String[] str1 = s1.split("-");
            String[] str2 = s2.split("-");
            for (int i = str1.length - 1; i >= 0; i--) {
                int date1 = Integer.parseInt(str1[i]);
                int date2 = Integer.parseInt(str2[i]);
                if (date1 - date2 > 0) {
                    return 1;
                }
                if (date1 - date2 < 0) {
                    return -1;
                }
            }
            return 0;
        };
    }

    @Test
    void testDateSort() {
        String[] dates = {
                "07-05-1990",
                "28-01-2010",
                "11-08-1990",
                "15-01-2010",
                "16-06-1970"
        };
        String[] expected = {
                "16-06-1970",
                "07-05-1990",
                "11-08-1990",
                "15-01-2010",
                "28-01-2010"
        };
        Arrays.sort(dates, comparator);
        assertArrayEquals(expected, dates);
        System.out.println(Arrays.toString(dates));
        System.out.println(Arrays.toString(expected));
    }
}
