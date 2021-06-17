/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SEVICE;

import Model.Nguoihoc;
import java.util.List;

/**
 *
 * @author dell
 */
public interface ISVNguoihoc {
    List<Nguoihoc> listnguoihoc();
    Boolean insertNH(List<Nguoihoc> lst);
}
