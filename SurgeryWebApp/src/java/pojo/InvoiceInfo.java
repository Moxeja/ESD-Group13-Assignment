/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Jake
 */
public class InvoiceInfo {
    
    public final int iID;
    public final int cID;
    public final int oID;
    public final boolean iPaid;
    
    public InvoiceInfo(int iID, int cID, int oID, boolean iPaid) {
        this.iID = iID;
        this.cID = cID;
        this.oID = oID;
        this.iPaid = iPaid;
    }
}
