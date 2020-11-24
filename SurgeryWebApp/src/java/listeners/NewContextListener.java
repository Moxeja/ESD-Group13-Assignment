/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Jake
 */
public class NewContextListener implements ServletContextListener {
    
    // Database connection to be used throughout app life
    private Connection con;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Retrieve database information from ServletContext init params
        ServletContext sc = sce.getServletContext();
        String dbName = sc.getInitParameter("dbName");
        String dbUser = sc.getInitParameter("dbUser");
        String dbPass = sc.getInitParameter("dbPass");
        
        try {
            // Load database driver and make a connection
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/"+dbName, dbUser, dbPass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NewContextListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Create an attribute that holds the database connection
        sc.setAttribute("dbConnection", con);
        System.out.println("Set database connection attribute to: " + con);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            // Remove attribute from the ServletContext
            ServletContext sc = sce.getServletContext();
            sc.removeAttribute("dbConnection");
            
            // Close the database connection
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(NewContextListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
