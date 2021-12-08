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
}
