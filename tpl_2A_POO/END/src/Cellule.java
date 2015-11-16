import java.awt.Point;

public class Cellule {
    private Point[][] cellules;
    private int[][] etatav; //grille à l'état k
    private int[][] etatap; //grille à l'état k+1

    // création d'un tableau où chaque case est une cellule
    public Cellule (int lignes, int colonnes) {
		this.cellules = new Point[colonnes][lignes];
		this.etatav = new int[colonnes][lignes];
		this.etatap = new int[colonnes][lignes];

		for (int i = 0; i < lignes; i++) {
	    	for (int j = 0; j < colonnes; j++) {
				this.etatav[i][j] = 0;
				this.etatap[i][j] = 0;
	    	}
		}
    }
	
	//Obtenir le nombre de lignes
    public int getLignes() {
		return this.cellules.length;
    }
    // Obtenir le nombre de colonnes
    public int getColonnes() {
		return this.cellules[0].length;
    }
    //Obtenir la case (i,j) de la grille
    public Point getCellule(int i,int j) {
		return this.cellules[i][j];
    }
    //Obtenir l'état de la case (i,j) de la grille avant
    public int getEtatav(int i,int j) {
		return this.etatav[i][j];
    }
    //Obtenir l'état de la case (i,j) de la grille après
    public int getEtatap(int i,int j) {
		return this.etatap[i][j];
    }
    //Modifier l'état de la case (i,j) dans la grille avant
    public void setEtatap(int i,int j, int etat) {
		this.etatap[i][j] = etat;
    }
    //Modifier l'état de la case (i,j) dans la grille après
    public void setEtatav(int i,int j, int etat) {
	 	this.etatav[i][j] = etat;
    }

    //Obtenir le nombre de voisins de la case (i,j) à l'état k+1
    public int nb_voisins_vivants(int i, int j, int taillex, int tailley, int n) {
		int nb_voisins = 0;
		int etat = n==2 ? 1 : (this.etatav[i][j] % n)+1;

		//i varie entre 0 et taillex-1 
		//on s'assure que i+1 vaut 0 lorsque i vaut taillex-1, pour les bords
		//de même pour j
		int Top_line_i = (i+1) % taillex;
		int Bot_line_i = (i==0) ? taillex-1 : ((i-1) % taillex);
		int Left_raw_j = (j==0) ? tailley-1 : ((j-1) % tailley);
		int Right_raw_j = (j+1) % tailley;

		if (this.etatav[Top_line_i][j] == etat)
		    nb_voisins++;
		if (this.etatav[Top_line_i][Right_raw_j] == etat) 
		    nb_voisins++;
		if (this.etatav[Top_line_i][Left_raw_j] == etat)
		    nb_voisins++;
		if (this.etatav[i][Right_raw_j] == etat)
			    nb_voisins++;
		if (this.etatav[i][Left_raw_j] == etat)
			    nb_voisins++;
		if (this.etatav[Bot_line_i][j] == etat)
			    nb_voisins++;
		if (this.etatav[Bot_line_i][Right_raw_j] == etat) 
			    nb_voisins++;
		if (this.etatav[Bot_line_i][Left_raw_j] == etat)
			    nb_voisins++;
		return nb_voisins;
	}
    
    //Algorithme principal
    public void evolution(int taillex, int tailley) {
	
		for (int i = 0; i < taillex; i++) {
	    	for (int j = 0; j < tailley; j++) {

				if (this.etatav[i][j] == 0 &
				    this.nb_voisins_vivants(i,j,taillex,tailley, 2) == 3) {
				    this.etatap[i][j] = 1;
				}
				if (this.etatav[i][j] == 1 &
				    (this.nb_voisins_vivants(i,j,taillex,tailley, 2) != 3 &
				     this.nb_voisins_vivants(i,j,taillex,tailley, 2) != 2)){
				    this.etatap[i][j] = 0;
				}
			}
		}
		//On itère, en actualisant nos deux grilles avant et après
		for (int i = 0; i < taillex; i++) {
		    for (int j = 0; j < tailley; j++) {
				this.etatav[i][j] = this.etatap[i][j];
	    	}
		}
    }
    
    //Initialisation de la grille
    public void reInit() {
		for (int i = 0; i < this.cellules.length; i++) {
		    for (int j = 0; j < this.cellules[0].length; j++) {
				int etat = 0;
				if ( Math.random() < 0.2 )
			    	etat = 1;
					this.etatav[i][j] = etat;
		    }
		}
    }
}