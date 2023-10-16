package com.example.geektrust.concreate;

import com.example.geektrust.model.Command;
import com.example.geektrust.service.CommandExecutor;
import com.example.geektrust.service.implementation.AddCourse;
import com.example.geektrust.service.implementation.AllotCourse;
import com.example.geektrust.service.implementation.CancelCourse;
import com.example.geektrust.service.implementation.RegisterForCourse;

public class CommandExecution {

    public static CommandExecutor getExecutor(Command command) {
        CommandExecutor executor = null;
        if(command!=null){
            switch(command.getInputCommand()){
                case ADD_COURSE_OFFERING:
                    executor = new AddCourse();
                    break;
                case CANCEL:
                    executor = new CancelCourse();
                    break;
                case ALLOT:
                    executor = new AllotCourse();
                    break;
                case REGISTER:
                    executor = new RegisterForCourse();
                    break;
                default:
                    break;
            }
        
    }
            return executor;

    
}
}
