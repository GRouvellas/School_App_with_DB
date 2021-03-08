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
import model.TrainersPCourse;
import utils.Checks;
import utils.DbUtils;

/**
 *
 * @author Geo
 */
public class TrainersPCourseDaoImpl implements TrainersPCourseDao {
    
    private Connection con = null;

    //connects with the database and inserts the fields of a TrainersPCourse object
    // one by one through a prepared statement, in a new line of the table
    //indicated in the sql query    
    @Override
     public void insertTrainersPCourse(TrainersPCourse createTrainersPCourse){
        String sql = "INSERT INTO courses_has_trainers (Courses_courseID, Trainers_trainerID) Values(?,?)";
        PreparedStatement ps = null;
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, createTrainersPCourse.getCourses_courseID());
            ps.setInt(2, createTrainersPCourse.getTrainers_trainerID());            
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
    public void allTrainersPCourse() {
        Statement st = null;
        ResultSet rs = null;
        String query = "SELECT title,\n"
                + "       stream,\n"
                + "       type,\n"
                + "       start_date,\n"
                + "       end_date,\n"
                + "       firstName,\n"
                + "       lastName,\n"
                + "       subject \n"                
                + "FROM courses,courses_has_trainers,trainers\n"
                + "WHERE courseID=Courses_courseID\n"
                + "AND trainerID=Trainers_trainerID\n"
                + "ORDER BY courseID, trainerID";
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
                String subject = rs.getString("subject");                
                System.out.println(title + " " + stream + " " + type + " " + start_date + " " + end_date
                        + " " + name + " " + surname + " " + subject);
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

    //creates a new TrainersPCourse object and asks the user for the values of its fields        
     public TrainersPCourse createTrainersPCourse() {
        TrainersPCourse tpc = new TrainersPCourse();
        Scanner sc = new Scanner(System.in);
        System.out.println("Add courseID");
        tpc.setCourses_courseID(Integer.parseInt(Checks.integerCheck(sc.nextLine())));
        System.out.println("Add trainerID");
        tpc.setTrainers_trainerID(Integer.parseInt(Checks.integerCheck(sc.nextLine())));
        return tpc;
    }

    
}
