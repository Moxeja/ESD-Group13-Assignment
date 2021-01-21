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
//import java.util.ArrayList;
//import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import pojo.MedicinesInfo;

/**
 *
 * @author Dominika
 */

public class Prescriptions {
    
    private final Connection con;
    
    public Prescriptions(ServletContext sc) {
        con = (Connection) sc.getAttribute("dbConnection");
       
    }
        public ArrayList<MedicinesInfo> getMedicines(){
            ArrayList<MedicinesInfo> medicines = new ArrayList<>();

            try {
                // Check for any existing user entries
                PreparedStatement ps = con.prepareStatement("SELECT * FROM medicines");
                ResultSet rs = ps.executeQuery();

                while(rs.next()){
                    int mID = rs.getInt("mid");
                    String mName = rs.getString("mname");
                    String mType = rs.getString("mtype");
                    float mCost = rs.getFloat("mcost");

                    MedicinesInfo data = new MedicinesInfo(mID, mName, mType, mCost);
                    medicines.add(data);
                }

                return medicines;
                     } catch (SQLException ex) {
                         Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                         }
            return null;
        }

        public void addPrescription(int cID, int mID ){
            try {
                PreparedStatement ps = con.prepareStatement("INSERT INTO prescriptions(cID, mID) VALUES (?, ?)");
                ps.setInt(1, cID);
                ps.setInt(2, mID);
                int updates = ps.executeUpdate();


            } catch (SQLException ex) {
                Logger.getLogger(Prescriptions.class.getName()).log(Level.SEVERE, null, ex);
            }

        } 

}

