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

/**
 *
 * @author Jake
 */
public class DashboardServlet extends HttpServlet {

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

        // Get session user type and forward them to the appropriate dashboard
        HttpSession hs = request.getSession();
        String loginType = (String) hs.getAttribute("user-type");
        if (loginType != null) {
            switch (loginType) {
                case "admin": {
                    RequestDispatcher rd = request.getRequestDispatcher("/views/admin-dashboard.jsp");
                    rd.forward(request, response);
                } break;
                case "doctor":
                case "nurse": {
                    RequestDispatcher rd = request.getRequestDispatcher("/views/medical-staff-dashboard.jsp");
                    rd.forward(request, response);
                } break;
                case "client": {
                    RequestDispatcher rd = request.getRequestDispatcher("/views/patient-dashboard.jsp");
                    rd.forward(request, response);
                } break;
                default: {
                    RequestDispatcher rd = request.getRequestDispatcher("/views/login-page.jsp");
                    rd.forward(request, response);
                } break;
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/Login");
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
