package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {
     private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void testMain(){
        Main.main(new String[]{
            "sample_input/input1.txt"
        });
        assertTrue(!outContent.toString().trim().isEmpty());
    }
}