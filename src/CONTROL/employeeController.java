package CONTROL;


import CONTROL.connectDB;
import MODEL.departmentModel;
import MODEL.employeeModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chuhu
 */
public class employeeController {
    public static List<employeeModel> getUserByMaPhong(String maphong) {
        List<employeeModel> List = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        try {
            //get all info room
            connectDB connect = new connectDB();
            conn = connect.run();
            //query
            String sql = "SELECT manv, fullname, sex, birthday, address, position, epl.maphong, mahoso from employee epl, department dp "
                    + "WHERE epl.maphong=dp.maphong and epl.maphong='"+maphong+"' ";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                employeeModel nv = new employeeModel();
                nv.setManv(rs.getString("manv"));
                nv.setFullname(rs.getString("fullname"));
                nv.setSex(rs.getString("sex"));
                nv.setBirthday(rs.getString("birthday"));
                nv.setAddress(rs.getString("address"));
                nv.setPosition(rs.getString("position"));
                nv.setMaphong(rs.getString("maphong"));
                nv.setMahoso(rs.getString("mahoso"));
                List.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        return List;
    }
}
