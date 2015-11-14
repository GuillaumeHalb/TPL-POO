import java.awt.Point;
import java.util.*;

public class Cellule_Schelling extends Cellule {
    private int nb_couleurs;
    private int seuil;
    private LinkedList<Point> maisons_vacantes;
   
    //chaque maison a une couleur définie par un entier bien précis
    //On réutilise ainsi Cellule.java
    public Cellule_Schelling (int lignes, int colonnes, int n, int k) {
		super(lignes,colonnes);
		this.nb_couleurs = n;
		this.seuil = k;
		this.maisons_vacantes = new LinkedList<Point>();
    }

    public int getNb_couleurs() {
		return this.nb_couleurs;
    }

	public int getSeuil() {
		return this.seuil;
    }

    public LinkedList<Point> getMaison_vacantes() {
    	return this.maisons_vacantes;
    }
    
    public int nb_voisins_differents(int i, int j, int taillex, int tailley) {
	int nb_voisins = 0;
	int etat = getEtatav(i,j);
	
		//i varie entre 0 et taillex-1 
		//on s'assure que i+1 vaut 0 lorsque i vaut taillex-1 et inversement, pour les bords
		//de même pour j
	int top_line_i = (i+1) % taillex;
	int bot_line_i = (i==0) ? taillex-1 : ((i-1) % taillex);
	int left_raw_j = (j==0) ? tailley-1 : ((j-1) % tailley);
	int right_raw_j = (j+1) % tailley;
	
	if (etat != 0) {
	    if ((getEtatav(top_line_i,j) != etat) & (getEtatav(top_line_i,j) != 0))
		nb_voisins++;
	    if ((getEtatav(top_line_i,right_raw_j) != etat) & (getEtatav(top_line_i,right_raw_j) != 0))
		nb_voisins++;
	    if ((getEtatav(top_line_i,left_raw_j) != etat) & (getEtatav(top_line_i,left_raw_j) != 0))
		nb_voisins++;
	    if ((getEtatav(i,right_raw_j) != etat) & (getEtatav(i,right_raw_j) != 0))
		nb_voisins++;
	    if ((getEtatav(i,left_raw_j) != etat) & (getEtatav(i,left_raw_j) != 0))
		nb_voisins++;
	    if ((getEtatav(bot_line_i,j) != etat) & (getEtatav(bot_line_i,j) != 0))
		nb_voisins++;
	    if ((getEtatav(bot_line_i,right_raw_j) != etat) & (getEtatav(bot_line_i,right_raw_j) != 0)) 
		nb_voisins++;
	    if ((getEtatav(bot_line_i,left_raw_j) != etat) & (getEtatav(top_line_i,left_raw_j) != 0))
		nb_voisins++;
	}
	return nb_voisins;
    }
    
    //Algorithme principal
    public void evolution() {
	System.out.println(maisons_vacantes.size());
	for (int i = 0; i < getLignes(); i++) {
	    for (int j = 0; j < getColonnes(); j++) {
		if (this.nb_voisins_differents(i,j,getLignes(), getColonnes()) >= this.seuil) {		    		
		    
		    //on récupère une maison vacante, au hasard, pour installer la maison (i,j)
		    int hasard = (int) ((Math.random() * maisons_vacantes.size()) );
		    int i_0 = (int) this.maisons_vacantes.get(hasard).getX();
		    int j_0 = (int) this.maisons_vacantes.get(hasard).getY();
		    setEtatap(i_0, j_0, getEtatav(i,j));
		    this.maisons_vacantes.remove(hasard);
		    
		    //la maison devient vacante à l'état t+1
		    setEtatap(i,j,0);
		    this.maisons_vacantes.add(new Point(i,j));
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
	this.maisons_vacantes = new LinkedList<Point>();
	for (int i = 0; i < getLignes(); i++) {
	    for (int j = 0; j < getColonnes(); j++) {
		setEtatav(i,j,((int) (Math.random() * (this.nb_couleurs) + 1)));
		setEtatap(i,j,getEtatav(i,j));
	    	
				//initialisation des logements vacants, reperés par 0	
		if (Math.random() < 0.3) {
		    setEtatav(i,j,0);
		    setEtatap(i,j,0);
		    this.maisons_vacantes.add(new Point(i,j));
		}
	    }
	}
	System.out.println(maisons_vacantes.size());
	
    }
}
