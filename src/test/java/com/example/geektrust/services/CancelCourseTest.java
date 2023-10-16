package com.example.geektrust.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.concreate.CommandExecution;
import com.example.geektrust.exceptions.CourseFullException;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.CourseOffering;
import com.example.geektrust.service.CommandExecutor;
import com.example.geektrust.service.CommandService;

public class CancelCourseTest {

    Command command1;
    Command command2;
    Command command3;
    CommandExecutor executor1;
    CommandExecutor executor2;
    CommandExecutor executor3;

    private TreeMap<String , CourseOffering> courses;
    private Map<String,CourseOffering> registrationIdCourseMap;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() throws InvalidInputException, CourseFullException {
        System.setOut(new PrintStream(outContent));
        command1 = ((CommandService) CommandService.getInstance()).getCommandFromString("ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2");
        command2 = ((CommandService) CommandService.getInstance()).getCommandFromString("REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES");
        command3 = ((CommandService) CommandService.getInstance()).getCommandFromString("CANCEL REG-COURSE-ANDY-JAVA");
        executor1 = CommandExecution.getExecutor(command1);
        executor2 = CommandExecution.getExecutor(command2);
        executor3 = CommandExecution.getExecutor(command3);
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
        executor1.executeCommand(courses , registrationIdCourseMap , command1);
        executor2.executeCommand(courses,registrationIdCourseMap , command2);

    }

    @Test
    public void testExecute() {
        assertDoesNotThrow(()->executor3.executeCommand(courses , registrationIdCourseMap , command3));
    }

}
