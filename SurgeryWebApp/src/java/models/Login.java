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
public class Login {
    
    private final String username;
    private final String password;
    private final Connection con;
    
    public Login(String username, String password, ServletContext sc) {
        this.username = username;
        this.password = password;
        con = (Connection)sc.getAttribute("dbConnection");
    }
    
    public String getAccountType() {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE uname=?");
            ps.setString(0, username);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String pass = rs.getString("passwd");
                if (password.equals(pass)) {
                    return rs.getString("role");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
