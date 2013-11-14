/*
 *	Fichier:	Request.java
 *	Contenu:	Servlet qui ajoute une invitation à la liste d'invitations d'un utilisateur
 *
 *	Auteur:		??
 *	Version:	1.0
 *
 *	Date de création:	??
 *	Dernière modification:	2 novembre 2013
 *	Raison mise à jour:	Suppression de commentaires.
 *
 *	À faire:    
 *
*/
package com.STI.servlet;

import com.STI.dao.Userdao;
import com.STI.entite.Utilisateur;
import com.STI.entite.Invitation;
import com.STI.jdbc.Connexion;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author s4d3k
 */
public class Request extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Utilisateur user = (Utilisateur)session.getAttribute("connecte");
        String invitedPlayer = request.getParameter("invitedPlayer");
              
        Map<String, List<Invitation> > invitations = (HashMap<String, List<Invitation> >)this.getServletContext().getAttribute("invitations");
        List<Invitation> tempList = new LinkedList();
        
        if (invitations.containsKey(invitedPlayer))
            tempList = invitations.get(invitedPlayer);
            
        tempList.add( new Invitation(user.getName(), invitedPlayer) );
        invitations.put(invitedPlayer, tempList);

        this.getServletContext().setAttribute("invitations", invitations);        
        this.getServletContext().setAttribute("invited", invitedPlayer);
        
        this.getServletContext().getRequestDispatcher("/index.jsp?action=accueil").forward(request, response);
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
    }// </editor-fold>
}
