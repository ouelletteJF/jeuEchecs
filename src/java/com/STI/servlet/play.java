/*
 *	Fichier:	play.java
 *	Contenu:	Servlet qui gère les changements entre les modes «Joueur» et «Observateur»
 *
 *	Auteur:		??
 *	Version:	??
 *
 *	Date de création:	??
 *	Dernière modification:	2 novembre 2013
 *	Raison mise à jour:	Simplifaction du code, ajout de commentaires et ajustement de l'indentation.
 *
 *	À faire:    Le code peut probablement encore être simplifié et les noms des paramètres ne sont pas toujours clairs. Il pourrait
 *                  être pertinent de les changer.
 *
*/

package com.STI.servlet;

//~--- non-JDK imports --------------------------------------------------------

import com.STI.dao.Userdao;
import com.STI.entite.Utilisateur;
import com.STI.jdbc.Connexion;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usager
 */

public class play extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);
        Userdao     dao     = new Userdao(Connexion.getInstance());
        Utilisateur user    = (Utilisateur)session.getAttribute("connecte");
        List<Utilisateur> connectes = (List<Utilisateur>)this.getServletContext().getAttribute("connectes");
        
        // Si le joueur entre en mode «Joueur»
        if ( "play".equals(request.getParameter("activity")) ) {     
            dao.updatePlay(user, 1);
            user.setPlay(true);
            
            if (connectes.contains(user) == false)
                connectes.add(user);
        }
        // Si le joueur entre en mode «Observateur»
        else if ( "observe".equals(request.getParameter("activity")) ) {     
            dao.updatePlay(user, 0);
            user.setPlay(false);
            connectes.remove(user);
        }
        
        this.getServletContext().setAttribute("connectes", connectes);
        
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
    }    // </editor-fold>
}


//~ Formatted by Jindent --- http://www.jindent.com
