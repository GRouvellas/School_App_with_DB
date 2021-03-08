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
import model.StudentsPCourse;
import utils.Checks;
import utils.DbUtils;

/**
 *
 * @author Geo
 */
public class StudentsPCourseDaoImpl implements StudentsPCourseDao {

    private Connection con = null;

    //connects with the database and inserts the fields of a StudentsPCourse object
    // one by one through a prepared statement, in a new line of the table
    //indicated in the sql query            
    @Override
    public void insertStudentsPCourse(StudentsPCourse createStudentsPCourse){
        String sql = "INSERT INTO courses_has_students (Courses_courseID, Students_studentID) Values(?,?)";
        PreparedStatement ps = null;
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, createStudentsPCourse.getCourses_courseID());
            ps.setInt(2, createStudentsPCourse.getStudents_studentID());            
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
    public void allStudentsPCourse() {
        Statement st = null;
        ResultSet rs = null;
        String query = "SELECT title,\n"
                + "       stream,\n"
                + "       type,\n"
                + "       start_date,\n"
                + "       end_date,\n"
                + "       firstName,\n"
                + "       lastName,\n"
                + "       dateOfBirth,\n"
                + "       tuitionFees\n"
                + "FROM courses,courses_has_students,students\n"
                + "WHERE courseID=Courses_courseID\n"
                + "AND studentID=Students_studentID\n"
                + "ORDER BY courseID, studentID";
        try {
            con = DbUtils.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String title = rs.getString("title");
                String stream = rs.getString("stream");
                String type = rs.getString("type");
                Date start_date = rs.getDate("start_date");
                Date end_date = rs.getDate("end_date");
                String name = rs.getString("firstName");
                String surname = rs.getString("lastName");
                Date date = rs.getDate("dateOfBirth");
                float fee = rs.getFloat("tuitionFees");
                System.out.println(title + " " + stream + " " + type + " " + start_date + " " + end_date
                        + " " + name + " " + surname + " " + date + " " + fee);
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
    
    //connects with the database and runs the statement(query) in mysql. Prints the 
    //results of the result set line by line
    @Override
    public void StudentsInCourses() {
        Statement st = null;
        ResultSet rs = null;
        String query = "SELECT firstName,\n"
                + "       lastName,\n"
                + "       dateOfBirth,\n"
                + "       tuitionFees,\n"
                + "       count(*)\n"
                + "FROM courses_has_students,students\n"
                + "WHERE studentID=Students_studentID\n"
                + "GROUP BY Students_studentID\n"
                + "HAVING COUNT(*) > 1\n"
                + "ORDER BY studentID";
        try {
            con = DbUtils.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("firstName");
                String surname = rs.getString("lastName");
                Date date = rs.getDate("dateOfBirth");
                float fee = rs.getFloat("tuitionFees");
                int count = rs.getInt("count(*)");
                System.out.println(name + " " + surname + " " + date + " " + fee
                        + " " + count);
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
    
    //creates a new StudentsPCourse object and asks the user for the values of its fields       
    @Override
    public StudentsPCourse createStudentsPCourse() {
        StudentsPCourse spc = new StudentsPCourse();
        Scanner sc = new Scanner(System.in);
        System.out.println("Add courseID");
        spc.setCourses_courseID(Integer.parseInt(Checks.integerCheck(sc.nextLine())));
        System.out.println("Add studentID");
        spc.setStudents_studentID(Integer.parseInt(Checks.integerCheck(sc.nextLine())));
        return spc;
    }

    
}
