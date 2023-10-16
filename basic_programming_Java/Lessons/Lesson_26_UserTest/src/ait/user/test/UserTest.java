package ait.user.test;

import ait.user.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
    User user;
    final String email = "peter@gmx.de";
    final String password = "12345Az!";

    UserTest() {
    }

    @BeforeEach
    void setUp() {
        this.user = new User("peter@gmx.de", "12345Az!");
    }

    @Test
    void testValidPassword() {
        String validPassword = "qwertB7$";
        this.user.setPassword(validPassword);
        Assertions.assertEquals(validPassword, this.user.getPassword());
    }

    @Test
    void testPasswordLength() {
        String inValidPassword = "wertB7$";
        this.user.setPassword(inValidPassword);
        Assertions.assertEquals("12345Az!", this.user.getPassword());
    }

    @Test
    void testPasswordUpperCase() {
        String inValidPassword = "qwertb7$";
        this.user.setPassword(inValidPassword);
        Assertions.assertEquals("12345Az!", this.user.getPassword());
    }

    @Test
    void testPasswordLowerCase() {
        String inValidPassword = "QWERTY7$";
        this.user.setPassword(inValidPassword);
        Assertions.assertEquals("12345Az!", this.user.getPassword());
    }

    @Test
    void testPasswordDigit() {
        String inValidPassword = "qwertBD$";
        this.user.setPassword(inValidPassword);
        Assertions.assertEquals("12345Az!", this.user.getPassword());
    }

    @Test
    void testPasswordSpecialSymbol() {
        String inValidPassword = "qwertB79";
        this.user.setPassword(inValidPassword);
        Assertions.assertEquals("12345Az!", this.user.getPassword());
    }

    @Test
    void testValidEmail() {
        String validEmail = "pe-ter_67@gmx.qwe.co";
        this.user.setEmail(validEmail);
        Assertions.assertEquals(validEmail, this.user.getEmail());
    }

    @Test
    void testValidEmailWithSpaceAndUpperCase() {
        String validEmail = " peTer@gmx.qwe.co";
        validEmail = validEmail.trim().toLowerCase();
        this.user.setEmail(validEmail);
        Assertions.assertEquals(validEmail, this.user.getEmail());
    }

    @Test
    void testEmailWithoutAt() {
        String inValidEmail = "petergmx.qwe.co";
        this.user.setEmail(inValidEmail);
        Assertions.assertEquals("peter@gmx.de", this.user.getEmail());
    }

    @Test
    void testEmailWithTwoAt() {
        String inValidEmail = "peter@gmx@qwe.co";
        this.user.setEmail(inValidEmail);
        Assertions.assertEquals("peter@gmx.de", this.user.getEmail());
    }

    @Test
    void testEmailWithoutDot() {
        String inValidEmail = "peter@gmxqweco";
        this.user.setEmail(inValidEmail);
        Assertions.assertEquals("peter@gmx.de", this.user.getEmail());
    }

    @Test
    void testEmailWithDotAtWrongPlace() {
        String inValidEmail = "peter@gmx.qwec.o";
        this.user.setEmail(inValidEmail);
        Assertions.assertEquals("peter@gmx.de", this.user.getEmail());
    }

    @Test
    void testEmailWithSpecialSymbols() {
        String inValidEmail = "pe!er@gmx.de";
        this.user.setEmail(inValidEmail);
        Assertions.assertEquals("peter@gmx.de", this.user.getEmail());
    }
}
