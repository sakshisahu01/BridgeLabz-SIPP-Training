package com.junit.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionHandlerTest {

    @Test
    @DisplayName("Test division with valid numbers")
    public void testDivideValid() {
        ExceptionHandler handler = new ExceptionHandler();
        assertEquals(2, handler.divide(10, 5));
    }

    @Test
    @DisplayName("Test division by zero throws ArithmeticException")
    public void testDivideByZero() {
        ExceptionHandler handler = new ExceptionHandler();
        
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            handler.divide(10, 0);
        });
        
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}