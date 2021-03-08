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
public class TrainersPCourse {
    
    //fields
    private int Courses_courseID;
    private int Trainers_trainerID;

    //construcotr
    public TrainersPCourse(int Courses_courseID, int Trainers_trainerID) {
        this.Courses_courseID = Courses_courseID;
        this.Trainers_trainerID = Trainers_trainerID;
    }

    //constructor simple
    public TrainersPCourse() {
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
    public int getTrainers_trainerID() {
        return Trainers_trainerID;
    }

    //setter
    public void setTrainers_trainerID(int Trainers_trainerID) {
        this.Trainers_trainerID = Trainers_trainerID;
    }
    
        
}
