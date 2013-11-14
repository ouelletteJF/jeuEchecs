
/*
 *	Fichier:	updateChessboard_AJAX.java
 *	Contenu:	Fichier JS (AJAX) qui permet le rafraichissement des échiquiers des joueurs d'une partie.
 *
 *	Auteur:		Jean-François Ouellette
 *	Version:	1.0
 *
 *	Date de création:	12 novembre 2013
 *	Dernière modification:	-
 *	Raison mise à jour:	-
 *
 *	À faire:    
 *
*/

package com.STI.servlet;

import com.STI.entite.Partie;
import com.STI.entite.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aaa
 */
public class UpdateGame extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String resultat = "[";
        HttpSession session = request.getSession(true);
        Map<String, Partie> parties = (HashMap<String,Partie>)this.getServletContext().getAttribute("parties");
        Utilisateur connectedUser = (Utilisateur)session.getAttribute("connecte");
        
        // Chaque ligne ajoutée à résultat est une combinaison de l'id de la case et de l'image à insérer
        for(int i = 1; i <= 8; i++)
            for(int j = 1; j <= 8; j++) 
                if( parties.get( connectedUser.getGameId() ).getTable().get(i - 1, j - 1) != null ) // BUG ICI
                    resultat += "{ \"id\" : \"#l" + i + "c" + j +"\", \"image\": \"" + parties.get( connectedUser.getGameId() ).getTable().get(i - 1, j - 1).getImage() + "\" }, ";
        
        resultat += "]";
        
        response.getWriter().write(resultat);
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
