package com.junit.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class DateFormatterTest {

    private DateFormatter formatter = new DateFormatter();

    @Test
    @DisplayName("Test valid date format conversion")
    public void testValidDateFormat() {
        assertEquals("15-06-2023", formatter.formatDate("2023-06-15"));
        assertEquals("01-01-2024", formatter.formatDate("2024-01-01"));
    }

    @Test
    @DisplayName("Test invalid date format throws exception")
    public void testInvalidDateFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("15-06-2023");
        });
    }

    @Test
    @DisplayName("Test null date throws exception")
    public void testNullDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate(null);
        });
    }

    @Test
    @DisplayName("Test empty date throws exception")
    public void testEmptyDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("");
        });
    }

    @ParameterizedTest
    @CsvSource({
        "2023-06-15, 15-06-2023",
        "2024-01-01, 01-01-2024",
        "2000-12-31, 31-12-2000",
        "1999-05-20, 20-05-1999"
    })
    @DisplayName("Test multiple date format conversions")
    public void testMultipleDateFormats(String input, String expected) {
        assertEquals(expected, formatter.formatDate(input));
    }
}