import java.awt.Point;

public class Cellule_Immig extends Cellule {
    private int nb_etats;
   
   	/** Constructeur : création de la grille */ 
    public Cellule_Immig (int lignes, int colonnes, int n) {
		super(lignes,colonnes); //on hérite du constructeur de cellule.java
		this.nb_etats = n;
    }
    /** On récupère le nombre d'états pour le jeu */
    public int getNb_etats() {
		return this.nb_etats;
    }

   /** Algorithme principal du jeu de l'immigration 
   // On implémente la règle du jeu avec les notations de cellule.java */
    public void evolution() {

		for (int i = 0; i < getLignes(); i++) {
	    	for (int j = 0; j < getColonnes(); j++) {
				if (super.nb_voisins_vivants(i,j,getLignes(), getColonnes(), this.nb_etats) >= 3) {
		    		setEtatap(i,j,((getEtatav(i,j)% this.nb_etats)+1));
				}
	    	}
		}
        for (int i = 0; i < getLignes(); i++) {
	    	for (int j = 0; j < getColonnes(); j++) {
				setEtatav(i,j,getEtatap(i,j));
	    	}
		}
    }
    
    /** Initialisation des deux grilles à t=0 */
    @Override
    public void reInit() {
		for (int i = 0; i < getLignes(); i++) {
	    	for (int j = 0; j < getColonnes(); j++) {
				setEtatav(i,j,((int) (Math.random() * 4 + 1) % this.nb_etats));
				setEtatap(i,j,getEtatav(i,j));
	    	}
		}
	}
}
