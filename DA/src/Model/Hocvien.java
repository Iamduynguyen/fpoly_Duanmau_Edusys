/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.DAONguoihoc;

/**
 *
 * @author dell
 */
public class Hocvien {
    private int mahv;
    private String manh;
    private float diem;
    private int makh;
    private String hvt;

    public Hocvien() {
    }

    public int getMahv() {
        return mahv;
    }

    public void setMahv(int mahv) {
        this.mahv = mahv;
    }



    public String getManh() {
        return manh;
    }

    public void setManh(String manh) {
        this.manh = manh;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public String getHvt() {
        return hvt;
    }

    public void setHvt(String hvt) {
        this.hvt = hvt;
    }
    
    
}
