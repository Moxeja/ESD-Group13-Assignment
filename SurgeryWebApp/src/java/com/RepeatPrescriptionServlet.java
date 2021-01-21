/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.RepeatPrescriptions;
import pojo.MedicinesInfo;

/**
 *
 * @author Jake
 */
public class RepeatPrescriptionServlet extends HttpServlet {

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

        // Retrieve clients prescriptions
        RepeatPrescriptions rp = new RepeatPrescriptions(getServletContext());
        ArrayList<MedicinesInfo> info = rp.getPrescriptions((String) request.getSession().getAttribute("username"));
        request.setAttribute("prescriptions", info);

        // Check if the client has requested medication
        if (request.getParameter("medication") != null) {
            boolean validInput = false;
            int mID = Integer.parseInt(request.getParameter("medication"));

            // Check the mID the client gave is valid for them
            for (MedicinesInfo meds : info) {
                if (meds.mID == mID) {
                    validInput = true;
                }
            }

            if (validInput) {
                request.setAttribute("msg", "Request received.");
            } else {
                request.setAttribute("msg", "Invalid medication ID entered.");
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher("/views/repeat-prescription-page.jsp");
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
