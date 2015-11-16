import java.awt.Point;

public class Cellule_Immig extends Cellule {
    private int nb_etats;
   
    public Cellule_Immig (int lignes, int colonnes, int n) {
	super(lignes,colonnes);
	this.nb_etats = n;
    }

    public int getNb_etats() {
	return this.nb_etats;
    }

    //Algorithme principal
    public void evolution() {
	for (int i = 0; i < getLignes(); i++) {
	    for (int j = 0; j < getColonnes(); j++) {
		if (super.nb_voisins_vivants(i,j,
					     getLignes(), getColonnes(),
					     this.nb_etats) >= 3) {
		    
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
