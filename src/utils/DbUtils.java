/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Geo
 */
public class DbUtils {
    
     public static final String MYSQLURL = "jdbc:mysql://localhost:3306/individual_part_b?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode"
            + "=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval"
            + "=true&useSSL=false";
    
    //connects with "individual_part_b" schema in mysql with username "user" and an empty String as password
     public static Connection getConnection() throws SQLException{
        Connection con;
        con = DriverManager.getConnection(MYSQLURL, "user", "");
        return con;
          
    }
}
