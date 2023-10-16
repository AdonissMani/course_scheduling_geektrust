package com.example.geektrust.service.implementation;
import static com.example.geektrust.constants.Constants.CANCEL_ACCEPTED;
import static com.example.geektrust.constants.Constants.CANCEL_REJECTED;
import java.util.Map;
import java.util.TreeMap;

import com.example.geektrust.exceptions.CourseFullException;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.CourseOffering;
import com.example.geektrust.service.CommandExecutor;

public class CancelCourse implements CommandExecutor {

    @Override
    public void executeCommand(TreeMap<String, CourseOffering> courses,
            Map<String, CourseOffering> registrationIdCourseMap, Command command)
            throws InvalidInputException, CourseFullException {
        // TODO Auto-generated method stub
        String regId = command.getCommandParams().get(0);
        if(isValidRegistrationID(regId,registrationIdCourseMap)){
            if(isCourseNotAllotted(regId,registrationIdCourseMap)){
                System.out.println(regId+" "+CANCEL_REJECTED);
            }else{
                //Remove the registration for the employee...
                removeRegisteredEmployee(regId,registrationIdCourseMap);
                System.out.println(regId+" "+CANCEL_ACCEPTED);
            }
        }else{
            System.out.println(regId+" "+CANCEL_REJECTED);
        }
        
    }

    private void removeRegisteredEmployee(String regId, Map<String, CourseOffering> registrationIdCourseMap) {
        CourseOffering course = registrationIdCourseMap.get(regId);
        course.getRegisteredEmployees().remove(regId);
        registrationIdCourseMap.remove(regId);
    }

    private boolean isCourseNotAllotted(String regId, Map<String, CourseOffering> registrationIdCourseMap) {
        return registrationIdCourseMap.get(regId).isAllotted();
    }

    private boolean isValidRegistrationID(String regId, Map<String, CourseOffering> registrationIdCourseMap) {
        if(registrationIdCourseMap.get(regId)!=null){
            return true;
        }else{
            return false;
        }
    }
    
}
