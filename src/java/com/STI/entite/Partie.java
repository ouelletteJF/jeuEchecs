/*
 *	Fichier:	Partie.java
 *	Contenu:	??
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
package com.STI.entite;
public class Partie {
    Echiquier table;

    public void setTable(Echiquier table) {
        this.table = table;
    }
     
    public Partie() 
    {
        this.table= new Echiquier();	
    }

    public Partie(Echiquier e) 
    {
        this.table = e;	
    }

    public Echiquier getTable() {
        return table;
    }
	
		
}
