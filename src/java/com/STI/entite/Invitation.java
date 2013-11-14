/*
 *	Fichier:	Invitation.java
 *	Contenu:	Classe Invitation (utilisé pour le tableau d'invitations dans l'objet Application)
 *
 *	Auteur:		Jean-François Ouellette
 *	Version:	1.0
 *
 *	Date de création:	9 novembre 2013
 *	Dernière modification:	-
 *	Raison mise à jour:	-
 *
 *	À faire:    -
 *
*/
package com.STI.entite;

import java.util.Date; 

public class Invitation {
    
    private String joueur1 = "", joueur2 = "";      // Joueur1 est le joueur lançant l'invitation
    private Boolean bActive; 
    
    
    public Invitation() 
    { 
        this("", "");
    }
    public Invitation(String j1, String j2) {
        this.joueur1 = j1;
        this.joueur2 = j2;
        this.bActive = true;
    }
         
    
    public void setJoueur1(String nom) {
        this.joueur1 = nom;
    }
    public String getJoueur1() {
        return this.joueur1;
    }
    
    
    public void setJoueur2(String nom) {
        this.joueur2 = nom;
    }
    public String getJoueur2() {
        return this.joueur2;
    }
    
    
    public void setActive(Boolean actif) {
        this.bActive = actif;
    }
    public Boolean isActive() {
        return this.bActive;
    }
}
