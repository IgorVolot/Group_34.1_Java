package ait.homework.task_01.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromeApplTest {
    @Test
    void palindromeChecker() {
        String string = "potop";
        Assertions.assertNotEquals(string.toLowerCase(), "potok");
    }
}
