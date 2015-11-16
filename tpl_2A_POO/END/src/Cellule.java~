import java.awt.Point;

public class Cellule {
    private Point[][] cellules; //création de la grille
    private int[][] etatav; //grille au temps t
    private int[][] etatap; //grille au temps t+1

    /* Constructeur : création d'un tableau où chaque case est une cellule */
    public Cellule (int lignes, int colonnes) {
		this.cellules = new Point[colonnes][lignes];
		this.etatav = new int[colonnes][lignes];
		this.etatap = new int[colonnes][lignes];

		//on initialise toutes les grilles utilisées
		for (int i = 0; i < lignes; i++) {
	    	for (int j = 0; j < colonnes; j++) {
				this.etatav[i][j] = 0;
				this.etatap[i][j] = 0;
	    	}
		}
    }
	
	/* Obtenir le nombre de lignes */
    public int getLignes() {
		return this.cellules.length;
    }
    /* Obtenir le nombre de colonnes */
    public int getColonnes() {
		return this.cellules[0].length;
    }
    /* Obtenir la case (i,j) de la grille */
    public Point getCellule(int i,int j) {
		return this.cellules[i][j];
    }
    /* Obtenir l'état de la case (i,j) de la grille au temps t */
    public int getEtatav(int i,int j) {
		return this.etatav[i][j];
    }
    /* Obtenir l'état de la case (i,j) de la grille au temps t+1 */
    public int getEtatap(int i,int j) {
		return this.etatap[i][j];
    }
    /* Modifier l'état de la case (i,j) dans la grille au temps t */
    public void setEtatap(int i,int j, int etat) {
		this.etatap[i][j] = etat;
    }
    /* Modifier l'état de la case (i,j) dans la grille au temps t+1 */
    public void setEtatav(int i,int j, int etat) {
	 	this.etatav[i][j] = etat;
    }

    /* Obtenir le nombre de voisins vivants de la case (i,j) au temps t
    // Le principe est de regarder les 8 voisins les plus proches
    // et de savoir s'ils sont ou non à un état différent (ou supérieur) */
    public int nb_voisins_vivants(int i, int j, int taillex, int tailley, int n) {
		int nb_voisins = 0;
		//on anticipe deux cas: si jeu de la vie ou jeu de l'immigration
		int etat = n==2 ? 1 : (this.etatav[i][j] % n)+1;

		//On gère la circularité des grilles via 4 variables
		//Lorsque i=taillex-1 alors i+1=0, et de même pour j 
		//Par symétrie on a aussi les cas inverses
		int top_line_i = (i+1) % taillex;
		int bot_line_i = (i==0) ? taillex-1 : ((i-1) % taillex);
		int left_raw_j = (j==0) ? tailley-1 : ((j-1) % tailley);
		int right_raw_j = (j+1) % tailley;

		if (this.etatav[top_line_i][j] == etat)
		    nb_voisins++;
		if (this.etatav[top_line_i][right_raw_j] == etat) 
		    nb_voisins++;
		if (this.etatav[top_line_i][left_raw_j] == etat)
		    nb_voisins++;
		if (this.etatav[i][right_raw_j] == etat)
			    nb_voisins++;
		if (this.etatav[i][left_raw_j] == etat)
			    nb_voisins++;
		if (this.etatav[bot_line_i][j] == etat)
			    nb_voisins++;
		if (this.etatav[bot_line_i][right_raw_j] == etat) 
			    nb_voisins++;
		if (this.etatav[bot_line_i][left_raw_j] == etat)
			    nb_voisins++;
		return nb_voisins;
	}
    
    /* Algorithme du jeu de la vie */
    public void evolution(int taillex, int tailley) {
	
		for (int i = 0; i < taillex; i++) {
	    	for (int j = 0; j < tailley; j++) {
	    		//condition pour qu'une case vienne à la vie
				if (this.etatav[i][j] == 0 &
				    this.nb_voisins_vivants(i,j,taillex,tailley, 2) == 3) {
				    this.etatap[i][j] = 1;
				}
				//condition pour qu'une case meure
				if (this.etatav[i][j] == 1 &
				    (this.nb_voisins_vivants(i,j,taillex,tailley, 2) != 3 &
				     this.nb_voisins_vivants(i,j,taillex,tailley, 2) != 2)){
				    this.etatap[i][j] = 0;
				}
			}
		}
		//On itère, en actualisant la grille avant 
		for (int i = 0; i < taillex; i++) {
		    for (int j = 0; j < tailley; j++) {
				this.etatav[i][j] = this.etatap[i][j];
	    	}
		}
    }
    
    /* Initialisation de la grille t=0 */
    public void reInit() {
		for (int i = 0; i < this.cellules.length; i++) {
		    for (int j = 0; j < this.cellules[0].length; j++) {
				//0 équivaut à une case morte
				int etat = 0;

				//On choisit arbitrairement le nombre de cases vivantes
				//En moyenne 1/5 de la grille est vivante
				if ( Math.random() < 0.2 ) {
					//1 équivaut à une case vivante
			    	etat = 1;
					this.etatav[i][j] = etat;
				}
		    }
		}
    }
}