/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.ManageAppointment;
import pojo.ClientInfo;
import pojo.EmployeeInfo;


/**
 *
 * @author Tom
 */
public class AppointmentServlet extends HttpServlet {

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
        RequestDispatcher rd = request.getRequestDispatcher("/views/create-appointments-page.jsp");
        if (request.getParameter("employee") != null
                && request.getParameter("date") != null
                && request.getParameter("time") != null) {
            
            // Create login model object
            String employee = (String)request.getParameter("employee");
            String date = (String)request.getParameter("date");
            String time = (String)request.getParameter("time");
            String client = (String)session.getAttribute("username");
            ManageAppointment manageAppointment = new ManageAppointment(getServletContext());

            // Check if the login details provided point to a valid account
            EmployeeInfo employeeInfo  = manageAppointment.getEmployee(employee);
            if ("doctor".equals(employeeInfo.role)||"nurse".equals(employeeInfo.role)) {
                ClientInfo ClientInfo = manageAppointment.getClient(client);
                if (ClientInfo.cID != null){
                    manageAppointment.getNewAppointment(employeeInfo.eID, ClientInfo.cID, time, date);
                    request.setAttribute("msg", "Appointment made successfully");
                }
            } else {
                // Something went wrong
                request.setAttribute("msg", "Invalid Doctor!");
                //RequestDispatcher rd = request.getRequestDispatcher("/views/patient-dashboard.jsp");
                rd.forward(request, response);
            }
        }
        
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
