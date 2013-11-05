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
        
        Utilisateur user;

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String resultat= "{";
        String rConnectUsers="";
        String invitation= "Vous &ecirctes invit&eacutes par : ";

        List<Utilisateur> ConnectedUsers = (List<Utilisateur>)this.getServletContext().getAttribute("connectes");
        Map<String, String> invitations = (HashMap<String, String>)this.getServletContext().getAttribute("invitations");
        Map<String, Partie> parties = (HashMap<String,Partie>) this.getServletContext().getAttribute("parties");

        int sizeConnectUsers= ConnectedUsers.size();

        /****************** JOUEURS CONNECTÉS ******************/
        
        if (sizeConnectUsers > 0)
        {   
            rConnectUsers += "<table>";
            String name= (String)request.getSession().getAttribute("connecte"); // Récupère le nom du joueur connecté

            for (int i=0; i < sizeConnectUsers; i++)
            {
                user = (Utilisateur)ConnectedUsers.get(i);  // Récupère un joueur dans la liste de joueurs connectés 

                if (!user.getName().equals(name))   // Si c'est le joueur connecté...
                {
                    rConnectUsers += "<tr> <td> <a href='Inviter.exe?action=request&&invited=" + user.getName() + "' >" + user.getName() + "</a></td></tr>";
                } 
            }

            rConnectUsers += "</table>";
        }
        else{
            rConnectUsers = "Aucun joueur connect&eacute.";
        }

        resultat += " \"ConnectUsers\": \"" + rConnectUsers + "\",";


        /****************** INVITATION ******************/
        
        if (invitations.containsKey((String) request.getSession().getAttribute("connecte")))
        {  
            String invited= (String)request.getSession().getAttribute("connecte");
            String lien= invitations.get((String) request.getSession().getAttribute("connecte"));
            String[] tabInvite = lien.split(",");

            for(int i=0; i < tabInvite.length; i++)
            {
                tabInvite[i]= "<a href='startParty.exe?action=Game&&players="+tabInvite[i]+","+invited+"' >"+tabInvite[i]+"</a>";
                invitation+= tabInvite[i]+", "; 
            }

            resultat += " \"invitation\": \""+invitation+"\",";//invitation+",";
        }
        else {
            resultat += " \"invitation\": \"\",";//invitation+",";
        }
           
            
        /****************** PARTIE ******************/
        
        String PartieName= (String)request.getParameter("players");
        String sParties = "";
        Set e = parties.keySet();
        Iterator<String> it = e.iterator();
        
        while (it.hasNext())
        {
            String x = it.next();
            sParties += x+"<br />";
        }

        resultat += " \"parties\": \""+sParties+"\"";//invitation+",";
        resultat+= "}";

        response.getWriter().write(resultat);

        if (( this.getServletContext().getAttribute("CreateGame") != null) && ("true".equals((String)this.getServletContext().getAttribute("indice"))))
        {
            Map<String, Partie> partie = (HashMap<String,Partie>) this.getServletContext().getAttribute("parties"); 
            Partie p = new Partie();
            partie.put(PartieName, p);
            String joueurs= (String)this.getServletContext().getAttribute("CreateGame");
            this.getServletContext().setAttribute("parties", partie);
            this.getServletContext().setAttribute("echec",p.getTable());
            this.getServletContext().setAttribute("Gamers", joueurs);
            this.getServletContext().setAttribute("indice", "false");
        }    
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
