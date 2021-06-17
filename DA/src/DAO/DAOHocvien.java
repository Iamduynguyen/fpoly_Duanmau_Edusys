/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.Hocvien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class DAOHocvien {
    private Statement st;
    private ResultSet rs;
    private static PreparedStatement pstm = null;
    private static final String insert = "INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (?,?,?)";
    private static final String update = "Update Hocvien set diem = ? where maHv = ?";
    private static final String delete = "DElete from hocvien where mahv = ?";
    private static final String selectall = "SElect mahv,makh,hocvien.manh,diem,HoTen from HocVien join NguoiHoc on HocVien.MaNH=NguoiHoc.MaNH";
    private static final String selectbyid = "SElect mahv,makh,hocvien.manh,diem,HoTen from HocVien join NguoiHoc on HocVien.MaNH=NguoiHoc.MaNH where makh = ";

    public DAOHocvien() {
    }
    
    public static void main(String[] args) {
        DAOHocvien dao = new DAOHocvien();
        for (Hocvien x : dao.lsthocvien()) {
            System.out.println(x.getHvt());
        }
    }

    
    public List<Hocvien> lsthocvien(){
        List<Hocvien> lst = new ArrayList<>();
        try {
            st = Dbconnection.getConnection().createStatement();
            rs = st.executeQuery(selectall);
            while (rs.next()) {                
                Hocvien hv = new Hocvien();
                hv.setMahv(rs.getInt(1));
                hv.setDiem(rs.getFloat(4));
                hv.setManh(rs.getString(3));
                hv.setMakh(rs.getInt(2));
                hv.setHvt(rs.getString(5));
                lst.add(hv);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
        public List<Hocvien> lsthocvienbymakh(int x){
        List<Hocvien> lst = new ArrayList<>();
        try {
            st = Dbconnection.getConnection().createStatement();
            rs = st.executeQuery(selectbyid+x);
            while (rs.next()) {                
                Hocvien hv = new Hocvien();
                hv.setMahv(rs.getInt(1));
                hv.setDiem(rs.getFloat(4));
                hv.setManh(rs.getString(3));
                hv.setMakh(rs.getInt(2));
                hv.setHvt(rs.getString(5));
                lst.add(hv);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean inserthv(Hocvien hv){
        try {
            pstm = Dbconnection.getConnection().prepareCall(insert);
            pstm.setInt(1, hv.getMakh());
            pstm.setString(2, hv.getManh());
            pstm.setDouble(3, hv.getDiem());
            return pstm.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false;
    }
    
        public boolean deletehv(int mahv){
        try {
            pstm = Dbconnection.getConnection().prepareCall(delete);
            pstm.setInt(1,mahv);
            return pstm.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false;
    }
        
        public boolean updatediem(int mahv,float diem){
            try {
                pstm = Dbconnection.getConnection().prepareCall(update);
                pstm.setDouble(1, diem);
                pstm.setInt(2, mahv);
                return pstm.executeUpdate()>0;
            } catch (Exception e) {
                return false;
            }
        }
}
