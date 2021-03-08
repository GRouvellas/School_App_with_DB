/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Student;

/**
 *
 * @author Geo
 */
public interface StudentDao {
    
    public void insertStudent(Student s);
       
    public void allStudents();
    
    public Student createStudent();
    
}
