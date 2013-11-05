/*
 *      NON PERTINENT POUR LE TP
 *         
 *	Fichier:	ProfiluPDATE.java
 *	Contenu:	Servlet qui met à jour le profil du joueur lorsqu'il est modifié dans la page Profil.
 *
 *	Auteur:		??
 *	Version:	1.0
 *
 *	Date de création:	??
 *	Dernière modification:	-
 *	Raison mise à jour:	-
 *
 *	À faire:    -
 *
*/
package com.STI.servlet;

import com.STI.dao.Userdao;
import com.STI.entite.Utilisateur;
import com.STI.jdbc.Connexion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author s4d3k
 */
public class ProfilUpdate extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String     user = (String)session.getAttribute("connecte"),
                   psw     =  request.getParameter("mdpProfil"),
                   email   =  request.getParameter("courrielProfil");
        Utilisateur u        = new Utilisateur(user, psw, email);
        Userdao     dao      = new Userdao(Connexion.getInstance()); 
       
        System.out.println(user);
        System.out.println(psw);
        System.out.println(email);
        
        if (dao.updateUserInfo(u)) {
            System.out.println("Mise à jour effectuée.");
        } else {
            System.out.println("Mise à jour non effectuée.------------------------------------");
        }

        this.getServletContext().getRequestDispatcher("/index.jsp?action=acceuil").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
