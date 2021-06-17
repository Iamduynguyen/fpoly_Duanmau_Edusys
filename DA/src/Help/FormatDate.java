/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Help;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NgocPJa
 */
public class FormatDate {

    public static String stringDD(Date date) {
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }

    public static Date dateDD(String date) {
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(FormatDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
        public static String stringYYYY(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static Date dateYYYY(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(FormatDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static String daytoyear(String date){
        return stringYYYY(Help.FormatDate.dateDD(date));
    }
    
    public static String yeartoday(String date){
        return stringDD(dateYYYY(date));
    }
}