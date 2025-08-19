package com.junit.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {

    @Test
    @DisplayName("Test adding element to list")
    public void testAddElement() {
        ListManager manager = new ListManager();
        List<Integer> list = new ArrayList<>();
        
        manager.addElement(list, 5);
        assertEquals(1, list.size());
        assertTrue(list.contains(5));
    }

    @Test
    @DisplayName("Test removing element from list")
    public void testRemoveElement() {
        ListManager manager = new ListManager();
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        
        boolean removed = manager.removeElement(list, 5);
        assertTrue(removed);
        assertEquals(1, list.size());
        assertFalse(list.contains(5));
    }

    @Test
    @DisplayName("Test removing non-existent element")
    public void testRemoveNonExistentElement() {
        ListManager manager = new ListManager();
        List<Integer> list = new ArrayList<>();
        list.add(10);
        
        boolean removed = manager.removeElement(list, 5);
        assertFalse(removed);
        assertEquals(1, list.size());
    }

    @Test
    @DisplayName("Test getting size of list")
    public void testGetSize() {
        ListManager manager = new ListManager();
        List<Integer> list = new ArrayList<>();
        
        assertEquals(0, manager.getSize(list));
        
        list.add(1);
        list.add(2);
        assertEquals(2, manager.getSize(list));
    }

    @Test
    @DisplayName("Test adding to null list throws exception")
    public void testAddElementNullList() {
        ListManager manager = new ListManager();
        assertThrows(IllegalArgumentException.class, () -> {
            manager.addElement(null, 5);
        });
    }

    @Test
    @DisplayName("Test removing from null list throws exception")
    public void testRemoveElementNullList() {
        ListManager manager = new ListManager();
        assertThrows(IllegalArgumentException.class, () -> {
            manager.removeElement(null, 5);
        });
    }
}