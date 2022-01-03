/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import MODEL.departmentModel;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chuhu
 */
public class departmentController {
    public static List<departmentModel> getRoom() {
        List<departmentModel> List = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        try {
            //get all info room
            connectDB connect = new connectDB();
            conn = connect.run();
            //query
            String sql = "SELECT b.maphong, tenphong, leader, COUNT(a.manv) as count_nv FROM employee a, department b "
                    + "WHERE a.maphong = b.maphong GROUP BY b.maphong, tenphong, leader";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                departmentModel room = new departmentModel();
                room.setMaphong(rs.getString("maphong"));
                room.setTenphong(rs.getString("tenphong"));
                room.setLeader(rs.getString("leader"));
                room.setSoluong(rs.getInt("count_nv"));
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
    public static void addRoom(departmentModel room){
        Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       try {
            String sql = "INSERT INTO department VALUES(?,?,?)";
            connectDB connect = new connectDB();
            conn = connect.run();
            ps = conn.prepareStatement(sql);
            ps.setString(1, room.getMaphong());
            ps.setString(2, room.getTenphong());
            ps.setString(3, room.getLeader());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteRoom(String maphong) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "DELETE FROM department where maphong = ?";
            connectDB connect = new connectDB();
            conn = connect.run();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maphong);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateRoom(departmentModel room) {
       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
        try {
            String sql = "UPDATE department SET maphong=?, tenphong=?, leader=? WHERE maphong=?";
            connectDB connect = new connectDB();
            conn = connect.run();
            ps = conn.prepareStatement(sql);
            ps.setString(1, room.getMaphong());
            ps.setString(2, room.getTenphong());
            ps.setString(3, room.getLeader());
            ps.setString(4, room.getMaphong());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ResultSet getRoomByMaphong(String maphong) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM department WHERE maphong='"+maphong+"'";
            connectDB connCtr = new connectDB();
            conn = connCtr.run();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet getCountEmployee(String maphong) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT COUNT(manv) as count_nv FROM employee a, department b  "
                    + "WHERE a.maphong = b.maphong and a.maphong='"+maphong+"'";
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
