/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Geo
 */
public class AssignmentsPCourse {
    
    //fields
    private int Courses_courseID;
    private int Assignments_assignmentID;

    //constructor
    public AssignmentsPCourse(int Courses_courseID, int Assignments_assignmentID) {
        this.Courses_courseID = Courses_courseID;
        this.Assignments_assignmentID = Assignments_assignmentID;
    }

    //constructor simple
    public AssignmentsPCourse() {
    }

    //getter
    public int getCourses_courseID() {
        return Courses_courseID;
    }

    //setter
    public void setCourses_courseID(int Courses_courseID) {
        this.Courses_courseID = Courses_courseID;
    }

    //getter
    public int getAssignments_assignmentID() {
        return Assignments_assignmentID;
    }

    //setter
    public void setAssignments_assignmentID(int Assignments_assignmentID) {
        this.Assignments_assignmentID = Assignments_assignmentID;
    }
    
        
}
