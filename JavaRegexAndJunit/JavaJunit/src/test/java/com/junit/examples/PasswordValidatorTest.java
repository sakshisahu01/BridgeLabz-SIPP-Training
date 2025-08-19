package com.junit.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    private PasswordValidator validator = new PasswordValidator();

    @Test
    @DisplayName("Test valid password")
    public void testValidPassword() {
        assertTrue(validator.isValidPassword("Password123"));
        assertTrue(validator.isValidPassword("MyPass1"));
    }

    @Test
    @DisplayName("Test invalid password - too short")
    public void testInvalidPasswordTooShort() {
        assertFalse(validator.isValidPassword("Pass"));
    }

    @Test
    @DisplayName("Test invalid password - no uppercase")
    public void testInvalidPasswordNoUppercase() {
        assertFalse(validator.isValidPassword("password123"));
    }

    @Test
    @DisplayName("Test invalid password - no digit")
    public void testInvalidPasswordNoDigit() {
        assertFalse(validator.isValidPassword("Password"));
    }

    @Test
    @DisplayName("Test invalid password - null")
    public void testInvalidPasswordNull() {
        assertFalse(validator.isValidPassword(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "ValidPass1", "Another2", "TestPass3"
    })
    @DisplayName("Test valid passwords with parameterized test")
    public void testValidPasswordsParameterized(String password) {
        assertTrue(validator.isValidPassword(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "short", "nouppercase1", "NODIGIT", "NoDigits"
    })
    @DisplayName("Test invalid passwords with parameterized test")
    public void testInvalidPasswordsParameterized(String password) {
        assertFalse(validator.isValidPassword(password));
    }

    @Test
    @DisplayName("Test validation messages")
    public void testValidationMessages() {
        assertEquals("Password must be at least 6 characters long", 
                    validator.getValidationMessage("short"));
        assertEquals("Password must contain at least one uppercase letter", 
                    validator.getValidationMessage("password1"));
        assertEquals("Password must contain at least one digit", 
                    validator.getValidationMessage("Password"));
        assertEquals("Password is valid", 
                    validator.getValidationMessage("Password123"));
    }
}