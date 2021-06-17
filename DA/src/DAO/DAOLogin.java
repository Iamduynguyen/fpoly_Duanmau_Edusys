/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Nhanvien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class DAOLogin {

    private static String select = "select * from nhanvien";
    private static String insert = "INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [HoTen], [VaiTro]) VALUES (?,?,?,?)";
    private static String update = "Update nhanvien set vaitro = ?, matkhau = ?, hoten = ? where manv = ?";
    private static String delete = "Delete from nhanvien where manv = ?";
    private static PreparedStatement pstm = null;
    

    public DAOLogin() {
    }
    
    public static void main(String[] args) {
        DAOLogin dao = new DAOLogin();
        for (Nhanvien x : dao.lstLog()) {
            System.out.println(x.getName());
        }
    }

    public List<Nhanvien> lstLog() {
        List<Nhanvien> lst = new ArrayList<>();
        try {
            Statement st = Dbconnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Nhanvien nhanviennew = new Nhanvien();
                nhanviennew.setId(rs.getString(1));
                nhanviennew.setMatkhau(rs.getString(2));
                nhanviennew.setName(rs.getString(3));
                nhanviennew.setChucvu(rs.getInt(4));
                lst.add(nhanviennew);
            }
            return lst;
        } catch (Exception e) {
            System.out.println("loi:" + e);
            return null;
        }
    }

    public static Boolean insertNV(Nhanvien x) {
        try {
            pstm = Dbconnection.getConnection().prepareCall(insert);
            pstm.setString(1, x.getId());
            pstm.setString(2, x.getMatkhau());
            pstm.setString(3, x.getName());
            pstm.setInt(4, x.getChucvu());
            return pstm.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false;
    }

    //exec UpdateNV 'M02','Linh','linhtt',0
    public static Boolean updateNV(Nhanvien x) {
        try {
            pstm = Dbconnection.getConnection().prepareCall(update);
            pstm.setString(4, x.getId());
            pstm.setString(2, x.getMatkhau());
            pstm.setString(3, x.getName());
            pstm.setInt(1, x.getChucvu());
            return pstm.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false;
    }
    
        public static Boolean xoaNV(Nhanvien x) {
        try {
            pstm = Dbconnection.getConnection().prepareCall(delete);
            pstm.setString(1, x.getId());
            return pstm.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false;
    }


}
