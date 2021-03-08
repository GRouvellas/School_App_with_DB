/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import model.Trainer;
import utils.DbUtils;

/**
 *
 * @author Geo
 */
public class TrainerDaoImpl implements TrainerDao {

    private Connection con = null;
    
    //connects with the database and inserts the fields of a Trainer object
    // one by one through a prepared statement, in a new line of the table
    //indicated in the sql query
    @Override
    public void insertTrainer(Trainer createTrainer) {
        String sql = "INSERT INTO trainers (firstName, lastName, subject) Values(?,?,?)";
        PreparedStatement ps = null;
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, createTrainer.getFirstName());
            ps.setString(2, createTrainer.getLastName());
            ps.setString(3, createTrainer.getSubject());
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
    public void allTrainers() {
        Statement st = null;
        ResultSet rs = null;
        String query = "SELECT * FROM trainers";
        try {
            con = DbUtils.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("trainerID");
                String name = rs.getString("firstName");
                String surname = rs.getString("lastName");
                String subject = rs.getString("subject");
                System.out.println(id + " " + name + " " + surname + " " + subject);
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
    
    //creates a new Trainer object and asks the user for the values of its fields    
    @Override
    public Trainer createTrainer() {
        Trainer trainer = new Trainer();
        Scanner sc = new Scanner(System.in);
        System.out.println("Add First Name");
        trainer.setFirstName(sc.nextLine());
        System.out.println("Add Last Name");
        trainer.setLastName(sc.nextLine());
        System.out.println("Add subject");
        trainer.setSubject(sc.nextLine());
        return trainer;
    }

}
