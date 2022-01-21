/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import MODEL.employeeModel;
import MODEL.profileModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author chuhu
 */
public class profileController {
    public ResultSet getProfileByMahs(String mahoso) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT pf.mahoso, pf.fullname, CCCD, pf.address, dayin, dayout, salary from employee epl, profile pf "
                    + "WHERE epl.mahoso=pf.mahoso and epl.mahoso='"+mahoso+"'";
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
