/*
 *	Fichier:	Partie.java
 *	Contenu:	??
 *
 *	Auteur:		??
 *	Version:	1.0
 *
 *	Date de création:	??
 *	Dernière modification:	9 novembre 2013
 *	Raison mise à jour:	Ajout d'attributs à la classe
 *
 *	À faire:    
 *
*/
package com.STI.entite;

public class Partie {
    private String nom = "", joueur1 = "", joueur2 = "";
    private Integer tour;
    private Echiquier table;

     
    public Partie() 
    {
        this("", "", "");	
    }
    public Partie(String nomPartie, String j1, String j2) {
        this.nom = nomPartie;
        this.joueur1 = j1;
        this.joueur2 = j2;
        this.tour = 1;
        this.table = new Echiquier();
    }
    
    
    public void setNom(String nomPartie) {
        this.nom = nomPartie;
    }
    public String getNom() {
        return this.nom;
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
    
    
    public void setTour(Integer tourJoueur) {
        this.tour = tourJoueur;
    }
    public Integer getTour() {
        return this.tour;
    }
    
    
    public void setTable(Echiquier table) {
        this.table = table;
    }
    public Echiquier getTable() {
        return table;
    }
    
    public void setTourDebut(){     // pour generer aléatoirement le premier qui jouera    
    int rdm = (int) (Math.random() * 2 );
    this.setTour(rdm);
    
    }  
    
	
		
}
