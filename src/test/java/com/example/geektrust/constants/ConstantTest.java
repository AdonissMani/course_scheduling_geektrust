package com.example.geektrust.constants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class ConstantTest {
    @Test
    public void testGetValue(){
        assertEquals("ADD_COURSE_OFFERING",Constants.getValue("ADD-COURSE-OFFERING") );
        assertNotEquals("ALLOT-COURSE",Constants.getValue("ALLOT-COURSE"));
        assertEquals("ACCEPTED",Constants.ACCEPTED);
    }
}
