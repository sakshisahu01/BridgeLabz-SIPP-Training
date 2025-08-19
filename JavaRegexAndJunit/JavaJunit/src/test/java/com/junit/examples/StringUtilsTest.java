package com.junit.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    @Test
    @DisplayName("Test reverse string")
    public void testReverse() {
        StringUtils utils = new StringUtils();
        assertEquals("olleh", utils.reverse("hello"));
        assertEquals("", utils.reverse(""));
        assertEquals("a", utils.reverse("a"));
    }

    @Test
    @DisplayName("Test reverse null string")
    public void testReverseNull() {
        StringUtils utils = new StringUtils();
        assertNull(utils.reverse(null));
    }

    @Test
    @DisplayName("Test palindrome detection")
    public void testIsPalindrome() {
        StringUtils utils = new StringUtils();
        assertTrue(utils.isPalindrome("racecar"));
        assertTrue(utils.isPalindrome("madam"));
        assertFalse(utils.isPalindrome("hello"));
    }

    @Test
    @DisplayName("Test palindrome with null")
    public void testIsPalindromeNull() {
        StringUtils utils = new StringUtils();
        assertFalse(utils.isPalindrome(null));
    }

    @Test
    @DisplayName("Test to uppercase conversion")
    public void testToUpperCase() {
        StringUtils utils = new StringUtils();
        assertEquals("HELLO", utils.toUpperCase("hello"));
        assertEquals("WORLD", utils.toUpperCase("World"));
        assertEquals("", utils.toUpperCase(""));
    }

    @Test
    @DisplayName("Test to uppercase with null")
    public void testToUpperCaseNull() {
        StringUtils utils = new StringUtils();
        assertNull(utils.toUpperCase(null));
    }
}