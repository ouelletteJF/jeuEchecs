/*
 *	Fichier:	Piece.java
 *	Contenu:	Classe Piece, classe mère de toutes les pièces du jeu d'échecs.
 *
 *	Auteur:		??
 *	Version:	1.0
 *
 *	Date de création:	??
 *	Dernière modification:	13 novembre 2013
 *	Raison mise à jour:	Ajout de la méthode setImage() et de l'attribut image
 *
 *	À faire:    -
 *
*/
package com.STI.entite;

public  abstract class Piece {

    String couleur;
    String image;
    
    
    public String getCouleur() {
        return this.couleur;
    }
    
    public String getImage() {
        return this.image;
    }
    
    protected abstract void setImage();    
    public abstract boolean validerDep(Position posDepart, Position posFinal);
    public abstract boolean manger(Position posDepart, Position posFinal);
    public boolean validerEchec(Position posFinal)
    {
        if( ((posFinal.getLigne()<=8) && (posFinal.getColonne()<=8)) &&
            ((posFinal.getLigne()>0) && (posFinal.getColonne()>0)) ){
            return true;
        }

        return false;
    }
   
}
