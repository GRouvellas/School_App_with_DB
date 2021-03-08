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
import utils.Checks;
import model.Student;
import utils.DbUtils;

/**
 *
 * @author Geo
 */
public class StudentDaoImpl implements StudentDao {

    private Connection con = null;
    
    //connects with the database and inserts the fields of a Student object
    // one by one through a prepared statement, in a new line of the table
    //indicated in the sql query
    @Override
    public void insertStudent(Student createStudent) {
        String sql = "INSERT INTO students (firstName, lastName, dateOfBirth, tuitionFees) Values(?,?,?,?)";
        PreparedStatement ps = null;
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, createStudent.getFirstName());
            ps.setString(2, createStudent.getLastName());
            ps.setDate(3, createStudent.getDateOfBirth());
            ps.setFloat(4, createStudent.getTuitionFees());
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
    public void allStudents() {
        Statement st = null;
        ResultSet rs = null;
        String query = "SELECT * FROM students";
        try {
            con = DbUtils.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("studentID");
                String name = rs.getString("firstName");
                String surname = rs.getString("lastName");
                Date date = rs.getDate("dateOfBirth");
                float fee = rs.getFloat("tuitionFees");
                System.out.println(id + " " + name + " " + surname + " " + date + " " + fee);
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
    
    //creates a new Student object and asks the user for the values of its fields
    @Override
    public Student createStudent() {
        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("Add First Name");
        student.setFirstName(sc.nextLine());
        System.out.println("Add Last Name");
        student.setLastName(sc.nextLine());
        System.out.println("Add Date of Birth (yyyy-MM-dd)");
        student.setDateOfBirth(Date.valueOf(LocalDate.parse(Checks.dateCheck(sc.nextLine()))));
        System.out.println("Add Tuition Fees");
        student.setTuitionFees(Float.parseFloat(Checks.floatCheck(sc.nextLine())));
        return student;            
    }

    
}
