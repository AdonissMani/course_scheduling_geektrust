package com.example.geektrust.service;

import java.util.Map;
import java.util.TreeMap;

import com.example.geektrust.exceptions.CourseFullException;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.CourseOffering;

public interface CommandExecutor {
    void executeCommand(TreeMap<String,CourseOffering > courses, Map<String, CourseOffering> registrationIdCourseMap, Command command) throws InvalidInputException, CourseFullException;
}

