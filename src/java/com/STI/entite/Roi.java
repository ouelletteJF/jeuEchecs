package com.STI.entite;

public class Roi extends Piece {

	public Roi(String couleur){
		this.couleur = couleur;
	}

	@Override
	public boolean validerDep(Position posDepart, Position posFinal) {
		int diffColonne= posFinal.Colonne-posDepart.Colonne;
		int diffLigne= posFinal.ligne-posDepart.ligne;
		if (this.validerEchec(posFinal)){
		if (((diffLigne==1)||(diffLigne==0)||(diffLigne== -1))&&
			((diffColonne==1)||(diffColonne==0)||(diffColonne== -1)))
			return true;
		return false;
	}return false;
        }

	@Override
	public boolean manger(Position posDepart, Position posFinal) {
		// TODO Auto-generated method stub
		return false;
	}


}
