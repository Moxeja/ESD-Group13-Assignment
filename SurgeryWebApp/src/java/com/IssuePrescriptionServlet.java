/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.ManagePatients;
import models.Prescriptions;
import pojo.ClientInfo;
import pojo.EmployeeInfo;


/**
 *
 * @author Dominika
 * 
 */
public class IssuePrescriptionServlet extends HttpServlet {

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
        RequestDispatcher rd = request.getRequestDispatcher("/views/issue-prescription.jsp");
        ManagePatients getPatients = new ManagePatients(getServletContext());
        EmployeeInfo currentEmployee = getPatients.getEmployee(username);
        
       
       //Issue Prescription 
        Prescriptions prescriptions = new Prescriptions(getServletContext());
        request.setAttribute("medicines", prescriptions.getMedicines());
        
       if(request.getParameter("cID") != null && request.getParameter("medicines") != null) 
               {
                   int cID = Integer.parseInt(request.getParameter("cID"));
                   
                   int mID = Integer.parseInt(request.getParameter("medicines"));
                   
                   prescriptions.addPrescription(cID, mID);
                }
//        }
       
       
        
        
        //Client Display info
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
