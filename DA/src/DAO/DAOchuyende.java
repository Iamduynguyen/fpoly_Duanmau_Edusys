/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ChuyenDe;
import Model.Nhanvien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class DAOchuyende {

    private static String insert = "INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa]) VALUES(?,?,?,?,?,?)";
    private static String upadte = "Update Chuyende set mota = ?,tencd = ? , hocphi = ?, thoiluong = ? , hinh = ? where macd= ?";
    private static PreparedStatement pstm = null;
    private static String delete = "DELETE from chuyende  where macd = ?";
    
    


    public static List<ChuyenDe> lstchuyende() {
        List<ChuyenDe> lst = new ArrayList<>();
        try {
            Statement st = Dbconnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CHUYENDE");
            while (rs.next()) {
                ChuyenDe x = new ChuyenDe();
                x.setIdCD(rs.getString(1));
                x.setNameCD(rs.getString(2));
                x.setHocphiCD(rs.getDouble(3));
                x.setThoiluongCD(rs.getInt(4));
                x.setMotaCD(rs.getString(6));
                x.setHinh(rs.getString(5));
                lst.add(x);
            }
            return lst;
        } catch (Exception e) {
            System.out.println("loi:" + e);
            return null;
        }
    }

    public static Boolean insertCD(ChuyenDe x) {
        try {
            pstm = Dbconnection.getConnection().prepareCall(insert);
            pstm.setString(1, x.getIdCD());
            pstm.setString(2, x.getNameCD());
            pstm.setDouble(3, x.getHocphiCD());
            pstm.setInt(4, x.getThoiluongCD());
            pstm.setString(5, x.getHinh());
            pstm.setString(6, x.getMotaCD());
            return pstm.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println("Loi cc gi "+ e);
        }
        return false;
    }

    //exec UpdateNV 'M02','Linh','linhtt',0
    public static Boolean updatecd(ChuyenDe x) {
        try {
            pstm = Dbconnection.getConnection().prepareCall(upadte);
            pstm.setString(6, x.getIdCD());
            pstm.setString(2, x.getNameCD());
            pstm.setDouble(3, x.getHocphiCD());
            pstm.setInt(4, x.getThoiluongCD());
            pstm.setString(5, x.getHinh());
            pstm.setString(1, x.getMotaCD());
            return pstm.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false;
    }

    public static Boolean xoaCD(ChuyenDe x) {
        try {
            pstm = Dbconnection.getConnection().prepareCall(delete);
            pstm.setString(1, x.getIdCD());
            return pstm.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false;
    }
}
