/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Tom
 */
public class ClientInfo {
    
    public final String cID;
    public final String cName;
    public final String cAddress;
    public final String cType;
    public final String cUname;

    public ClientInfo(String cID, String cName, String cAddress,
            String cType, String cUname){
        this.cID = cID;
        this.cName = cName;
        this.cAddress = cAddress;
        this.cType = cType;
        this.cUname = cUname;
    } 
}
