/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Course;

/**
 *
 * @author Geo
 */
public interface CourseDao {
    
    public void insertCourse(Course c);
    
    public void allCourses();
    
    public Course createCourse();
    
}
