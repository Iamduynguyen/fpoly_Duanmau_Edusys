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
public class Nhanvien extends Person{
    private int chucvu;
    private String matkhau;

    public Nhanvien() {
    }

    public Nhanvien(int chucvu, String matkhau) {
        this.chucvu = chucvu;
        this.matkhau = matkhau;
    }

    public Nhanvien(int chucvu, String matkhau, String id, String name) {
        super(id, name);
        this.chucvu = chucvu;
        this.matkhau = matkhau;
    }

    public int getChucvu() {
        return chucvu;
    }

    public void setChucvu(int chucvu) {
        this.chucvu = chucvu;
    }



    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
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
    
    
}
