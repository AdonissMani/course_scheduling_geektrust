package com.example.geektrust.service.implementation;

import static com.example.geektrust.constants.Constants.REJECTED;
import static com.example.geektrust.constants.Constants.ACCEPTED;

import java.util.Map;
import java.util.TreeMap;

import com.example.geektrust.exceptions.CourseFullException;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.CourseOffering;
import com.example.geektrust.model.Employee;
import com.example.geektrust.service.CommandExecutor;

public class RegisterForCourse implements CommandExecutor {

    @Override
    public void executeCommand(TreeMap<String, CourseOffering> courses,
            Map<String, CourseOffering> registrationIdCourseMap, Command command)
            throws InvalidInputException, CourseFullException {
        
        String courseID = command.getCommandParams().get(1);
        Employee employee = ConstructEmployeeObject(command);
        if(courses.containsKey(courseID)){
            CourseOffering course = courses.get(courseID);
            if(!courses.get(courseID).isAllotted() || courses.get(courseID).isCancelled()){
                if(course.getRegisteredEmployees().size()==course.getMaxEmployees()){
                    throw new CourseFullException("COURSE_FULL_ERROR");
                }else{
                    //register the employee to course......
                    registerEmployeeToCourse(employee , course ,registrationIdCourseMap);
                }
            }else{
                //In case of course is allotted already
                System.out.println("REG-COURSE-"+employee.getName()+"-"+courses.get(courseID).getCourseTitle()+" "+ REJECTED);
            }
        }else{
            //In case of course ID is not present in the course offering list.
            System.out.println("INPUT_DATA_ERROR");
        }
        
    }

    private void registerEmployeeToCourse(Employee employee, CourseOffering course,
            Map<String, CourseOffering> registrationIdCourseMap) {

                String regID = course.addEmployee(employee);
                registrationIdCourseMap.put(regID , course);
                System.out.println(regID+" "+ACCEPTED);
    }

    private Employee ConstructEmployeeObject(Command command) throws InvalidInputException {
        return new Employee(command.getCommandParams().get(0));
    }
    
}
