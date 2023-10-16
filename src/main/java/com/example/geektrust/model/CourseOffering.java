package com.example.geektrust.model;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class CourseOffering {
    private String courseTitle;
    private String instructor;
    private Date date;
    private int minEmployees;
    private int maxEmployees;
    private final  Map<String , Employee> registeredEmployees;
    private String courseStatus;
    public String courseOfferingId;
    private boolean isAllotted;
    private boolean isCancelled;

    public CourseOffering(String courseOfferingId, String courseTitle, String instructor, Date d, int minEmployees, int maxEmployees, boolean isAllotted, boolean isCancelled) {
        this.courseOfferingId = courseOfferingId;
        this.courseTitle = courseTitle;
        this.instructor = instructor;
        this.date = d;
        this.minEmployees = minEmployees;
        this.maxEmployees = maxEmployees;
        this.isAllotted = isAllotted;
        this.isCancelled = isCancelled;
        this.registeredEmployees = new TreeMap<>();
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMinEmployees() {
        return minEmployees;
    }

    public void setMinEmployees(int minEmployees) {
        this.minEmployees = minEmployees;
    }

    public int getMaxEmployees() {
        return maxEmployees;
    }

    public void setMaxEmployees(int maxEmployees) {
        this.maxEmployees = maxEmployees;
    }

    public  Map<String , Employee> getRegisteredEmployees() {
        return registeredEmployees;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public String getCourseOfferingId() {
        return courseOfferingId;
    }

    public void setCourseOfferingId(String courseOfferingId) {
        this.courseOfferingId = courseOfferingId;
    }

    public boolean isAllotted() {
        return isAllotted;
    }

    public void setAllotted(boolean isAllotted) {
        this.isAllotted = isAllotted;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    public String addEmployee(Employee e){
        String registrationID = "REG-COURSE-"+e.getName()+"-"+this.courseTitle;
        this.registeredEmployees.put(registrationID , e);
        return registrationID;
    }

    public int compareTo(CourseOffering courseOffering) {
        return courseOffering.courseTitle.compareTo(courseTitle);
    }
}
