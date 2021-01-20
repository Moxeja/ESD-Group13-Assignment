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
import pojo.ClientInfo;
import pojo.EmployeeInfo;

/**
 *
 * @author Tom
 */
public class ManageAppointment {
    private final Connection con;

    ArrayList<String> appointments = new ArrayList<String>();

    public ManageAppointment(ServletContext sc){
        con = (Connection)sc.getAttribute("dbConnection");
    }
  
    public EmployeeInfo getEmployee(String employee){
        String euName ="";
        String eID = "";
        String eName = "";
        String role = "";
        eName = employee;
        
        
        
        try{
            PreparedStatement es = con.prepareStatement("SELECT * FROM employee WHERE ename=?");
            es.setString(1, eName);
            ResultSet rs = es.executeQuery();

            while (rs.next()) {
                String name = rs.getString("ename");
                if (eName.equals(name)) {
                    euName = rs.getString("uname");
                    eID = rs.getString("eid");
                    System.out.println(euName);
                }
            }
            PreparedStatement ds = con.prepareStatement("SELECT * FROM users WHERE uname=?");
            ds.setString(1, euName);
            ResultSet ss = ds.executeQuery();    
            
            while (ss.next()) {
                String uname = ss.getString("uname");
                if (euName.equals(uname)) {
                    System.out.println("If statment worked");
                    role = ss.getString("role");
                }
            }
        }
        catch(SQLException ex){     
        }
        EmployeeInfo EmployeeInfo = new EmployeeInfo(eID, eName, euName, role);
        return EmployeeInfo;
    }
    public EmployeeInfo getEmployeeByID(String employee){
        String euName ="";
        String eID = "";
        String eName = "";
        String role = "";
        eID = employee;

        try{
            PreparedStatement es = con.prepareStatement("SELECT * FROM employee WHERE eid=?");
            es.setString(1, eID);
            ResultSet rs = es.executeQuery();

            while (rs.next()) {
                String eid = rs.getString("eid");
                if (eID.equals(eid)) {
                    euName = rs.getString("uname");
                    eName= rs.getString("ename");
                    eID = rs.getString("eid");
                    System.out.println(euName);
                }
            }
            PreparedStatement ds = con.prepareStatement("SELECT * FROM users WHERE uname=?");
            ds.setString(1, euName);
            ResultSet ss = ds.executeQuery();    
            
            while (ss.next()) {
                String uname = ss.getString("uname");
                if (euName.equals(uname)) {
                    System.out.println("If statment worked");
                    role = ss.getString("role");
                }
            }
        }
        catch(SQLException ex){     
        }
        EmployeeInfo EmployeeInfo = new EmployeeInfo(eID, eName, euName, role);
        return EmployeeInfo;
    }
    
    public ClientInfo getClient(String client){
        String cID = "";
        String cName = "";
        String cType = "";
        String cUname= "";
        try{
             
        cUname = client;    
        PreparedStatement es = con.prepareStatement("SELECT * FROM clients WHERE uname=?");
            es.setString(1, cUname);
            ResultSet as = es.executeQuery();

            while (as.next()) {
                String uname = as.getString("uname");
                if (cUname.equals(uname)) {
                    cID = as.getString("cid");
                    cUname = as.getString("Uname");
                    cType = as.getString("cType");
                    cName = as.getString("cName");
                }
                else{
                    System.out.println(cUname+" did not equal"+uname);
                }
            }
            
    }
        catch(SQLException ex){   
            System.out.println(ex);
        }
        
        ClientInfo ClientInfo = new ClientInfo(cID, cName, "", cType, cUname);
        return ClientInfo;
    }

    public boolean getNewAppointment(String eID, String cID, String time, String date){
        
        try{
        System.out.println("new appointment creation");
        PreparedStatement rs = con.prepareStatement("INSERT INTO booking_slots(EID, CID, SDATE, STIME)" + "VALUES (?, ?, ?, ?)");
            rs.setString(1, eID);
            rs.setString(2, cID);
            rs.setString(3, date);
            rs.setString(4, time);
            rs.executeUpdate();    
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        
        
        return true;
    }
    
    public List<ArrayList<String>> getOldAppointments(ClientInfo ClientInfo){
        List<ArrayList<String>> appointments = new ArrayList<ArrayList<String>>();

        try{
       
        PreparedStatement es = con.prepareStatement("SELECT * FROM booking_slots WHERE cid=?");
            es.setString(1, ClientInfo.cID);
            ResultSet as = es.executeQuery();

            while (as.next()) {
                String cid = as.getString("cid");
                if (ClientInfo.cID.equals(cid)) {
                    ArrayList<String> appointment = new ArrayList<String>();
                    appointment.add(as.getString("sid"));
                    appointment.add(getEmployeeByID(as.getString("eid")).eName);
                    appointment.add(ClientInfo.cName);
                    appointment.add(as.getString("sdate"));
                    appointment.add(as.getString("stime"));
                    appointments.add(appointment);
                }
            }
            
    }
        catch(SQLException ex){   
            System.out.println(ex);
        }
        
        
        return appointments;
    }
    
    public List<ArrayList<String>> getOldAppointmentsStaff(ClientInfo ClientInfo){
        List<ArrayList<String>> appointments = new ArrayList<ArrayList<String>>();

        try{
       
        PreparedStatement es = con.prepareStatement("SELECT * FROM booking_slots WHERE cid=?");
            es.setString(1, ClientInfo.cID);
            ResultSet as = es.executeQuery();

            while (as.next()) {
                String cid = as.getString("cid");
                if (ClientInfo.cID.equals(cid)) {
                    ArrayList<String> appointment = new ArrayList<String>();
                    appointment.add(as.getString("sid"));
                    appointment.add(getEmployeeByID(as.getString("eid")).eName);
                    appointment.add(ClientInfo.cName);
                    appointment.add(as.getString("sdate"));
                    appointment.add(as.getString("stime"));
                    appointments.add(appointment);
                }
            }
            
    }
        catch(SQLException ex){   
            System.out.println(ex);
        }
        
        
        return appointments;
    }
    
    
    
    
    
    
    public boolean destroyOldAppointment(String SID){
        try {
            PreparedStatement es = con.prepareStatement("DELETE FROM booking_slots WHERE sid=?");
            es.setString(1, SID);
            es.executeUpdate();
  
        } catch (SQLException ex) {
            Logger.getLogger(ManageAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
                
    }
    
    
}
