package com.junit.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTaskTest {

    @Test
    @Timeout(2) // Test will fail if it takes more than 2 seconds
    @DisplayName("Test long running task with timeout - should fail")
    public void testLongRunningTaskWithTimeout() {
        PerformanceTask task = new PerformanceTask();
        String result = task.longRunningTask();
        assertEquals("Task completed successfully", result);
    }

    @Test
    @Timeout(2) // Test will pass as it takes only 1 second
    @DisplayName("Test quick task with timeout - should pass")
    public void testQuickTaskWithTimeout() {
        PerformanceTask task = new PerformanceTask();
        String result = task.quickTask();
        assertEquals("Quick task completed", result);
    }
}