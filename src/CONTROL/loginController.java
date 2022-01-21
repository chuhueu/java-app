/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

/**
 *
 * @author chuhu
 */
import MODEL.loginModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginController {

    public ResultSet Login(loginModel login) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM user WHERE username=? and password=?";
            connectDB connCtr = new connectDB();
            con = connCtr.run();
            ps = con.prepareStatement(sql);
            ps.setString(1, login.getUsername());
            ps.setString(2, login.getPassword());
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet getInfoUser(String username) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT user.manv, username,role, position, maphong, mahoso FROM user, employee "
                    + "WHERE user.manv = employee.manv and username='"+username+"'";
            connectDB connCtr = new connectDB();
            conn = connCtr.run();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet getUser(String username) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM user WHERE username='"+username+"'";
            connectDB connCtr = new connectDB();
            conn = connCtr.run();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}
