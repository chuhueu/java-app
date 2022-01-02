/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chuhu
 */
public class connectDB {
    private Connection con =null;
    private static String USERNAME = "root";
    private static String PASSWORD = "";
    private static String DB_URL = "jdbc:mysql://localhost:3306/test-java" ;
    
    public Connection run(){
        try {
            con = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            System.out.println("from long");
        } catch (SQLException ex) {
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
