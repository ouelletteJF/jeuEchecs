/*
 *	Fichier:	Login.java
 *	Contenu:	Servlet qui gère la connexion d'un joueur.
 *
 *	Auteur:		??
 *	Version:	1.0
 *
 *	Date de création:	??
 *	Dernière modification:	-
 *	Raison mise à jour:	-
 *
 *	À faire:    
 *
*/
package com.STI.servlet;

//~--- Non-JDK imports --------------------------------------------------------

import com.STI.dao.*;
import com.STI.dao.Userdao;
import com.STI.entite.Utilisateur;
import com.STI.jdbc.Connexion;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ilyes
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String u = request.getParameter("nom"),
               p = request.getParameter("mdp");

        // Si aucun nom d'utilisateur n'est saisi...
        if ((u == null) || u.trim().equalsIgnoreCase("")) {
            request.setAttribute("message", "Le nom d'utilisateur est obligatoire");

            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/login.jsp");
            r.forward(request, response);

            return;
        }
        
        // Connexion à la BD
        try {
            Class.forName(this.getServletContext().getInitParameter("piloteJdbc"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connexion.setUrl(this.getServletContext().getInitParameter("urlBd"));

        Userdao     dao  = new Userdao(Connexion.getInstance());
        Utilisateur user = dao.read(u.trim());

        // Utilisateur inexistant
        if (user == null) {
            request.setAttribute("message", "Utilisateur " + u + " inexistant.");

            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp");
            r.forward(request, response);
        } 
        // Mot de passe incorrect
        else if (!user.getMdp().equals(p)) {
            request.setAttribute("message", "Mot de passe incorrect.");

            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp");
            r.forward(request, response);
        }
        // Connexion OK 
        else {
            HttpSession session = request.getSession(true);

            user.setPlay(false);
            session.setAttribute("connecte", user);
            
            this.getServletContext().getRequestDispatcher("/index.jsp?action=accueil").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }    // </editor-fold>
}


//~ Formatted by Jindent --- http://www.jindent.com
