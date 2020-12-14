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
import models.RegisterEmployee;

/**
 *
 * @author Jake
 */
public class AddStaffServlet extends HttpServlet {

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
        
        // Check the details have been entered
        if (request.getParameter("username") == null
                || request.getParameter("password") == null
                || request.getParameter("name") == null
                || request.getParameter("address") == null) {
            // Ask for register details
            RequestDispatcher rd = request.getRequestDispatcher("/views/register-employee-page.jsp");
            rd.forward(request, response);
        } else {
            // Create register model object
            String username = (String)request.getParameter("username");
            String password = (String)request.getParameter("password");
            String name = (String)request.getParameter("name");
            String address = (String)request.getParameter("address");
            String type = (String)request.getParameter("type");

            // Use register employee model
            RegisterEmployee re = new RegisterEmployee(username, password,
                    name, address, type, getServletContext());

            // Check if the login details provided point to a valid account
            boolean exists = re.checkAccountExists();
            if (exists) {
                // Warn user that account with that username already exists
                request.setAttribute("msg", "Account username already exists!");
                RequestDispatcher rd = request.getRequestDispatcher("/views/register-employee-page.jsp");
                rd.forward(request, response);
            } else {
                boolean added = re.registerNewAccount();
                if (added) {
                    // Create session information
                    request.setAttribute("msg", "Account has been created successfully!");
                    RequestDispatcher rd = request.getRequestDispatcher("/views/register-employee-page.jsp");
                    rd.forward(request, response);
                } else {
                    // Warn user that there was a problem
                    request.setAttribute("msg", "Account could not be added!");
                    RequestDispatcher rd = request.getRequestDispatcher("/views/register-employee-page.jsp");
                    rd.forward(request, response);
                }
            }
        }
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
