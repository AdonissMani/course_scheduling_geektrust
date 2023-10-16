package com.example.geektrust.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.model.Command;

public class FileProcessingService {
    private String inputFilePath;
    private final BufferedReader bufferedReader;
    private final File file;

    public FileProcessingService(String inputFilePath) throws  FileNotFoundException  {
        file = new File(inputFilePath);
        bufferedReader = new BufferedReader(new FileReader(file));
    }

    public Command processLine() throws InvalidInputException, IOException{
        String input = bufferedReader.readLine();
        if(input == null)
        {
            return null;
        }

        if(isEmpty(input)){
            processLine();
        }
        
        try {
            return ((CommandService) CommandService.getInstance()).getCommandFromString(input);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            return processLine();
        }
        
    }

    private boolean isEmpty(String line) {
        return line==null || line.length()==0 || line.trim().isEmpty() || line.trim().startsWith("#");
    }

}
