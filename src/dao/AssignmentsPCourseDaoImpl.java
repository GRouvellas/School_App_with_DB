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
import java.util.Scanner;
import model.AssignmentsPCourse;
import utils.Checks;
import utils.DbUtils;

/**
 *
 * @author Geo
 */
public class AssignmentsPCourseDaoImpl implements AssignmentsPCourseDao {

    private Connection con = null;

    //connects with the database and inserts the fields of an AssignmentsPCourse object
    // one by one through a prepared statement, in a new line of the table
    //indicated in the sql query        
    @Override
    public void insertAssignmentsPCourse(AssignmentsPCourse createAssignmentsPCourse){
        String sql = "INSERT INTO courses_has_assignments (Courses_courseID, Assignments_assignmentID) Values(?,?)";
        PreparedStatement ps = null;
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, createAssignmentsPCourse.getCourses_courseID());
            ps.setInt(2, createAssignmentsPCourse.getAssignments_assignmentID());            
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
    public void allAssignmentsPCourse() {
        Statement st = null;
        ResultSet rs = null;
        String query = "SELECT courses.title,\n"
                + "       stream,\n"
                + "       type,\n"
                + "       start_date,\n"
                + "       end_date,\n"
                + "       assignments.title,\n"
                + "       description,\n"
                + "       subDateTime,\n"
                + "       oralMark,\n"
                + "       totalMark\n"
                + "FROM courses,courses_has_assignments,assignments\n"
                + "WHERE courseID=Courses_courseID\n"
                + "AND assignmentID=Assignments_assignmentID\n"
                + "ORDER BY courseID, assignmentID";
        try {
            con = DbUtils.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String cotitle = rs.getString("courses.title");
                String stream = rs.getString("stream");
                String type = rs.getString("type");
                Date start_date = rs.getDate("start_date");
                Date end_date = rs.getDate("end_date");
                String astitle = rs.getString("assignments.title");
                String description = rs.getString("description");
                Date date = rs.getDate("subDateTime");
                int oralMark = rs.getInt("oralMark");
                int totalMark = rs.getInt("totalMark");
                System.out.println(cotitle + " " + stream + " " + type + " " + start_date + " " + end_date
                        + " " + astitle + " " + description + " " + date + " " + oralMark + " " + totalMark);
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

    //creates a new AssignmentsPCourse object and asks the user for the values of its fields        
    @Override
        public AssignmentsPCourse createAssignmentsPCourse() {
        AssignmentsPCourse apc = new AssignmentsPCourse();
        Scanner sc = new Scanner(System.in);
        System.out.println("Add courseID");
        apc.setCourses_courseID(Integer.parseInt(Checks.integerCheck(sc.nextLine())));
        System.out.println("Add assignmentID");
        apc.setAssignments_assignmentID(Integer.parseInt(Checks.integerCheck(sc.nextLine())));
        return apc;
    }

}
