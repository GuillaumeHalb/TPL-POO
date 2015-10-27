import java.awt.Point;

public class Cellule_Immi extends Cellule {
    private int nb_etats;
    private int[][] etatav;
    private int[][] etatap; //etat entre 1 et n
    
    // création d'un tableau où chaque case est une cellule
    public Cellule_Immi (int lignes, int colonnes, int n) {
	super(lignes,colonnes,n);
	this.etatav = new int[colonnes][lignes];
	this.etatap = new int[colonnes][lignes];
	this.nb_etats = n;
	for (int i = 0; i < lignes; i++) {
	    for (int j = 0; j < colonnes; j++) {
		this.etatav[i][j] = (int) Math.random()*(n-1)+1;
		this.etatap[i][j] = (int) Math.random()*(n-1)+1;

	    }
	}
    }



    public int getNb_etats() {
	return this.nb_etats;
    }

    public int getEtatav_immi(int i,int j) {
	return this.etatav[i][j];
    }

    public int getEtatap_immi(int i,int j) {
	return this.etatap[i][j];
    }

    public void setEtatap_immi(int i,int j, int etat) {
	 this.etatap[i][j] = etat;
    }
    public void setEtatav_immi(int i,int j, int etat) {
	 this.etatav[i][j] = etat;
    }
    
     public int nb_voisins_vivants(int i,int j) {
	int nb_voisins = 0;
	int etatk = this.etatav[i][j];
	if (this.etatav[i+1][j]==etatk+1)// % this.nb_etats )
		    nb_voisins++;
	if (this.etatav[i+1][j+1]==etatk+1)//% this.nb_etats ) 
		    nb_voisins++;
	if (this.etatav[i+1][j-1]==etatk+1)//% this.nb_etats)
		    nb_voisins++;
	if (this.etatav[i][j+1]==etatk+1)//% this.nb_etats )
		    nb_voisins++;
	if (this.etatav[i][j-1]==etatk+1)//% this.nb_etats )
		    nb_voisins++;
	if (this.etatav[i-1][j]==etatk+1)//% this.nb_etats)
		    nb_voisins++;
	if (this.etatav[i-1][j+1]==etatk+1)//% this.nb_etats) 
		    nb_voisins++;
	if (this.etatav[i-1][j-1]==etatk+1)//% this.nb_etats)
		    nb_voisins++;
	return nb_voisins;
    }
    public void evolution(){
	 for (int i = 1; i < this.etatav.length-1; i++) {
	    for (int j = 1; j < this.etatav[0].length-1; j++) {
		if (this.nb_voisins_vivants(i,j) >= 3) {
		    int etatk = this.etatav[i][j];
		    this.etatap[i][j] = ((etatk+1) % this.nb_etats);
		}
	    }
	}
        for (int i = 1; i < this.etatav.length-1; i++) {
	    for (int j = 1; j < this.etatav[0].length-1; j++) {
		this.etatav[i][j] = this.etatap[i][j];
	    }
	}
    }
    
    @Override
    void reInit() {
	for (int i = 0; i < this.etatav.length; i++) {
	    for (int j = 0; j < this.etatav[0].length; j++) {
		this.etatav[i][j] =((int) (Math.random() * 9 + 1)) % this.nb_etats ;
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
