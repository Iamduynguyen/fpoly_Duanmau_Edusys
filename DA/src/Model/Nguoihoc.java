/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author dell
 */
public class Nguoihoc extends Person{
    private String ghichu;
    private String ngayDK;
    private String maNV;

    public Nguoihoc() {
    }

    public Nguoihoc(String ghichu, String ngayDK, String maNV) {
        this.ghichu = ghichu;
        this.ngayDK = ngayDK;
        this.maNV = maNV;
    }





    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }


    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmail() {
        return super.getEmail(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSdt(String sdt) {
        super.setSdt(sdt); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSdt() {
        return super.getSdt(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setGioitinh(int gioitinh) {
        super.setGioitinh(gioitinh); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getGioitinh() {
        return super.getGioitinh(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String name) {
        super.setName(name); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return super.getName(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(String id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }




    @Override
    public void setCheck(Boolean check) {
        super.setCheck(check); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean getCheck() {
        return super.getCheck(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(String ngayDK) {
        this.ngayDK = ngayDK;
    }

    @Override
    public void setNgaysinh(String ngaysinh) {
        super.setNgaysinh(ngaysinh); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNgaysinh() {
        return super.getNgaysinh(); //To change body of generated methods, choose Tools | Templates.
    }


    
    
}
