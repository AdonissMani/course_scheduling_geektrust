package com.example.geektrust.services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.service.FileProcessingService;

public class FileProcessingTest {
     FileProcessingService service;

    @BeforeEach
    public void setUp() throws FileNotFoundException {
        service = new FileProcessingService("sample_input/input1.txt");
    }

    @Test
    public void FileProcesserServiceTest() {
        assertThrows(FileNotFoundException.class, () -> new FileProcessingService("abcd"));
    }

    @Test
    public void processLineTest() throws InvalidInputException, IOException {
        Command c = service.processLine();
        Assertions.assertNotNull(c);
    }
}
