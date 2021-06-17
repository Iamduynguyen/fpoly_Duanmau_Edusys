/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SEVICE;

import Model.Nhanvien;
import java.util.List;

/**
 *
 * @author dell
 */
public class SVNhanvien implements ISVNhanvien{
    Nhanvien _nhanvien = new Nhanvien();
    @Override
    public List<Nhanvien> lstNhanvien() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean insertNhanvien(List<Nhanvien> lst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Nhanvien getNhanvien(Nhanvien Nhanvien) {
        _nhanvien = Nhanvien;
        return _nhanvien;
    }

    @Override
    public Nhanvien getNV() {
        return _nhanvien;
    }
    
}
