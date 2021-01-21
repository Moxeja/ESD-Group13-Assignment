/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

/**
 *
 * @author Jake
 */
public class TurnoverModel {
    
    private final Connection con;
    
    public TurnoverModel(ServletContext sc) {
        con = (Connection) sc.getAttribute("dbConnection");
    }
    
    public float calculateTurnover(String startDate, String endDate) {
        float sum = 0;
        
        try {
            Date start = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            Date end = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM operations");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) { 
                String date = rs.getString("oDate");
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                if(date1.after(start) && date1.before(end)){ 
                    sum += rs.getFloat("Charge");
                }
            }
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(TurnoverModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sum;
    }
}
