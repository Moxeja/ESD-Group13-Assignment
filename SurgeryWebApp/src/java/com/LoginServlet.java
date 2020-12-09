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
import models.Login;

/**
 *
 * @author Jake
 */
public class LoginServlet extends HttpServlet {

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
        // Set reponse type
        response.setContentType("text/html;charset=UTF-8");
        
        // Check for already valid session (no need to login again)
        HttpSession hs = request.getSession();
        if (hs.getAttribute("user-type") == null) {
            // Check if user has provided login details
            if (request.getParameter("username") == null
                    || request.getParameter("password") == null) {
                // Ask for login details
                RequestDispatcher rd = request.getRequestDispatcher("/views/login-page.jsp");
                rd.forward(request, response);
            } else {
                // Create login model object
                String username = (String)request.getParameter("username");
                String password = (String)request.getParameter("password");
                Login login = new Login(username, password, getServletContext());
                
                // Check if the login details provided point to a valid account
                String userType = login.getAccountType();
                if (userType != null) {
                    // Create session with account user type attribute and send to dashboard
                    hs.setAttribute("user-type", userType);
                    hs.setAttribute("username", username);
                    response.sendRedirect("Dashboard");
                } else {
                    // Something went wrong
                    request.setAttribute("msg", "Invalid login!");
                    RequestDispatcher rd = request.getRequestDispatcher("/views/login-page.jsp");
                    rd.forward(request, response);
                }
            }
        } else {
            response.sendRedirect("Dashboard");
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
