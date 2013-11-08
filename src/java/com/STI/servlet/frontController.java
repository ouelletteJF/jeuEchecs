/*
 *	Fichier:	frontController.java
 *	Contenu:	Servlet qui sert de contrôleur frontal. Elle redirige les requêtes vers les pages adéquates.
 *
 *	Auteur:		??
 *	Version:	1.0
 *
 *	Date de création:	??
 *	Dernière modification:	-
 *	Raison mise à jour:	-
 *
 *	À faire:    Où cette classe est-elle utilisée?
 *
*/
package com.STI.servlet;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usager
 */

public class frontController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        try {
            String choix = request.getParameter("action");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp");

            if (choix != null) {
                if ("login".equals(choix)) {
                    r = this.getServletContext().getRequestDispatcher("/signIn");
                    r.forward(request, response);
                    return;
                }

                if ("connectUser".equals(choix.trim())) {
                    r = this.getServletContext().getRequestDispatcher("/connectUser");
                    r.forward(request, response);
                    return;
                }

                if ("logout".equals(choix)) {
                    r = this.getServletContext().getRequestDispatcher("/signOut");
                    r.forward(request, response);
                    return;
                }
                if ("refresh".equals(choix)) {
                    r = this.getServletContext().getRequestDispatcher("/refresh");
                    r.forward(request, response);
                    return;
                }

                if ("subscribe".equals(choix)) {
                    r = this.getServletContext().getRequestDispatcher("/subscribe");
                    r.forward(request, response);
                    return;
                }
                
                if ("invite".equals(choix)) {
                    r = this.getServletContext().getRequestDispatcher("/invite");
                    r.forward(request, response);
                    return;
                }

                if ("request".equals(choix)) {
                    r = this.getServletContext().getRequestDispatcher("/request");
                    r.forward(request, response);
                    return;
                }

                if ("play".equals(choix)) {
                    r = this.getServletContext().getRequestDispatcher("/play");
                    r.forward(request, response);
                    return;
                }
                if ("Game".equals(choix))
                {
                    r = this.getServletContext().getRequestDispatcher("/Game");  
                    r.forward(request, response);                 
                    return;
                }

                if ("showProfile".equals(choix))
                {
                    r = this.getServletContext().getRequestDispatcher("/showProfile");  
                    r.forward(request, response);                 
                    return;
                }
                if ("updateProfile".equals(choix))
                {
                    r = this.getServletContext().getRequestDispatcher("/updateProfile");  
                    r.forward(request, response);                 
                }
                
                if ("regles".equals(choix))
                {
                    r = this.getServletContext().getRequestDispatcher("/index.jsp"); 
                    r.forward(request, response);     
                    return;
                } 
                
                if ("subscription".equals(choix)) {
                    r = this.getServletContext().getRequestDispatcher("/index.jsp");
                    r.forward(request, response);
                    return;
                }
                
                if ("accueil".equals(choix))
                {
                    r = this.getServletContext().getRequestDispatcher("/index.jsp");  
                    r.forward(request, response);                   
                    return;
                }
            }
        }
        finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }    // </editor-fold>
}


//~ Formatted by Jindent --- http://www.jindent.com
