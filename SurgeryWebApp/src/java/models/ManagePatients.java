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
import pojo.EmployeeInfo;

/**
 *
 * @author Tom
 */
public class ManagePatients {

    private final Connection con;

    public ManagePatients(ServletContext sc) {
        con = (Connection) sc.getAttribute("dbConnection");
    }

    public EmployeeInfo getEmployee(String EmployeeUsername) {
        String eID = "";
        String eName = "";
        String eAddress = "";
        String uName = "";

        try {
            // Check for any existing user entries
            PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE uname=?");
            String username = EmployeeUsername;
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                eID = rs.getString("eid");
                eName = rs.getString("ename");
                eAddress = rs.getString("eaddress");
                uName = EmployeeUsername;
            }
            EmployeeInfo data = new EmployeeInfo(eID, eName, eAddress, uName);

            return data;
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<ClientInfo> getClients(String EmployeeID) {
        try {
            // Check for any existing user entries
            String id = EmployeeID;
            PreparedStatement ps = con.prepareStatement("SELECT * FROM booking_slots WHERE eid=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            ArrayList<String> foundClients = new ArrayList();
            ArrayList<ClientInfo> clientList = new ArrayList<>();
            while (rs.next()) {

                String cID = rs.getString("cid");
                if (!foundClients.contains(cID)) {
                    clientList.add(getClientFromID(cID));
                    foundClients.add(cID);
                }
            }

            return clientList;
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ArrayList<>();
    }

    public ClientInfo getClientFromID(String cID) {
        String CID = cID;
        String cName = "";
        String cAddress = "";
        String cType = "";
        String uName = "";

        try {
            // Check for any existing user entries
            PreparedStatement ps = con.prepareStatement("SELECT * FROM clients WHERE cid=?");
            ps.setString(1, CID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cName = rs.getString("cname");
                cAddress = rs.getString("caddress");
                cType = rs.getString("ctype");
                uName = rs.getString("uname");
            }
            ClientInfo data = new ClientInfo(cID, cName, cAddress, cType, uName);

            return data;
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void removeClient(int cID) {
        try {
            // Retrieve client info first
            ClientInfo info = getClientFromID("" + cID);

            // Remove client entry from database
            PreparedStatement ps = con.prepareStatement("DELETE FROM clients WHERE cID=?");
            ps.setInt(1, cID);
            ps.executeUpdate();

            // Remove entry from users table
            ps = con.prepareStatement("DELETE FROM users WHERE uName=?");
            ps.setString(1, info.cUname);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
