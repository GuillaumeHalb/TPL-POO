import java.awt.Point;
import java.util.*;

public class Cellule_Schelling extends Cellule {
    private int nb_couleurs;
    private int seuil;
    private LinkedList<Point> maisons_vacantes;
   
    /* Constructeur de la grille, particularité de l'heritage :
    // chaque maison a une couleur définie par un entier bien précis 
    // les maisons vacantes seront reperés par 0 */
    public Cellule_Schelling (int lignes, int colonnes, int n, int k) {
	super(lignes,colonnes);
	this.nb_couleurs = n;
	this.seuil = k;
	this.maisons_vacantes = new LinkedList<Point>();
    }

    /* On récupère le nombre de couleurs */
    public int getNb_couleurs() {
	return this.nb_couleurs;
    }

    /* On récupère le seuil */
    public int getSeuil() {
	return this.seuil;
    }

    /* On récupère la liste des maisons vacantes */
    public LinkedList<Point> getMaison_vacantes() {
    	return this.maisons_vacantes;
    }
    
    /* Fonction calculant le nombre de voisins différents 
       pour une maison situé en (i,j) */
    public int nb_voisins_differents(int i, int j, int taillex, int tailley) {
	int nb_voisins = 0;
	int etat = getEtatav(i,j);
	
	//Pour la circularité on réutilise la même astuce que dans cellule.java
	int top_line_i = (i+1) % taillex;
	int bot_line_i = (i==0) ? taillex-1 : ((i-1) % taillex);
	int left_raw_j = (j==0) ? tailley-1 : ((j-1) % tailley);
	int right_raw_j = (j+1) % tailley;
	
	//On s'assure qu'on ne compte pas les voisins d'une maison vacante
	if (etat != 0) {
	    //On s'assure aussi qu'une maison vacante ne soit pas compté
	    if ((getEtatav(top_line_i,j) != etat) &
		(getEtatav(top_line_i,j) != 0))
		nb_voisins++;
	    if ((getEtatav(top_line_i,right_raw_j) != etat) &
		(getEtatav(top_line_i,right_raw_j) != 0))
		nb_voisins++;
	    if ((getEtatav(top_line_i,left_raw_j) != etat) &
		(getEtatav(top_line_i,left_raw_j) != 0))
		nb_voisins++;
	    if ((getEtatav(i,right_raw_j) != etat) &
		(getEtatav(i,right_raw_j) != 0))
		nb_voisins++;
	    if ((getEtatav(i,left_raw_j) != etat) &
		(getEtatav(i,left_raw_j) != 0))
		nb_voisins++;
	    if ((getEtatav(bot_line_i,j) != etat) &
		(getEtatav(bot_line_i,j) != 0))
		nb_voisins++;
	    if ((getEtatav(bot_line_i,right_raw_j) != etat) &
		(getEtatav(bot_line_i,right_raw_j) != 0)) 
		nb_voisins++;
	    if ((getEtatav(bot_line_i,left_raw_j) != etat) &
		(getEtatav(bot_line_i,left_raw_j) != 0))
		nb_voisins++;
	}
	return nb_voisins;
    }
    
    /* Algorithme principal de schelling */
    public void evolution() {
	
	for (int i = 0; i < getLignes(); i++) {
	    for (int j = 0; j < getColonnes(); j++) {
		if (this.nb_voisins_differents(i,j,
					       getLignes(),
					       getColonnes()) >= this.seuil) {		    		
				    
		    //on récupère une maison vacante, au hasard,
		    //pour installer la maison (i,j)
		    int hasard = (int) ((Math.random() * (maisons_vacantes.size()-1)-1) +1);
		    int i_0 = (int) this.maisons_vacantes.get(hasard).getX();
		    int j_0 = (int) this.maisons_vacantes.get(hasard).getY();
		    setEtatap(i_0, j_0, getEtatav(i,j));
		    this.maisons_vacantes.remove(hasard);
				    
		    //la maison devient vacante au temps t+1
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
    
    /* Initialisation des grilles */
    @Override
    public void reInit() {
	this.maisons_vacantes = new LinkedList<Point>();
	for (int i = 0; i < getLignes(); i++) {
	    for (int j = 0; j < getColonnes(); j++) {
		//on distribue aléatoirement les couleurs dans la grille
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
    }
}
