package com.junit.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    @DisplayName("Test even numbers with parameterized test")
    public void testEvenNumbers(int number) {
        NumberUtils utils = new NumberUtils();
        assertTrue(utils.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    @DisplayName("Test odd numbers with parameterized test")
    public void testOddNumbers(int number) {
        NumberUtils utils = new NumberUtils();
        assertFalse(utils.isEven(number));
    }

    @ParameterizedTest
    @CsvSource({
        "2, true",
        "4, true", 
        "6, true",
        "7, false",
        "9, false"
    })
    @DisplayName("Test even numbers with CSV source")
    public void testIsEvenWithCsvSource(int number, boolean expected) {
        NumberUtils utils = new NumberUtils();
        assertEquals(expected, utils.isEven(number));
    }
}