package com.example.geektrust.service.implementation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TreeMap;

import com.example.geektrust.exceptions.CourseFullException;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.CourseOffering;
import com.example.geektrust.model.Employee;
import com.example.geektrust.service.CommandExecutor;

public class AllotCourse implements CommandExecutor {

    @Override
    public void executeCommand(TreeMap<String, CourseOffering> courses,
            Map<String, CourseOffering> registrationIdCourseMap, Command command)
            throws InvalidInputException, CourseFullException {
                String courseId = command.getCommandParams().get(0);
                CourseOffering course = courses.get(courseId);
                if(course!=null){
                    if(course.getRegisteredEmployees().size()<course.getMinEmployees()){
                        course.setCancelled(true);
                        printCourseData(course);
                    }else{
                        course.setAllotted(true);
                        printCourseData(course);
                    }
                }else{
                    throw new InvalidInputException("INPUT_DATA_ERROR");
                }
        
    }

    private void printCourseData(CourseOffering course) {
        String status = course.isCancelled()?"COURSE_CANCELED":"CONFIRMED";
        for(Map.Entry<String,Employee> e: course.getRegisteredEmployees().entrySet()){
            String pattern = "ddMMyyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            System.out.println(e.getKey()+" "+e.getValue().getEmail()+" "+course.getCourseOfferingId()+" "+course.getCourseTitle()+" "+course.getInstructor()+" "
                   + df.format(course.getDate())+" "+status);
    }
}
    
}
