package ait.user.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void isValid() {
        String validPassword = "MyP@ssword123!";
        Assertions.assertEquals(validPassword, "MyP@ssword123!");
    }

    @Test
    void isDigitsContains() {
        String inValidPassword = "MyP@sswordNaN!";
        Assertions.assertNotEquals("MyP@ssword123!", inValidPassword);
    }

    @Test
    void isSymbolsContains() {
        String inValidPassword = "MyPQssword1234";
        Assertions.assertNotEquals("MyP@ssword123!", inValidPassword);
    }

    @Test
    void isUpperCaseContains() {
        String inValidPassword = "myp@ssword123!";
        Assertions.assertNotEquals("MyP@ssword123!", inValidPassword);
    }

    @Test
    void isLowerCaseContains() {
        String inValidPassword = "MYP@SSWORD123!";
        Assertions.assertNotEquals("MyP@ssword123!", inValidPassword);
    }

    @Test
    void isLengthValid() {
        String inValidPassword = "MyP@ssw123!";
        Assertions.assertNotEquals("MyP@ssword123!", inValidPassword);
    }
}
