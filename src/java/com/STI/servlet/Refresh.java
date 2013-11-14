/*
 *	Fichier:	Refresh.java
 *	Contenu:	Gère le rafraichissement des informations de la page.
 *
 *	Auteur:		??
 *	Version:	1.0
 *
 *	Date de création:	??
 *	Dernière modification:	2 novembre 2013
 *	Raison mise à jour:	Correction de l'indentation et ajout de quelques commentaires.
 *
 *	À faire:    Où est-elle appelée? À regarder plus en détails.
 *
*/
package com.STI.servlet;

import com.STI.entite.Partie;
import com.STI.entite.Invitation;
import com.STI.entite.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author eikichie
 */
@WebServlet(name = "Refresh", urlPatterns = {"/Refresh"})
public class Refresh extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession(true);
        Utilisateur user, connectedUser = (Utilisateur)session.getAttribute("connecte");
        
        String resultat = "{";
        String usersList = "";
        String invitationsList = "";

        List<Utilisateur> connectedUsers = (List<Utilisateur>)this.getServletContext().getAttribute("connectes");
        Map<String, List<Invitation> > invitations = (HashMap<String, List<Invitation> >)this.getServletContext().getAttribute("invitations");
        Map<String, Partie> parties = (HashMap<String,Partie>)this.getServletContext().getAttribute("parties");

        int nbUsers = connectedUsers.size();

        /****************** JOUEURS CONNECTÉS ******************/
        
        if ( nbUsers > 0 )
        {   
            if( nbUsers == 1 && connectedUser.isPlay() )
                usersList = "Aucun joueur n'est connect&eacute.";
            else {
                usersList += "<table>";

                for (int i = 0; i < nbUsers; i++)
                {
                    user = (Utilisateur)connectedUsers.get(i);  // Récupère un joueur dans la liste de joueurs connectés 

                    if ( !user.getName().equals(connectedUser.getName()) )   // Si ce n'est pas le joueur connecté...
                        usersList += "<tr> <td> <a href='inviterJoueur.exe?action=invitePlayer&&invitedPlayer=" + user.getName() + "' >" + user.getName() + "</a></td></tr>";
                }

                usersList += "</table>";
            }
        }            
        else
            usersList = "Aucun joueur n'est connect&eacute.";

        resultat += " \"utilisateursConnectes\": \"" + usersList + "\",";


        /****************** INVITATION ******************/        
        if ( invitations.containsKey(connectedUser.getName()) )     // Si l'objet Application «invitations» contient un enregistrement portant le nom du joueur connecté...
        {  
            invitationsList += "<table>";
            
            List<Invitation> tInvitations = invitations.get(connectedUser.getName());

            for(int i=0; i < tInvitations.size(); i++)
                invitationsList += "<tr> <td> <a href='launchGame.exe?action=launchGame&&player1=" + tInvitations.get(i).getJoueur1() + "&&player2=" + connectedUser.getName() + "' >" + tInvitations.get(i).getJoueur1() + "</a> </td> </tr>";

            invitationsList += "</table>";
        }
        else
            invitationsList += "Vous n'avez aucune invitation.";
        
        resultat += " \"invitations\": \"" + invitationsList + "\",";
           
            
        /****************** PARTIE ******************/
        String tParties = ""; 
        Object tabParties[] = parties.values().toArray();
        
        if(parties.size() > 0) {
            tParties += "<table>";
            
            for(int i = 0; i < parties.size(); i++)
                tParties += "<tr> <td> " + ((Partie)tabParties[i]).getNom() + "</td> </tr>";
            
            tParties += "</table>";
        }
        else
            tParties += "Il n'y a aucune partie en cours.";

        resultat += " \"parties\": \"" + tParties + "\",";


        /****************** PARTIE AVEC JOUEUR CONNECTÉ DÉBUTE? ******************/
        String startGame = "no";
        
        if( ( ("").equals(connectedUser.getGameId()) ) && parties.containsKey(connectedUser.getName()) ) {
            startGame = "yes";
            connectedUser.setGameId(connectedUser.getName());
        }
        
        resultat += " \"startGame\": \"" + startGame + "\"}";
        
        response.getWriter().write(resultat);
        
        /*
        
        if (( this.getServletContext().getAttribute("CreateGame") != null) && ("true".equals((String)this.getServletContext().getAttribute("indice"))))
        {
            Map<String, Partie> partie = (HashMap<String,Partie>) this.getServletContext().getAttribute("parties"); 
            Partie p = new Partie();
            partie.put("allo", p);
            String joueurs= (String)this.getServletContext().getAttribute("CreateGame");
            this.getServletContext().setAttribute("parties", partie);
            this.getServletContext().setAttribute("echec",p.getTable());
            this.getServletContext().setAttribute("Gamers", joueurs);
            this.getServletContext().setAttribute("indice", "false");
        }   */ 
         
        
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
