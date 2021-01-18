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
import pojo.InvoiceInfo;

/**
 *
 * @author Jake
 */
public class PayBills {
    
    private final Connection con;
    
    public PayBills(ServletContext sc) {
        con = (Connection) sc.getAttribute("dbConnection");
    }
    
    public ArrayList<InvoiceInfo> retrieveOutstandingInvoices(String customerUsername) {
        ArrayList<InvoiceInfo> data = new ArrayList<>();
        
        try {
            // Retrieve customer id from username
            PreparedStatement ps = con.prepareStatement("SELECT cID FROM clients WHERE uName=?");
            ps.setString(1, customerUsername);
            ResultSet rs = ps.executeQuery();
            
            // Go through result set and retrieve customer id
            int cID = -999;
            while (rs.next()) {
                cID = rs.getInt("cID");
            }
            
            // Retrieve unpaid invoices for given customer
            ps = con.prepareStatement("SELECT * FROM invoices WHERE cID=? AND iPaid=false");
            ps.setInt(1, cID);
            rs = ps.executeQuery();
            
            // Go through result set and retrieve all open invoices information
            while (rs.next()) {
                int iID = rs.getInt("iID");
                int oID = rs.getInt("oID");
                boolean iPaid = rs.getBoolean("iPaid");
                
                // Add information to array
                data.add(new InvoiceInfo(iID, cID, oID, iPaid));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PayBills.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    
    public boolean payInvoice(int iID) {
        try {
            // Update invoice entry to show it has been paid
            PreparedStatement ps = con.prepareStatement("UPDATE invoices SET iPaid = true WHERE iID = ?");
            ps.setInt(1, iID);
            int updated = ps.executeUpdate();
            
            // Make sure at least one row was updated
            if (updated > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PayBills.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Invoice update was not successful
        return false;
    }
}
