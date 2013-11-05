/*
 *	Fichier:	Piece.java
 *	Contenu:	Classe Piece, classe mère de toutes les pièces du jeu d'échecs.
 *
 *	Auteur:		??
 *	Version:	1.0
 *
 *	Date de création:	??
 *	Dernière modification:	-
 *	Raison mise à jour:	-
 *
 *	À faire:    -
 *
*/
package com.STI.entite;

public  abstract class Piece {

    public String getCouleur() {
        return couleur;
    }

   String couleur;
    
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
