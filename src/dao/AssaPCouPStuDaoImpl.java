/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import utils.DbUtils;

/**
 *
 * @author Geo
 */
public class AssaPCouPStuDaoImpl implements AssaPCouPStuDao {

    private Connection con = null;

    //Unlike the insert methods in the other DAO classes, in this one we do not have
    // a model class so as to actually create the object that we will insert. What we
    // do instead is to make sure that the StudentsPCourse and AssignmentsPCourse
    // objects exist in the corresponding tables. If not we run the methods that 
    //create and insert them. This procedure produces a somewhat equivalent result,
    // (as far as the user is concerned) since when running the allAssaPCouPStu 
    //method, all the entries of assignments per student per course will appear in
    // a similar manner as if such a table acually existed.
    @Override
    public void insertAssaPCouPStu(){
        Scanner sc = new Scanner(System.in);
        String reply;
        StudentsPCourseDao spc = new StudentsPCourseDaoImpl();
        AssignmentsPCourseDao apc = new AssignmentsPCourseDaoImpl();
        System.out.println("Is the Student already connected with the Course (y/n)?"
                + " (if \"n\" you will be prompted to connect it) ");
        reply = sc.nextLine();        
        if (reply.trim().equalsIgnoreCase("n")){
            spc.insertStudentsPCourse(spc.createStudentsPCourse());
        }
        System.out.println("Student inserted in a Course");
        System.out.println("Is the Assignment already connected with the Course (y/n)?"
                + " (if \"n\" you will be prompted to connect it) ");
        reply = sc.nextLine();        
        if (reply.trim().equalsIgnoreCase("n")){
            apc.insertAssignmentsPCourse(apc.createAssignmentsPCourse());            
        }
        System.out.println("Assignment inserted in a Course");        
    }
    
    //connects with the database and runs the statement(query) in mysql. Prints the 
    //results of the result set line by line
    @Override
    public void allAssaPCouPStu() {
        Statement st = null;
        ResultSet rs = null;
        String query = "SELECT firstName,\n"
                + "       lastName,\n"
                + "       dateOfBirth,\n"
                + "       tuitionFees,\n"
                + "	   courses.title,\n"
                + "       stream,\n"
                + "       type,\n"
                + "       start_date,\n"
                + "       end_date,\n"
                + "       assignments.title,\n"
                + "       description,\n"
                + "       subDateTime,\n"
                + "       oralMark,\n"
                + "       totalMark\n"
                + "FROM assignments, courses_has_assignments, courses, courses_has_students, students\n"
                + "WHERE assignmentID = Assignments_assignmentID\n"
                + "AND courseID = courses_has_assignments.Courses_courseID\n"
                + "AND courseID = courses_has_students.Courses_courseID\n"
                + "AND studentID = Students_studentID\n"
                + "ORDER BY studentID, courseID, assignmentID";
        try {
            con = DbUtils.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");                
                Date dateOfBirth = rs.getDate("dateOfBirth");
                float tuitionFees = rs.getFloat("tuitionFees");
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
                System.out.println(firstName + " " + lastName + " " + dateOfBirth + " " + tuitionFees + " " + cotitle 
                        + " " + stream + " " + type + " " + start_date + " " + end_date
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

}


