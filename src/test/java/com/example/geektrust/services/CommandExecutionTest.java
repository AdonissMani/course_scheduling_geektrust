package com.example.geektrust.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.concreate.CommandExecution;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.service.CommandService;
import com.example.geektrust.service.implementation.AddCourse;

public class CommandExecutionTest {
    Command command1 ;
    Command command2 ;

    @BeforeEach
    public void setUp() throws InvalidInputException {
        command1 = ((CommandService) CommandService.getInstance()).getCommandFromString("ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2");
        command2 = ((CommandService) CommandService.getInstance()).getCommandFromString("REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES");
    }

    @Test
    public void getExecutorTest() {
       Assertions.assertTrue(CommandExecution.getExecutor(command1) instanceof AddCourse);
       Assertions.assertFalse(CommandExecution.getExecutor(command2) instanceof AddCourse);
    }

}
