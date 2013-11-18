/*
 *	Fichier:	Cavalier.java
 *	Contenu:	Classe Cavalier
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
@Table(name = "cavalier")
@XmlRootElement

public class Cavalier extends Piece implements Serializable {
    @Id
    private String couleur;
    private String image;

    public Cavalier() {
    }

    public Cavalier(String couleur) {
        this.couleur = couleur;
        setImage();
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
    
    @Override
    protected void setImage() {
        
        if( "blanc".equals(this.couleur) )
            this.image = "./images/bCavalier.gif";
        
        else if( "noir".equals(this.couleur) )
            this.image = "./images/nCavalier.gif";
    }

        public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    
}
