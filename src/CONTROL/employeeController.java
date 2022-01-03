package CONTROL;


import CONTROL.connectDB;
import MODEL.departmentModel;
import MODEL.employeeModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public static List<employeeModel> getEmployee() {
        List<employeeModel> ListUser = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        try {
            //get all info room
            connectDB connect = new connectDB();
            conn = connect.run();
            //query
            String sql = "SELECT manv, fullname, sex, birthday,phonenumber, address, position, epl.maphong, mahoso from employee epl, department dp "
                    + "WHERE epl.maphong=dp.maphong";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                employeeModel nv = new employeeModel();
                nv.setManv(rs.getString("manv"));
                nv.setFullname(rs.getString("fullname"));
                nv.setSex(rs.getString("sex"));
                nv.setBirthday(rs.getString("birthday"));
                nv.setPhoneNumber(rs.getInt("phonenumber"));
                nv.setAddress(rs.getString("address"));
                nv.setPosition(rs.getString("position"));
                nv.setMaphong(rs.getString("maphong"));
                nv.setMahoso(rs.getString("mahoso"));
                ListUser.add(nv);
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
        return ListUser;
    }
    public static List<employeeModel> getEmployByMaPhong(String maphong) {
        List<employeeModel> ListUser = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        try {
            //get all info room
            connectDB connect = new connectDB();
            conn = connect.run();
            //query
            String sql = "SELECT manv, fullname, sex, birthday,phonenumber, address, position, epl.maphong, mahoso from employee epl, department dp "
                    + "WHERE epl.maphong=dp.maphong and epl.maphong='"+maphong+"'";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                employeeModel nv = new employeeModel();
                nv.setManv(rs.getString("manv"));
                nv.setFullname(rs.getString("fullname"));
                nv.setSex(rs.getString("sex"));
                nv.setBirthday(rs.getString("birthday"));
                nv.setPhoneNumber(rs.getInt("phonenumber"));
                nv.setAddress(rs.getString("address"));
                nv.setPosition(rs.getString("position"));
                nv.setMaphong(rs.getString("maphong"));
                nv.setMahoso(rs.getString("mahoso"));
                ListUser.add(nv);
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
        return ListUser;
    }
    public static void addEmployee(employeeModel nhanVien) {
       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
        try {
            String sql = "INSERT INTO employee VALUES(?,?,?,?,?,?,?,?,?)";
            connectDB connect = new connectDB();
            conn = connect.run();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nhanVien.getManv());
            ps.setString(2, nhanVien.getFullname());
            ps.setString(3, nhanVien.getSex());
            ps.setString(4, nhanVien.getBirthday());
            ps.setInt(5, nhanVien.getPhoneNumber());
            ps.setString(6, nhanVien.getAddress());
            ps.setString(7, nhanVien.getPosition());
            ps.setString(8, nhanVien.getMaphong());
            ps.setString(9, nhanVien.getMahoso());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteEmployee(String manv) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "DELETE FROM employee WHERE manv =?";
            connectDB connect = new connectDB();
            conn = connect.run();
            ps = conn.prepareStatement(sql);
            ps.setString(1, manv);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateEmployee(employeeModel nhanVien) {
       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
        try {
            String sql = "UPDATE employee SET manv=?, fullname=?, sex=?, birthday=?, phonenumber=?, address=?, position=?, maphong=?, mahoso=? "
                    + "WHERE manv=? ";
            connectDB connect = new connectDB();
            conn = connect.run();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nhanVien.getManv());
            ps.setString(2, nhanVien.getFullname());
            ps.setString(3, nhanVien.getSex());
            ps.setString(4, nhanVien.getBirthday());
            ps.setInt(5, nhanVien.getPhoneNumber());
            ps.setString(6, nhanVien.getAddress());
            ps.setString(7, nhanVien.getPosition());
            ps.setString(8, nhanVien.getMaphong());
            ps.setString(9, nhanVien.getMahoso());
            ps.setString(10, nhanVien.getManv());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
