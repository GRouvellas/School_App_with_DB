/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;
import model.Assignment;
import utils.Checks;
import utils.DbUtils;

/**
 *
 * @author Geo
 */
public class AssignmentDaoImpl implements AssignmentDao {

    private Connection con = null;
    
    //connects with the database and inserts the fields of an Assignment object
    // one by one through a prepared statement, in a new line of the table
    //indicated in the sql query
    @Override
    public void insertAssignment(Assignment createAssignment) {
        String sql = "INSERT INTO assignments (title, description, subDateTime, "
                + "oralMark, totalMark) Values(?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, createAssignment.getTitle());
            ps.setString(2, createAssignment.getDescription());
            ps.setDate(3, createAssignment.getSubDateTime());
            ps.setInt(4, createAssignment.getOralMark());
            ps.setInt(5, createAssignment.getTotalMark());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    //connects with the database and runs the statement(query) in mysql. Prints the 
    //results of the result set line by line
    @Override
    public void allAssignments() {
        Statement st = null;
        ResultSet rs = null;
        String query = "SELECT * FROM assignments";
        try {
            con = DbUtils.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("assignmentID");
                String title = rs.getString("title");
                String description = rs.getString("description");
                Date date = rs.getDate("subDateTime");
                int oralMark = rs.getInt("oralMark");
                int totalMark = rs.getInt("totalMark");
                System.out.println(id + " " + title + " " + description + " " + date + " " + oralMark + " " + totalMark);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            try {
                rs.close();
                st.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    //creates a new Assignment object and asks the user for the values of its fields    
    @Override
    public Assignment createAssignment() {
        Assignment assignment = new Assignment();
        Scanner sc = new Scanner(System.in);
        System.out.println("Add title");
        assignment.setTitle(sc.nextLine());
        System.out.println("Add description");
        assignment.setDescription(sc.nextLine());        
        System.out.println("Add subDateTime");
        assignment.setSubDateTime(Date.valueOf(LocalDate.parse(Checks.dateCheck(sc.nextLine()))));
        System.out.println("oralMark");
        assignment.setOralMark(Integer.parseInt(Checks.integerCheck(sc.nextLine())));
        System.out.println("totalMark");
        assignment.setTotalMark(Integer.parseInt(Checks.integerCheck(sc.nextLine())));
        return assignment;
    }
    
    
}


