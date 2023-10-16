package com.example.geektrust.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.model.CommandOperator;

public class CommandOperationsTest {
     Integer registerValue;
    Integer courseOfferingValue;

    @BeforeEach
    public void setup(){
        registerValue = 2;
        courseOfferingValue = 5;
    }
    @Test
    public void testGetNumberOfArguments() {
        assertEquals(Optional.of(CommandOperator.REGISTER.getNumberOfArguments()).get(),registerValue);
        assertEquals(Optional.of(CommandOperator.ADD_COURSE_OFFERING.getNumberOfArguments()).get(),courseOfferingValue);
    }
}
