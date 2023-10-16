package com.example.geektrust.model;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.exceptions.InvalidInputException;

public class Employee implements Comparable<Employee>{
    private String email;
    private String courseRegistrationId;
    private String employeeName;
    private String courseName;

    public Employee(String email) throws InvalidInputException {
       if (Constants.VALID_EMAIL_ADDRESS_REGEX.matcher(email).matches()) {
            this.email = email;
            this.employeeName = this.email.substring(0, this.email.indexOf('@'));
        } else {
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }

    public String getEmail() {
        return email;
    }

    public String getCourseRegistrationId() {
        return courseRegistrationId;
    }

    public String getName() {
        return employeeName;
    }

    @Override
    public int compareTo(Employee other) {
        return this.courseRegistrationId.compareTo(other.courseRegistrationId);
    }
}
