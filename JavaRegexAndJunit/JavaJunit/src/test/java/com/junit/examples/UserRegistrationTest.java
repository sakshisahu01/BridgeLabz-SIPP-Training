package com.junit.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    private UserRegistration registration = new UserRegistration();

    @Test
    @DisplayName("Test valid user registration")
    public void testValidUserRegistration() {
        assertDoesNotThrow(() -> {
            registration.registerUser("john_doe", "john@example.com", "Password123");
        });
    }

    @Test
    @DisplayName("Test registration with null username")
    public void testNullUsername() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser(null, "john@example.com", "Password123");
        });
        assertEquals("Username cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test registration with empty username")
    public void testEmptyUsername() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("", "john@example.com", "Password123");
        });
        assertEquals("Username cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test registration with invalid email format")
    public void testInvalidEmailFormat() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("john_doe", "invalid-email", "Password123");
        });
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    @DisplayName("Test registration with null email")
    public void testNullEmail() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("john_doe", null, "Password123");
        });
        assertEquals("Email cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test registration with short password")
    public void testShortPassword() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("john_doe", "john@example.com", "Pass1");
        });
        assertEquals("Password must be at least 8 characters long", exception.getMessage());
    }

    @Test
    @DisplayName("Test registration with password missing uppercase")
    public void testPasswordMissingUppercase() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("john_doe", "john@example.com", "password123");
        });
        assertEquals("Password must contain at least one uppercase letter", exception.getMessage());
    }

    @Test
    @DisplayName("Test registration with password missing digit")
    public void testPasswordMissingDigit() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("john_doe", "john@example.com", "Password");
        });
        assertEquals("Password must contain at least one digit", exception.getMessage());
    }

    @Test
    @DisplayName("Test registration with null password")
    public void testNullPassword() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("john_doe", "john@example.com", null);
        });
        assertEquals("Password cannot be null or empty", exception.getMessage());
    }
}