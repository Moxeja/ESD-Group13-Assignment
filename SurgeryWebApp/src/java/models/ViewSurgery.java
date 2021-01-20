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
import java.util.List;
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
    
    public ArrayList<ScheduleInfo> getList() {
        try {
            // Check for any existing user entries
            PreparedStatement ps = con.prepareStatement("SELECT * FROM operations");
            ResultSet rs = ps.executeQuery();

            ArrayList<ScheduleInfo> data = new ArrayList<>();
            while (rs.next()) {
                String oID = rs.getString("oid");
                String eID = rs.getString("eid");
                String cID = rs.getString("cid");
                String oDate = rs.getString("odate");
                String oTime = rs.getString("otime");
                String nSlot = rs.getString("nslot");
                String charge = rs.getString("charge");
        
                
                data.add(new ScheduleInfo(oID, eID, cID, oDate, oTime, nSlot, charge));
            }
            
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }
  
}

