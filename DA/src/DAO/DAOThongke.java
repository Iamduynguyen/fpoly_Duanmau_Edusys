/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class DAOThongke {

    private Statement stm = null;

    public List<Object[]> getBangdiem(int makh) {
        List<Object[]> lst = new ArrayList<>();
        String sql = "exec sp_BangDiem " + makh;
        try ( Statement stm = Dbconnection.getConnection().createStatement();  ResultSet rs = stm.executeQuery(sql);) {
            while (rs.next()) {
                Object[] x = new Object[4];
                x[0] = rs.getString(1);
                x[1] = rs.getString(2);
                x[2] = rs.getDouble(3);
                x[3] = xeploai(rs.getDouble(3));
                lst.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    
        private String xeploai(double diem) {
        if (diem < 5) {
            return "Không đạt";
        }
        if (diem < 6.5) {
            return "TB";
        }
        if (diem < 7.5) {
            return "Khá";
        }
        if (diem < 8.5) {
            return "Giỏi";
        }
        return "Xuất xắc";
    }

    public List<Object[]> getTKdiemCD() {
        List<Object[]> lst = new ArrayList<>();
        String sql = "exec sp_ThongKeDiem";
        try ( Statement stm = Dbconnection.getConnection().createStatement();  ResultSet rs = stm.executeQuery(sql);) {
            while (rs.next()) {
                Object[] x = new Object[5];
                x[0] = rs.getString(1);
                x[1] = rs.getDouble(2);
                x[2] = rs.getDouble(3);
                x[3] = rs.getDouble(4);
                x[4] = rs.getDouble(5);
                lst.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public List<Object[]> getTKNguoihoc() {
        List<Object[]> lst = new ArrayList<>();
        String sql = "exec sp_ThongKeNguoiHoc";
        try ( Statement stm = Dbconnection.getConnection().createStatement();  ResultSet rs = stm.executeQuery(sql);) {
            while (rs.next()) {
                Object[] x = new Object[4];
                x[0] = rs.getInt(1);
                x[1] = rs.getInt(2);
                x[2] = rs.getString(3);
                x[3] = rs.getString(4);
                lst.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    
        public List<Object[]> getTKdoanhthu(String year) {
        List<Object[]> lst = new ArrayList<>();
        String sql = "exec sp_ThongKeDoanhThu"+ year;
        try ( Statement stm = Dbconnection.getConnection().createStatement();  ResultSet rs = stm.executeQuery(sql);) {
            while (rs.next()) {
                Object[] x = new Object[7];
                x[0] = rs.getString(1);
                x[1] = rs.getInt(2);
                x[2] = rs.getInt(3);
                x[3] = rs.getDouble(4);
                x[4] = rs.getDouble(5);
                x[5] = rs.getDouble(6);
                x[6] = rs.getDouble(7);
                lst.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public List<Integer> selectYear() {
        List<Integer> lst = new ArrayList<>();
        String sql = "SELECT DISTINCT YEAR(NGAYKG) as NAM FROM KHOAHOC ORDER BY NAM DESC";
        try ( Statement stm = Dbconnection.getConnection().createStatement();  ResultSet rs = stm.executeQuery(sql);) {
            while (rs.next()) {
                lst.add(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
}
