package com.junit.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {
    
    private DatabaseConnection dbConnection;
    
    @BeforeEach
    public void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }
    
    @AfterEach
    public void tearDown() {
        dbConnection.disconnect();
    }
    
    @Test
    @DisplayName("Test connection is established in setUp")
    public void testConnectionEstablished() {
        assertTrue(dbConnection.isConnected());
    }
    
    @Test
    @DisplayName("Test connection is closed after tearDown")
    public void testConnectionClosed() {
        assertTrue(dbConnection.isConnected());
        dbConnection.disconnect();
        assertFalse(dbConnection.isConnected());
    }
}