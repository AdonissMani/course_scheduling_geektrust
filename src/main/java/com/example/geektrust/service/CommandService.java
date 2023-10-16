package com.example.geektrust.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.CommandOperator;

public class CommandService {

    static CommandService commandService = null;
    public static Command get;
    public static Object getInstance() {
        
        if(commandService==null){
            commandService = new CommandService();
        }
        return commandService;
    }
    public Command getCommandFromString(String input) throws InvalidInputException{
        try {
             String[] commandWithArguments = input.split(" ");
            CommandOperator operator = CommandOperator.valueOf(Constants.getValue(commandWithArguments[0]));
            List<String> commandParams =
                    Arrays.stream(commandWithArguments).skip(1).collect(Collectors.toList());
            Command command = new Command(operator, commandParams);
            this.validateInputCommand(operator,command);
            return command;
        } catch (Exception e) {
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }
    private void validateInputCommand(CommandOperator operator, Command command) throws InvalidInputException {
        if(operator.getNumberOfArguments()!=command.getCommandParams().size()){
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }
    
}
