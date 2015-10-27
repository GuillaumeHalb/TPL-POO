import java.awt.Point;

public class Cellule {
    private Point[][] cellules;
    private boolean[][] etatav;
    private boolean[][] etatap; //True si vivant, false sinon
    
    // création d'un tableau où chaque case est une cellule
    public Cellule (int lignes, int colonnes,int n) {
	this.cellules = new Point[colonnes][lignes];
	this.etatav = new boolean[colonnes][lignes];
	this.etatap = new boolean[colonnes][lignes];

	for (int i = 0; i < lignes; i++) {
	    for (int j = 0; j < colonnes; j++) {
		this.etatav[i][j] = false;
		this.etatap[i][j] = false;

	    }
	}
    }

    // Pour obtenir le nombre de lignes
    public int getLignes() {
	return this.cellules.length;
    }
    public int getColonnes() {
	return this.cellules[0].length;
    }

    public Point getCellule(int i,int j) {
	return this.cellules[i][j];
    }

    public Boolean getEtatav(int i,int j) {
	return this.etatav[i][j];
    }

    public Boolean getEtatap(int i,int j) {
	return this.etatap[i][j];
    }

    public void setEtatap(int i,int j, boolean b) {
	 this.etatap[i][j] = b;
    }
    public void setEtatav(int i,int j, boolean b) {
	 this.etatav[i][j] = b;
    }
    
    
    public int nb_voisins_vivants(int i,int j,int taillex,int tailley) {
	int nb_voisins = 0;
	if (this.etatav[i+1][j] )
		    nb_voisins++;
	if (this.etatav[i+1][j+1]) 
		    nb_voisins++;
	if (this.etatav[i+1][j-1])
		    nb_voisins++;
	if (this.etatav[i][j+1] )
		    nb_voisins++;
	if (this.etatav[i][j-1] )
		    nb_voisins++;
	if (this.etatav[i-1][j])
		    nb_voisins++;
	if (this.etatav[i-1][j+1]) 
		    nb_voisins++;
	if (this.etatav[i-1][j-1])
		    nb_voisins++;
	return nb_voisins;
    }
    
    public void evolution(int taillex, int tailley){
	
	for (int i = 1; i < taillex-1; i++) {
	    for (int j = 1; j < tailley-1; j++) {

		if (this.etatav[i][j] == false &
		    this.nb_voisins_vivants(i,j,taillex,tailley) == 3) {
		    this.etatap[i][j] = true;
		}
		if (this.etatav[i][j] == true &
		    (this.nb_voisins_vivants(i,j,taillex,tailley) != 3 &
		     this.nb_voisins_vivants(i,j,taillex,tailley) != 2)){
		    this.etatap[i][j] = false;
		}
	    }
	}
	for (int i = 1; i < taillex-1; i++) {
	    for (int j = 1; j < tailley-1; j++) {
		this.etatav[i][j] = this.etatap[i][j];
;

	    }
	}
    }
    
    void reInit() {
	for (int i = 0; i < this.cellules.length; i++) {
	    for (int j = 0; j < this.cellules[0].length; j++) {
		boolean b = false;
		if ( Math.random() < 0.2 )
		    b =true;
		this.etatav[i][j] = b ;
	    }
	}
        //this.setEtatav(20,20,true);
    }


    
    
    // @Override
    // public String toString() {
    // 	String S = new String("Les balles ont pour coordonnées : \n");
    // 	for (int i = 0; i < this.balles.length; i++) {
    // 	    S += "balle " + i + " : (" + this.balles[i].getX() + ", " 
    // 		+ this.balles[i].getY() +") \n";
    // 	}
    // 	return S;
    // }
}
