/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import MODEL.departmentModel;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chuhu
 */
public class departmentController {
    public static void addRoom(departmentModel room){
        
    }
    public static List<departmentModel> getRoom() {
        List<departmentModel> List = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        try {
            //get all info room
            connectDB connect = new connectDB();
            conn = connect.run();
            //query
            String sql = "SELECT * from department";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                departmentModel room = new departmentModel();
                room.setMaphong(rs.getString("maphong"));
                room.setTenphong(rs.getString("tenphong"));
                room.setLeader(rs.getString("leader"));
                List.add(room);
            }
        } catch (Exception e) {
            System.out.println(e);
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
