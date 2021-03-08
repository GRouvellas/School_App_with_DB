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
import model.Course;
import utils.Checks;
import utils.DbUtils;

/**
 *
 * @author Geo
 */
public class CourseDaoImpl implements CourseDao {

    private Connection con = null;
    
    //connects with the database and inserts the fields of a Course object
    // one by one through a prepared statement, in a new line of the table
    //indicated in the sql query
    @Override
    public void insertCourse(Course c) {
        String sql = "INSERT INTO courses (title, stream, type, start_date, end_date) Values(?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getTitle());
            ps.setString(2, c.getStream());
            ps.setString(3, c.getType());
            ps.setDate(4, c.getStart_date());
            ps.setDate(5, c.getEnd_date());
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
    public void allCourses() {
        Statement st = null;
        ResultSet rs = null;
        String query = "SELECT * FROM courses";
        try {
            con = DbUtils.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("courseID");
                String title = rs.getString("title");
                String stream = rs.getString("stream");
                String type = rs.getString("type");
                Date start_date = rs.getDate("start_date");
                Date end_date = rs.getDate("end_date");
                System.out.println(id + " " + title + " " + stream + " " + type + " " + start_date + " " + end_date);
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
    
    //creates a new Course object and asks the user for the values of its fields
    @Override
    public Course createCourse() {
        Course course = new Course();
        Scanner sc = new Scanner(System.in);
        System.out.println("Add title");
        course.setTitle(sc.nextLine());
        System.out.println("Add stream");
        course.setStream(sc.nextLine());
        System.out.println("Add type");
        course.setType(sc.nextLine());
        System.out.println("Add start_date");
        course.setStart_date(Date.valueOf(LocalDate.parse(Checks.dateCheck(sc.nextLine()))));
        System.out.println("Add end_date");
        course.setEnd_date(Date.valueOf(LocalDate.parse(Checks.dateCheck(sc.nextLine()))));
        return course;
    }
    
    
}
