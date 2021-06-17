/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Nguoihoc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class DAONguoihoc {

    private static PreparedStatement pstm = null;
    private static String insert = "INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai],"
            + "[Email], [GhiChu], [MaNV], [NgayDK]) VALUES (?,?,?,?,?,?,?,?,?)";
    private static String delete = "DELETE FROM NGUOIHOC WHERE MANH = ?";
    private static String update = "UPDATE NGUOIHOC SET HOTEN = ?, GIOITINH = ?, NGAYSINH = ?, DIENTHOAI = ?,"
            + "EMAIL = ?, GHICHU = ?, MANV = ?, NGAYDK = ? WHERE MANH = ?";

    public static List<Nguoihoc> lstNguoihocs() {
        List<Nguoihoc> lst = new ArrayList<>();
        try {
            Statement st = Dbconnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM NGUOIHOC");
            while (rs.next()) {
                Nguoihoc x = new Nguoihoc();
                x.setId(rs.getString(1));
                x.setName(rs.getString(2));
                x.setGioitinh(rs.getInt(4));
                x.setSdt(rs.getString(5));
                x.setEmail(rs.getString(6));
                x.setGhichu(rs.getString(7));
                x.setNgayDK(Help.FormatDate.yeartoday(rs.getString(9)));
                x.setMaNV(rs.getString(8));
                x.setNgaysinh(Help.FormatDate.yeartoday(rs.getString(3)));
                lst.add(x);
            }
            st.close();
            return lst;
        } catch (Exception e) {
        }
        return null;
    }
//INSERT NGUOIHOC VALUES('NH01','Lan Anh',0,'0912366995','Lanh@gmail.com',N'rất xinh gái','2021-01-20','2001-09-01','M01')

    public static boolean InsertNguoihoc(Nguoihoc x) {
        try {
            pstm = Dbconnection.getConnection().prepareCall(insert);
            pstm.setString(1, x.getId());
            pstm.setString(2, x.getName());
            pstm.setString(3, x.getNgaysinh());
            pstm.setInt(4, x.getGioitinh());
            pstm.setString(5, x.getSdt());
            pstm.setString(6, x.getEmail());
            pstm.setString(7, x.getGhichu());
            pstm.setString(8, x.getMaNV());
            pstm.setString(9, x.getNgayDK());
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("loi cc " + e);
        }
        return false;
    }

    public static boolean UpdateNguoihoc(Nguoihoc x) {
        try {
            pstm = Dbconnection.getConnection().prepareCall(update);
            pstm.setString(1, x.getName());
            pstm.setString(3, x.getNgaysinh());
            pstm.setInt(2, x.getGioitinh());
            pstm.setString(4, x.getSdt());
            pstm.setString(5, x.getEmail());
            pstm.setString(6, x.getGhichu());
            pstm.setString(7, x.getMaNV());
            pstm.setString(8, x.getNgayDK());
            pstm.setString(9, x.getId());
            return pstm.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println("sịt" + e);

        }
        return false;
    }

    public static boolean deleteNguoihoc(String id) {
        try {
            pstm = Dbconnection.getConnection().prepareCall(delete);
            pstm.setString(1, id);
            return pstm.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println("sịt" + e);
        }
        return false;
    }

}
