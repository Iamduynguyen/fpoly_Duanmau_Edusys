/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SEVICE;

import DAO.DAOHocvien;
import Model.Hocvien;

/**
 *
 * @author dell
 */
public class SVHOCVIEN {
    static DAOHocvien dAOHocvien = new DAOHocvien();
    
    public static Hocvien getHocvienbyid(int mahv){
        for (Hocvien x : dAOHocvien.lsthocvien()) {
            if (x.getMahv()==mahv) {
                return x;
            }
        }
        return null;
    }
    
}
