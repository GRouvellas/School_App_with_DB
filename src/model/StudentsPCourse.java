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
public class StudentsPCourse {

    //fields
    private int Courses_courseID;
    private int Students_studentID;

    //constructor
    public StudentsPCourse(int Courses_courseID, int Students_studentID) {
        this.Courses_courseID = Courses_courseID;
        this.Students_studentID = Students_studentID;
    }

    //constructor simple
    public StudentsPCourse() {
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
    public int getStudents_studentID() {
        return Students_studentID;
    }

    //setter
    public void setStudents_studentID(int Students_studentID) {
        this.Students_studentID = Students_studentID;
    }
    

}
