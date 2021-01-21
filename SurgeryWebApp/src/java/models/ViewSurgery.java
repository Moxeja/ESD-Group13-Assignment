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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import pojo.ScheduleInfo;

/**
 *
 * @author Nicola
 */
public class ViewSurgery {
   private final Connection con;
    
    public ViewSurgery(ServletContext sc) {
        con = (Connection)sc.getAttribute("dbConnection");
    }
    
    public ArrayList<ScheduleInfo> getList(String username) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE uName=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            int eID = -1;
            while (rs.next()) {
                eID = rs.getInt("eID");
            }
            
            // Check for any existing user entries
            ps = con.prepareStatement("SELECT * FROM booking_slots WHERE eID=?");
            ps.setInt(1, eID);
            rs = ps.executeQuery();

            ArrayList<ScheduleInfo> data = new ArrayList<>();
            while (rs.next()) {
                String sID = rs.getString("sid");
                String cID = rs.getString("cid");
                String sDate = rs.getString("sdate");
                String sTime = rs.getString("stime");        
                
                data.add(new ScheduleInfo(sID, ""+eID, cID, sDate, sTime, "", ""));
            }
            
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }
  
}
