package com.example.geektrust;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.example.geektrust.concreate.LMS;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.service.FileProcessingService;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new FileNotFoundException("Input file is not supplied");
            } else {
                LMS lms = new LMS("Adoniss");
                FileProcessingService fileProcesserService = new FileProcessingService(args[0]);
                try {
                    try {
                        Command command = fileProcesserService.processLine();
                        while (command != null) {
                            lms.fulfillCommand(command);
                            command = fileProcesserService.processLine();
                        }
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
