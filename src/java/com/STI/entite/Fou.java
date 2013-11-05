package com.STI.entite;

public class Fou extends Piece{

	public Fou(String couleur) {
		this.couleur= couleur;
	}

	@Override
	public boolean validerDep(Position posDepart, Position posFinal) {
		int diffColonne= posFinal.Colonne-posDepart.Colonne;
		int diffLigne= posFinal.ligne-posDepart.ligne;
		if (this.validerEchec(posFinal)){
		if (((diffLigne==diffColonne)||(diffLigne== -diffColonne)))
			return true;
		return false;
	}else return false;
                
        }

	@Override
	public boolean manger(Position posDepart, Position posFinal) {
		// TODO Auto-generated method stub
		return false;
	}



}
