/*
 *	Fichier:	Echiquier.java
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

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "echiquier")
@XmlRootElement


public class Echiquier implements Serializable {
    int max = 8;
    @Id
    Piece[][] listPieces = new Piece[max][max];
    Position posPieceCourante;
	
    public Echiquier() 
    {
        Piece[] pieceB= {new Tour("blanc"), new Cavalier("blanc"), new Fou("blanc"), new Roi("blanc"), new Reine("blanc"), new Fou("blanc"), new Cavalier("blanc"), new Tour("blanc") };
        Piece[] pieceN= {new Tour("noir"),  new Cavalier("noir"),  new Fou("noir"),  new Reine("noir"), new Roi("noir"),   new Fou("noir"),  new Cavalier("noir"),  new Tour("noir")  };

        listPieces[0]= pieceB;
        listPieces[7]= pieceN;
        
        for (int j=0; j< max; j++)
        {
            listPieces[1][j]= new Pion("blanc");
            listPieces[6][j]= new Pion("noir");
        }
    }
	
    public boolean deplacer( Position posB)
    {   
        if (listPieces[posPieceCourante.ligne][posPieceCourante.Colonne] == null)
        {
            return false;
        }

        else if (listPieces[posPieceCourante.ligne][posPieceCourante.Colonne].validerDep(posPieceCourante, posB))
        { 	
            listPieces[posB.ligne][posB.Colonne]= listPieces[posPieceCourante.ligne][posPieceCourante.Colonne];
            listPieces[posPieceCourante.ligne][posPieceCourante.Colonne]= null;
            return true;
        }
        else 
            return false;
    }
	
    public void selectionnee(Position pos)
    {	
        posPieceCourante= pos;
    }
    
    public Piece get(int i, int j)
    {
        return this.listPieces[i][j];
    }

    public Piece[][] getListPieces() {
        return listPieces;
    }

    public Position getPosPieceCourante() {
        return posPieceCourante;
    }

    public void setListPieces(Piece[][] listPieces) {
        this.listPieces = listPieces;
    }

    public void setPosPieceCourante(Position posPieceCourante) {
        this.posPieceCourante = posPieceCourante;
    }
}
