package com.example.geektrust.service.implementation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.example.geektrust.exceptions.CourseFullException;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.CourseOffering;
import com.example.geektrust.service.CommandExecutor;

public class AddCourse implements CommandExecutor {

    @Override
    public void executeCommand(TreeMap<String, CourseOffering> courses,
            Map<String, CourseOffering> registrationIdCourseMap, Command command)
            throws InvalidInputException, CourseFullException {

                List <String> commandParams = command.getCommandParams();
                CourseOffering courseOffering = constructCourseObject(commandParams); 
                offerCourse(courses, courseOffering);
        
    }

    private CourseOffering constructCourseObject(List<String> commandParams) throws InvalidInputException {
        CourseOffering course = null;
        try {
            String courseName = commandParams.get(0);
            String courseInstructor = commandParams.get(1);
            SimpleDateFormat inputFormat = new SimpleDateFormat("ddMMyyyy");
            Date d = inputFormat.parse(commandParams.get(2));
            int minCount = Integer.parseInt(commandParams.get(3));
            int maxCount = Integer.parseInt(commandParams.get(4));
            course = new CourseOffering("OFFERING-"+courseName+"-"+courseInstructor,courseName , courseInstructor , d ,minCount , maxCount , false, false);


        } catch (Exception e) {
            // TODO: handle exception
            throw new InvalidInputException("INPUT_ERROR");
        }
        return course;
    }
    private void offerCourse(TreeMap<String, CourseOffering> courses, CourseOffering course){
        courses.put(course.getCourseOfferingId(),course);
        System.out.println(course.getCourseOfferingId());
    }
}
