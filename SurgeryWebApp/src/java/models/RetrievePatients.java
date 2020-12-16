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
import pojo.ClientInfo;

/**
 *
 * @author Jake
 */
public class RetrievePatients {
    
    private final Connection con;
    private final String type;
    
    public RetrievePatients(String type, ServletContext sc) {
        con = (Connection)sc.getAttribute("dbConnection");
        this.type = type;
    }
    
    public ArrayList<ClientInfo> getList() {
        try {
            // Check for any existing user entries
            PreparedStatement ps = con.prepareStatement("SELECT * FROM clients WHERE ctype=?");
            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();

            ArrayList<ClientInfo> data = new ArrayList<>();
            while (rs.next()) {
                String cID = rs.getString("cid");
                String cName = rs.getString("cname");
                String cAddress = rs.getString("caddress");
                String cType = rs.getString("ctype");
                String uName = rs.getString("uname");
                
                data.add(new ClientInfo(cID, cName, cAddress, cType, uName));
            }
            
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }
}
