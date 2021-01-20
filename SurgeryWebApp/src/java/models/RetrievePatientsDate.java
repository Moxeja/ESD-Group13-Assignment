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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import pojo.ClientInfo;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author jamie
 */
public class RetrievePatientsDate {
        
    private final Connection con;

    
    public RetrievePatientsDate(ServletContext sc) {
        con = (Connection)sc.getAttribute("dbConnection");
        
    }
        public ArrayList<ClientInfo> getClients(Date startDate, Date endDate) throws ParseException{
               try {
            // Check for any existing user entries
            PreparedStatement ps = con.prepareStatement("SELECT * FROM booking_slots");
            ResultSet rs = ps.executeQuery();

            ArrayList<ClientInfo> data = new ArrayList<>();
            ArrayList foundClients = new ArrayList<>();
            while (rs.next()) { 
                String testDate = rs.getString("sdate");
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(testDate);
                if(date1.after(startDate)&& date1.before(endDate) && !foundClients.contains(rs.getString("cid"))){ 
                    String cID = rs.getString("cid");
                    data.add(getClient(cID));
                    foundClients.add(cID);    
                }
            }

            return data;
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    } 
    
    
    public ClientInfo getClient(String cid) {
        String cID = "";
        String cName = "";
        String cAddress = "";
        String cType = "";
        String uName = "";
        try {
           
            // Check for any existing user entries
            PreparedStatement ps = con.prepareStatement("SELECT * FROM clients WHERE cid=?");
            ps.setString(1, cid);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            cID = rs.getString("cid");
            cName = rs.getString("cname");
            cAddress = rs.getString("caddress");
            cType = rs.getString("ctype");
            uName = rs.getString("uname");
            }  
            ClientInfo info = new ClientInfo(cID, cName, cAddress, cType, uName);
 
            
            return info;
        
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
