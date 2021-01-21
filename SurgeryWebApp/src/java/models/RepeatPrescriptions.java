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
import pojo.MedicinesInfo;

/**
 *
 * @author Jake
 */
public class RepeatPrescriptions {

    private final Connection con;

    public RepeatPrescriptions(ServletContext sc) {
        con = (Connection) sc.getAttribute("dbConnection");
    }

    public ArrayList<MedicinesInfo> getPrescriptions(String username) {
        ArrayList<MedicinesInfo> data = new ArrayList<>();

        try {
            // Retrieve current prescriptions for given client
            PreparedStatement ps = con.prepareStatement("SELECT * FROM clients WHERE uName=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            int cID = 0;
            while (rs.next()) {
                cID = rs.getInt("cID");
            }
            
            // Retrieve current prescriptions for given client
            ps = con.prepareStatement("SELECT * FROM prescriptions WHERE cID=?");
            ps.setInt(1, cID);
            rs = ps.executeQuery();

            ArrayList<Integer> mIDs = new ArrayList<>();
            while (rs.next()) {
                mIDs.add(rs.getInt("mID"));
            }

            for (int mID : mIDs) {
                ps = con.prepareStatement("SELECT * FROM medicines WHERE mID=?");
                ps.setInt(1, mID);
                rs = ps.executeQuery();

                while (rs.next()) {
                    String mName = rs.getString("mName");
                    String mType = rs.getString("mType");
                    float mCost = rs.getFloat("mCost");

                    data.add(new MedicinesInfo(mID, mName, mType, mCost));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }
}
