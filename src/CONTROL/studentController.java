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
import MODEL.studentModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class studentController {

    //private NhanvienModel model;
    //public static ArrayList<NhanvienModel> getList()
    private studentModel model;

    public static ArrayList<studentModel> getList() {
        ArrayList<studentModel> st = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM student";
            connectDB connCtr = new connectDB();
            con = connCtr.run();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                studentModel model = new studentModel();
                model.setMasv(rs.getString("masv"));
                model.setFullName(rs.getString("fullname"));
                model.setBirthDay(rs.getString("birthday"));
                model.setAddress(rs.getString("address"));
                st.add(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return st;
        }
    }

    public void addStudent(studentModel model) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "INSERT INTO nhanvien(masv, fullname, birthDay, address) VALUES (?,?,?,?)";
            connectDB connCtr = new connectDB();
            con = connCtr.run();
            ps = con.prepareStatement(sql);
            ps.setString(1, model.getMasv());
            ps.setString(2, model.getFullName());
            ps.setString(3, model.getBirthDay());
            ps.setString(4, model.getAddress());
            ps.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(studentModel.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void deleteNV(String MaNV) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "delete from student where masv = ?";
            connectDB connCtr = new connectDB();
            con = connCtr.run();
            ps = con.prepareStatement(sql);
            ps.setString(1, MaNV);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
