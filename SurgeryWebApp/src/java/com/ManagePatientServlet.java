/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.ManagePatients;
import pojo.ClientInfo;
import pojo.EmployeeInfo;


/**
 *
 * @author Tom
 */
@WebServlet(name = "ForwardPatientServlet", urlPatterns = {"/Staff/ForwardPatientServlet"})
public class ManagePatientServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        RequestDispatcher rd = request.getRequestDispatcher("/views/ManagePatients-page.jsp");
        ManagePatients getPatients = new ManagePatients(getServletContext());
        EmployeeInfo currentEmployee = getPatients.getEmployee(username);
        
        if(request.getParameter("cName") != null && request.getParameter("reason") != null && request.getParameter("location") != null && request.getParameter("specialist") != null) 
           {
            // Ask for login details {
            // Create login model object
            String customerName = (String)request.getParameter("cName");
            String reason = (String)request.getParameter("reason");
            String location = (String)request.getParameter("location");
            String specialist = (String)request.getParameter("specialist");
            
            StringBuilder requestcompile = new StringBuilder();
            
            requestcompile.append(" Address: "+ location);
            requestcompile.append("\n\n Request of Transfer");
            requestcompile.append("\n We Request that "+customerName+" is transfered to "+location+" to see a "+specialist+ " specialist");
            requestcompile.append("\n\n Reason: "+reason);
            requestcompile.append("\n\n Sincerily, "+currentEmployee.eName);
            
            String formalRequest = requestcompile.toString();
            request.setAttribute("request", formalRequest);
        }
        
        
        
       
        
        List<ArrayList<String>> clients = new ArrayList<>();

        
        
        ArrayList<ClientInfo> clientList = getPatients.getClients(currentEmployee.eID);
        
        request.setAttribute("data", clientList);

        rd.forward(request, response);
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
