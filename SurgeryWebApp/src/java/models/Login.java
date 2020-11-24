/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.servlet.ServletContext;

/**
 *
 * @author Jake
 */
public class Login {
    
    private String username;
    private String password;
    private ServletContext sc;
    
    public Login(String username, String password, ServletContext sc) {
        this.username = username;
        this.password = password;
        this.sc = sc;
    }
    
    public String getAccountType() {
        return null;
    }
}
