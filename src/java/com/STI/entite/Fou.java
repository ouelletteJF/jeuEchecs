/*
 *	Fichier:	Fou.java
 *	Contenu:	Classe Fou
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

public class Fou extends Piece{

    public Fou(String couleur) {
        this.couleur= couleur;
        setImage();
    }

    @Override
    public boolean validerDep(Position posDepart, Position posFinal) {
        int diffColonne= posFinal.Colonne-posDepart.Colonne;
        int diffLigne= posFinal.ligne-posDepart.ligne;
        
        if (this.validerEchec(posFinal)) {
            if (((diffLigne==diffColonne)||(diffLigne== -diffColonne)))
                return true;
            
            return false;
        }
        else 
            return false;
    }

    @Override
    public boolean manger(Position posDepart, Position posFinal) {
            // TODO Auto-generated method stub
            return false;
    }

    @Override
    protected void setImage() {
        
        if( "blanc".equals(this.couleur) )
            this.image = "./images/bFou.gif";
        
        else if( "noir".equals(this.couleur) )
            this.image = "./images/nFou.gif";
    }

}
