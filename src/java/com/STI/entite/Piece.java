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
@Table(name = "piece")
@XmlRootElement

public  abstract class Piece implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "couleur")
    private String couleur;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @Column(name = "colonne")
    private int colonne;
    @Basic(optional = false)
    @Column(name = "ligne")
    private int ligne;


    
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

    public Piece() {
    }

    public Piece(String couleur) {
        this.couleur = couleur;
    }

    public Piece(String couleur, String image, int colonne, int ligne) {
        this.couleur = couleur;
        this.image = image;
        this.colonne = colonne;
        this.ligne = ligne;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    /**
     *
     * @return
     */
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (couleur != null ? couleur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Piece)) {
            return false;
        }
        Piece other = (Piece) object;
        if ((this.couleur == null && other.couleur != null) || (this.couleur != null && !this.couleur.equals(other.couleur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.STI.entite.Piece[ couleur=" + couleur + " ]";
    }
   
}
