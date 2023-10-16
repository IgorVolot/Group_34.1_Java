package ait.test;

import ait.wrapper.Wrappers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WrappersTest {

    @Test
    public void test_getDigit_validString_digitsString() {
        String testString = "as87b9";
        String result = Wrappers.getDigits(testString);
        String expectedResult = "879";
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void test_getDigit_inputValueIsNull() {
        String testString = null;
        String result = Wrappers.getDigits((String)testString);
        Assertions.assertNull(result);
    }

    @Test
    public void test_getDigit_valueIsEmptyString_emptyString() {
        String testString = "";
        String result = Wrappers.getDigits(testString);
        String expectedResult = "";
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedResult, result);
    }
}
