package com.STI.entite;

public class Pion extends Piece {
  
	
	public Pion(String couleur)
		{this.couleur = couleur;
		}

	@Override
	public boolean validerDep(Position posDepart, Position posFinal) {
		int diffColonne= posFinal.Colonne-posDepart.Colonne;
		int diffLigne= posFinal.ligne-posDepart.ligne;
		//verifier si cest son premier coups et donc accepter lavance de deux cases
		
		if (this.validerEchec(posFinal)){		// verifier si le deplacement est d'une case de colonne
				if ( (diffLigne==-1) && (diffColonne==0) )
				return true;
				
				
				return false;
	}return false;
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

	



	
	
	
}
