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
public class RegisterClient {

    private final String username;
    private final String password;
    private final String name;
    private final String address;
    private final String cType;
    private final Connection con;

    public RegisterClient(String username, String password, String name,
            String address, String cType, ServletContext sc) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.cType = cType;
        con = (Connection) sc.getAttribute("dbConnection");
    }

    public boolean checkAccountExists() {
        try {
            // Check for any existing user entries
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE uname=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    public boolean registerNewAccount() {
        try {
            // Create user entry
            PreparedStatement ps = con.prepareStatement("INSERT INTO users VALUES (?, ?, 'client')");
            ps.setString(1, username);
            ps.setString(2, password);
            int updates = ps.executeUpdate();

            if (updates > 0) {
                // Create client entry
                ps = con.prepareStatement("INSERT INTO clients (CNAME, CADDRESS, CTYPE, UNAME) VALUES (?, ?, ?, ?)");
                ps.setString(1, name);
                ps.setString(2, address);
                ps.setString(3, cType);
                ps.setString(4, username);
                
                // Check for successful insert
                updates = ps.executeUpdate();
                if (updates > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
