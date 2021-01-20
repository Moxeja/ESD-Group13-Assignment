/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.RetrievePatientsDate;
import pojo.ClientInfo;

/**
 *
 * @author jamie
 */
public class ListPatientsDateServlet extends HttpServlet {

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
        String start1Date = "";
        String end1Date = "";
        //Date startDate = new Date();
        //Date endDate = new Date();
        response.setContentType("text/html;charset=UTF-8");
            // Create array to hold client info
        ArrayList<ClientInfo> data = new ArrayList<>();    
            start1Date = request.getParameter("startDate");
            end1Date = request.getParameter("endDate");

            if (start1Date != null && end1Date != null) {
            try {
                DateFormat Formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = Formatter.parse(start1Date);
                Date endDate = Formatter.parse(end1Date);
                // Create model and retrieve appropriate patients by type
                RetrievePatientsDate rp = new RetrievePatientsDate(
                        getServletContext());

                    data = rp.getClients(startDate, endDate);
  
            } catch (ParseException ex) {
                Logger.getLogger(ListPatientsDateServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            }

            // Forward to the viewer page
            request.setAttribute("data", data);
            RequestDispatcher rd = request.getRequestDispatcher("/views/retrieve-patients-date.jsp");
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
