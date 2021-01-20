/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Nicola
 */
public class ScheduleInfo {
    
    public final String oID;
    public final String cID;
    public final String eID;
    public final String oDate;
    public final String oTime;
    public final String nSlot;
    public final String charge;
    

    public ScheduleInfo(String cID,String eID, String oID, String oDate, String oTime, String nSlot, String charge) {
        this.cID = cID;
        this.oID = oID;
        this.eID = eID;
        this.oDate = oDate;
        this.oTime = oTime;
        this.nSlot = nSlot;
        this.charge = charge;
    }
}

