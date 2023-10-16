package com.example.geektrust.concreate;

import java.util.HashMap;
import java.util.TreeMap;

import com.example.geektrust.exceptions.CourseFullException;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.service.CommandExecutor;

public class LMS {

    private final String name;
    private final TreeMap courses;
    private final HashMap registrationIdCourseMap;

    public LMS(String name) {
        this.name = name;
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
    }

    public void fulfillCommand(Command command) throws InvalidInputException {

         CommandExecutor commandExecutor = CommandExecution.getExecutor(command);

        try{
            commandExecutor.executeCommand(courses,registrationIdCourseMap, command);
        }catch(CourseFullException e ){
            System.out.println(e.getMessage());
        }
    }
    
}
