/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Geo
 */
public class Student {

    //fields
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private float tuitionFees;

    //constructor simple
    public Student() {
    }

    //constructor
    public Student(String firstName, String lastName, Date dateOfBirth, float tuitionFees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
    }

    //getter
    public String getFirstName() {
        return firstName;
    }

    //setter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //getter
    public String getLastName() {
        return lastName;
    }

    //setter
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //getter
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    //setter
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    //getter
    public float getTuitionFees() {
        return tuitionFees;
    }

    //setter
    public void setTuitionFees(float tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    @Override
    public String toString() {
        return "Student{" + "firstName=" + firstName + ", lastName=" + lastName
                + ", dateOfBirth=" + dateOfBirth + ", tuitionFees=" + tuitionFees + '}';
    }

}
