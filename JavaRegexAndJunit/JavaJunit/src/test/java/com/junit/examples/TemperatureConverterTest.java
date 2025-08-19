package com.junit.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest {

    private TemperatureConverter converter = new TemperatureConverter();

    @Test
    @DisplayName("Test 0°C to Fahrenheit")
    public void testZeroCelsiusToFahrenheit() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0.0), 0.001);
    }

    @Test
    @DisplayName("Test 100°C to Fahrenheit")
    public void testHundredCelsiusToFahrenheit() {
        assertEquals(212.0, converter.celsiusToFahrenheit(100.0), 0.001);
    }

    @Test
    @DisplayName("Test 32°F to Celsius")
    public void testThirtyTwoFahrenheitToCelsius() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32.0), 0.001);
    }

    @Test
    @DisplayName("Test 212°F to Celsius")
    public void testTwoTwelveFahrenheitToCelsius() {
        assertEquals(100.0, converter.fahrenheitToCelsius(212.0), 0.001);
    }

    @ParameterizedTest
    @CsvSource({
        "0, 32",
        "100, 212",
        "-40, -40",
        "37, 98.6",
        "-10, 14"
    })
    @DisplayName("Test Celsius to Fahrenheit conversions")
    public void testCelsiusToFahrenheitConversions(double celsius, double expectedFahrenheit) {
        assertEquals(expectedFahrenheit, converter.celsiusToFahrenheit(celsius), 0.1);
    }

    @ParameterizedTest
    @CsvSource({
        "32, 0",
        "212, 100",
        "-40, -40",
        "98.6, 37",
        "14, -10"
    })
    @DisplayName("Test Fahrenheit to Celsius conversions")
    public void testFahrenheitToCelsiusConversions(double fahrenheit, double expectedCelsius) {
        assertEquals(expectedCelsius, converter.fahrenheitToCelsius(fahrenheit), 0.1);
    }
}