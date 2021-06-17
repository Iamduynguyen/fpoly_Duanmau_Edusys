/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SEVICE;

import DAO.DAONguoihoc;
import Model.Nguoihoc;
import java.util.List;

/**
 *
 * @author dell
 */
public class SVNguoihoc implements ISVNguoihoc{
    DAO.DAONguoihoc dAONguoihoc = new DAONguoihoc();
    public SVNguoihoc() {
    }

    @Override
    public List<Nguoihoc> listnguoihoc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean insertNH(List<Nguoihoc> lst) {
        return true;
    }
   
    
}
