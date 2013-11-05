/*
 *	Fichier:	Cavalier.java
 *	Contenu:	Classe Cavalier
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

public class Cavalier extends Piece {

	public Cavalier(String couleur) {
		this.couleur= couleur;
	}

	@Override
	public boolean validerDep(Position posDepart, Position posFinal) {
            int diffColonne = posFinal.Colonne - posDepart.Colonne;
            int diffLigne = posFinal.ligne - posDepart.ligne;
            
            if(this.validerEchec(posFinal)){
                if ((((diffLigne==1)||(diffLigne==-1))&&((diffColonne==2)||(diffColonne==-2))) || (((diffLigne==2)||(diffLigne==-2))&&((diffColonne==1)||(diffColonne==-1))))
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





}
