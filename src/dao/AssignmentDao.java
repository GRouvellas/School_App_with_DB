/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Assignment;

/**
 *
 * @author Geo
 */
public interface AssignmentDao {
    
    public void insertAssignment(Assignment a);
       
    public void allAssignments();
    
    public Assignment createAssignment();
    
}
