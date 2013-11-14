/*
 *	Fichier:	Pion.java
 *	Contenu:	Classe Pion
 *
 *	Auteur:		??
 *	Version:	1.0
 *
 *	Date de création:	??
 *	Dernière modification:	13 novembre 2013
 *	Raison mise à jour:	Ajout de la méthode setImage() dans le constructeur et de sa surdéfinition
 *
 *	À faire:    -
 *
*/

package com.STI.entite;

public class Pion extends Piece {
  
	
    public Pion(String couleur)
    {
        this.couleur = couleur;
        setImage();
    }

    @Override
    public boolean validerDep(Position posDepart, Position posFinal) {
        int diffColonne= posFinal.Colonne-posDepart.Colonne;
        int diffLigne= posFinal.ligne-posDepart.ligne;
        //verifier si cest son premier coups et donc accepter lavance de deux cases

        if (this.validerEchec(posFinal)) {		// verifier si le deplacement est d'une case de colonne
            if ( (diffLigne==-1) && (diffColonne==0) )
                return true;

            return false;
        }
        
        return false;
    }

    @Override
    public boolean manger(Position posDepart, Position posFinal) {
        int diffColonne= posFinal.Colonne-posDepart.Colonne;
        int diffLigne= posFinal.ligne-posDepart.ligne;

        if ((diffLigne==1)&&((diffColonne==1)||(diffColonne==-1)) )
        {
            return true;
        }
        
        return false;
    }

    @Override
    protected void setImage() {
        
        if( "blanc".equals(this.couleur) )
            this.image = "./images/bPion.gif";
        
        else if( "noir".equals(this.couleur) )
            this.image = "./images/nPion.gif";
    }	
}
