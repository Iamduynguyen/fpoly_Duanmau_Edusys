/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author dell
 */
public class ChuyenDe {

    private String idCD;
    private String nameCD;
    private int thoiluongCD;
    private double hocphiCD;
    private String motaCD;
    private String hinh;

    public ChuyenDe() {
    }

    public ChuyenDe(String idCD, String nameCD, int thoiluongCD, double hocphiCD, String motaCD, String hinh) {
        this.idCD = idCD;
        this.nameCD = nameCD;
        this.thoiluongCD = thoiluongCD;
        this.hocphiCD = hocphiCD;
        this.motaCD = motaCD;
        this.hinh = hinh;
    }
    
    

    public String getIdCD() {
        return idCD;
    }

    public void setIdCD(String idCD) {
        this.idCD = idCD;
    }

    public String getNameCD() {
        return nameCD;
    }

    public void setNameCD(String nameCD) {
        this.nameCD = nameCD;
    }

    public int getThoiluongCD() {
        return thoiluongCD;
    }

    public void setThoiluongCD(int thoiluongCD) {
        this.thoiluongCD = thoiluongCD;
    }

    public double getHocphiCD() {
        return hocphiCD;
    }

    public void setHocphiCD(double hocphiCD) {
        this.hocphiCD = hocphiCD;
    }

    public String getMotaCD() {
        return motaCD;
    }

    public void setMotaCD(String motaCD) {
        this.motaCD = motaCD;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    
    
}
