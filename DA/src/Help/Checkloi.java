/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Help;

import Model.ChuyenDe;
import Model.Nguoihoc;
import Model.Nhanvien;
import java.util.List;

/**
 *
 * @author dell
 */
public class Checkloi {

    
    
    public static boolean checkNgay(String ngay) {
        String tet = "^(0?[1-9]|[12][0-9]|3[01])\\-(0?[1-9]|1[012])\\-\\d{4}$";
        if (!ngay.matches(tet)) {
            return false;
        } else {
            return true;
        }

    }
    
    public static void main(String[] args) {
        if (checkEmail("duyndph12801@fpt.edu")) {
            System.err.println("ok");
        }
    }

//    ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//              + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
    
    public static boolean checkEmail(String email) {
        String reEmail = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]+\\.[\\w]{2,})$";
        if (!email.matches(reEmail)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkSDT(String SDT) {
        String reSDT = "[0]{1}[1-9]{9}";
        if (!SDT.matches(reSDT)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkSo(String So) {
        try {
            if (Double.parseDouble(So) < 0) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static int checkmaNH(String manh, List<Nguoihoc> lst) {
        for (int i = 0; i < lst.size(); i++) {
            if (manh.equals(lst.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    public static int checkmaNV(String manh, List<Nhanvien> lst) {
        for (int i = 0; i < lst.size(); i++) {
            if (manh.equals(lst.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }
    
        public static int checkmaCD(String macd, List<ChuyenDe> lst) {
        for (int i = 0; i < lst.size(); i++) {
            if (macd.equals(lst.get(i).getIdCD())) {
                return i;
            }
        }
        return -1;
    }


}
