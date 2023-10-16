package ait.homework.task_02.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComparatorApplTest {
    @Test
    void testDigitsComparator() {
        String str1 = "1.2.3";
        String str2 = "1.2.3";
        Assertions.assertEquals(str1, str2);
    }
}
