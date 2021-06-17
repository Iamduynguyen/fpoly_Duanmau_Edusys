/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.KhoaHoc;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author dell
 */
public class DAOKhoahoc {

    Dbconnection dbconn = new Dbconnection();
    Statement st = null;
    private PreparedStatement pstm = null;
    private final String insert = "INSERT [dbo].[KhoaHoc] ( [MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (?,?,?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE KHOAHOC SET MACD = ?, HOCPHI = ?, THOILUONG = ?, NGAYKG = ?, \n"
            + "GHICHU = ?, MANV = ?, NGAYTAO = ? WHERE MAKH = ?";
    private final String SQL_DELETE = "DELETE KHOAHOC WHERE MAKH = ?";

    public DAOKhoahoc() {
    }

    public List<KhoaHoc> getlistKh() {
        List<KhoaHoc> lst = new ArrayList<>();
        try {
            st = Dbconnection.getConnection().createStatement();
            String sql = "SELECT * FROM KHOAHOC";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                KhoaHoc x = new KhoaHoc();
                x.setIdKh(rs.getInt(1));
                x.setThoiluong(rs.getInt(4));
                x.setHocphi(rs.getDouble(3));
                x.setNgaytao(Help.FormatDate.yeartoday(rs.getString(8)));
                x.setGhichu(rs.getString(6));
                x.setNgayKG(Help.FormatDate.yeartoday(rs.getString(5)));
                x.setMaCD(rs.getString(2));
                x.setManv(rs.getString(7));
                lst.add(x);
            }
            return lst;
        } catch (SQLException e) {
            System.out.println("loi cc " + e);
        }
        return null;
    }

    public List<KhoaHoc> getlistKhbyid(String macd) {
        List<KhoaHoc> lst = new ArrayList<>();
        try {
            st = Dbconnection.getConnection().createStatement();
            String sql = "SELECT * FROM KHOAHOC where macd = '" + macd + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                KhoaHoc x = new KhoaHoc();
                x.setIdKh(rs.getInt(1));
                x.setThoiluong(rs.getInt(4));
                x.setHocphi(rs.getDouble(3));
                x.setNgaytao(Help.FormatDate.yeartoday(rs.getString(8)));
                x.setGhichu(rs.getString(6));
                x.setNgayKG(Help.FormatDate.yeartoday(rs.getString(5)));
                x.setMaCD(rs.getString(2));
                x.setManv(rs.getString(7));
                lst.add(x);
            }
            return lst;
        } catch (SQLException e) {
            System.out.println("loi cc " + e);
        }
        return null;
    }

    public boolean insertKH(KhoaHoc x) {
        try {
            x.setNgayKG(Help.FormatDate.daytoyear(x.getNgayKG()));
            x.setNgaytao(Help.FormatDate.daytoyear(x.getNgaytao()));
            pstm = Dbconnection.getConnection().prepareCall(insert);
            pstm.setString(1, x.getMaCD());
            pstm.setDouble(2, x.getHocphi());
            pstm.setInt(3, x.getThoiluong());
            pstm.setString(4, x.getNgayKG());
            pstm.setString(5, x.getGhichu());
            pstm.setString(6, x.getManv());
            pstm.setString(7, x.getNgaytao());
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //
    public boolean updateKH(KhoaHoc x) {
        try {
            x.setNgayKG(Help.FormatDate.daytoyear(x.getNgayKG()));
            x.setNgaytao(Help.FormatDate.daytoyear(x.getNgaytao()));
            pstm = Dbconnection.getConnection().prepareCall(SQL_UPDATE);
            pstm.setString(1, x.getMaCD());
            pstm.setDouble(2, x.getHocphi());
            pstm.setInt(3, x.getThoiluong());
            pstm.setString(4, x.getNgayKG());
            pstm.setString(5, x.getGhichu());
            pstm.setString(6, x.getManv());
            pstm.setString(7, x.getNgaytao());
            pstm.setInt(8, x.getIdKh());
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteKH(int x) {
        try {
            pstm = Dbconnection.getConnection().prepareCall(SQL_DELETE);
            pstm.setInt(1, x);
            return pstm.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false;
    }
}
