package com.junit.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileProcessorTest {
    
    private FileProcessor fileProcessor;
    private static final String TEST_FILE = "test_file.txt";
    
    @BeforeEach
    public void setUp() {
        fileProcessor = new FileProcessor();
    }
    
    @AfterEach
    public void tearDown() throws IOException {
        // Clean up test file
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }
    
    @Test
    @DisplayName("Test writing to file")
    public void testWriteToFile() throws IOException {
        String content = "Hello, JUnit!";
        fileProcessor.writeToFile(TEST_FILE, content);
        
        assertTrue(fileProcessor.fileExists(TEST_FILE));
        assertEquals(content, fileProcessor.readFromFile(TEST_FILE));
    }
    
    @Test
    @DisplayName("Test reading from file")
    public void testReadFromFile() throws IOException {
        String content = "Test content for reading";
        fileProcessor.writeToFile(TEST_FILE, content);
        
        String readContent = fileProcessor.readFromFile(TEST_FILE);
        assertEquals(content, readContent);
    }
    
    @Test
    @DisplayName("Test file exists after writing")
    public void testFileExists() throws IOException {
        assertFalse(fileProcessor.fileExists(TEST_FILE));
        
        fileProcessor.writeToFile(TEST_FILE, "test");
        assertTrue(fileProcessor.fileExists(TEST_FILE));
    }
    
    @Test
    @DisplayName("Test IOException when file doesn't exist")
    public void testIOExceptionForNonExistentFile() {
        assertThrows(IOException.class, () -> {
            fileProcessor.readFromFile("non_existent_file.txt");
        });
    }
}