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
public class Trainer {

    //fields
    private String firstName;
    private String lastName;
    private String subject;

    //constructor simple
    public Trainer() {
    }

    //constructor
    public Trainer(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
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
    public String getSubject() {
        return subject;
    }

    //setter
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Trainer{" + "firstName=" + firstName + ", lastName=" + lastName
                + ", subject=" + subject + '}';
    }

}
