/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package austpms;

import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Tahmid
 */
public class Time {
    private Date date;
    private SimpleDateFormat df;
    private String dateFormat = "yyyy-MM-dd";
    
    public String getCurrentDate(){
        date = new Date();
        df = new SimpleDateFormat(dateFormat);
        
        return df.format(date);
        
    }
    
    public String getDate(String dateMan){
        String dateNew = null;
        try{
             dateNew = df.format(df.parse(dateMan));
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return dateNew;
    }
}
    
