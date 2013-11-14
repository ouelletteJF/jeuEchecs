/*
 *	Fichier:	Reine.java
 *	Contenu:	Classe Reine
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

public class Reine extends Piece {

    public Reine(String couleur) {
        this.couleur= couleur;
        setImage();
    }

    @Override
    public boolean validerDep(Position posDepart, Position posFinal) {
        int diffColonne= posFinal.Colonne-posDepart.Colonne;
        int diffLigne= posFinal.ligne-posDepart.ligne;
        
        if(this.validerEchec(posFinal)){
            if ((diffLigne==diffColonne)||(diffLigne== -diffColonne)|| ((diffColonne==0)&&(diffLigne!=0))||((diffLigne==0)&&(diffColonne!=0)))
                return true;
            
            return false;
        }
        return false;
    }

    @Override
    public boolean manger(Position posDepart, Position posFinal) {
        return false;
    }

    @Override
    protected void setImage() {
        
        if( "blanc".equals(this.couleur) )
            this.image = "./images/bReine.gif";
        
        else if( "noir".equals(this.couleur) )
            this.image = "./images/reineNoire.gif";
    }	

}
