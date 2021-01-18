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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

/**
 *
 * @author Jake
 */
public class ChangeConsultation {

    private final Connection con;

    public ChangeConsultation(ServletContext sc) {
        con = (Connection) sc.getAttribute("dbConnection");
    }

    public boolean setConsultation(int duration, float price) {
        try {
            // Update the price and duration of consultation
            PreparedStatement ps = con.prepareStatement("UPDATE prices SET pDuration = ?, pPrice = ? WHERE pID = 1");
            ps.setInt(1, duration);
            ps.setFloat(2, price);
            int updated = ps.executeUpdate();

            // Check if update was successful
            if (updated > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChangeConsultation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    public float getConsultationPrice() {
        float price = -999f;
        
        try {
            // Retrieve the price of consultation
            PreparedStatement ps = con.prepareStatement("SELECT pPrice FROM prices WHERE pID=1");
            ResultSet rs = ps.executeQuery();

            // Go through result set and retrieve price
            while (rs.next()) {
                price = rs.getFloat("pPrice");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return price;
    }
    
    public int getConsultationTime() {
        int duration = -999;
        
        try {
            // Retrieve the duration of consultation
            PreparedStatement ps = con.prepareStatement("SELECT pDuration FROM prices WHERE pID=1");
            ResultSet rs = ps.executeQuery();

            // Go through result set and retrieve duration
            while (rs.next()) {
                duration = rs.getInt("pDuration");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return duration;
    }
}
