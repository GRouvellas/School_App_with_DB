/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.StudentsPCourse;

/**
 *
 * @author Geo
 */
public interface StudentsPCourseDao {
    
    public void insertStudentsPCourse(StudentsPCourse createStudentsPCourse);
    
    public void allStudentsPCourse();
    
    public void StudentsInCourses();
    
    public StudentsPCourse createStudentsPCourse();
        
    
}
