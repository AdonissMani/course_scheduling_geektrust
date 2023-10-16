package com.example.geektrust.services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.concreate.CommandExecution;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.CourseOffering;
import com.example.geektrust.service.CommandExecutor;
import com.example.geektrust.service.CommandService;

public class AllotCourseTest {
    Command command1;
    CommandExecutor executor;
    private TreeMap<String , CourseOffering> courses;
    private Map<String,CourseOffering> registrationIdCourseMap;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() throws InvalidInputException {
        System.setOut(new PrintStream(outContent));
        command1 = ((CommandService) CommandService.getInstance()).getCommandFromString("ALLOT OFFERING-JAVA-JAMES");
        executor = CommandExecution.getExecutor(command1);
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
    }


    @Test
    public void testExecute() {
        assertThrows(InvalidInputException.class , ()->executor.executeCommand(courses , registrationIdCourseMap , command1));
    }
}
