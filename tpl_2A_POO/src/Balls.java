import java.awt.Point;

public class Balls {
    private Point[] balles;
    private int[] dirh; // 0 si vers la droite, 1 sinon
    private int[] dirv; // 0 si vers le bas, 1 sinon

    // création d'un tableau où chaque case est une balle
    public Balls (int nb_balles) {
	this.balles = new Point[nb_balles];
	this.dirh = new int[nb_balles];
	this.dirv = new int[nb_balles];
	for (int i = 0; i < this.balles.length; i++) {
	    this.balles[i] = new Point(20*(i+1), 20*(i+1));
	    this.dirh[i] = 0;
	    this.dirv[i] = 0;
	} 
    }

    // Pour obtenir le nombre de balles
    public int getDim() {
	return this.balles.length;
    }

    public Point getBalle(int i) {
	return this.balles[i];
    }

    void translate(int dx, int dy) {
	for (int i = 0; i < this.balles.length; i++) {
	    if (this.balles[i].getX() <= 0) {
		//this.balles[i].translate(dx,dy);
		this.dirh[i] = 0;
	    }
	    else if (this.balles[i].getX() >= 500) {
		//this.balles[i].translate(-dx,dy);
		this.dirh[i] = 1;
	    }
	    else if (this.balles[i].getY() >= 500) {
		//this.balles[i].translate(dx,-dy);
		this.dirv[i] = 1;
	    }
	    else if (this.balles[i].getY() <= 0) {
		//this.balles[i].translate(dx,dy);
		this.dirv[i] = 0;
	    }
	    if ((this.dirv[i] == 0) & (this.dirh[i] == 0))  
		this.balles[i].translate(dx,dy);
	    else if (this.dirv[i] == 0 & this.dirh[i] == 1)  
		this.balles[i].translate(-dx,dy);
	    else if (this.dirv[i] == 1 & this.dirh[i] == 1)  
		this.balles[i].translate(-dx,-dy);
	    else if (this.dirv[i] == 1 & this.dirh[i] == 0)  
		this.balles[i].translate(dx,-dy);
	} 
    }

    void reInit() {
	for (int i = 0; i < this.balles.length; i++) {
	    this.balles[i] = new Point(20*(i+1), 20*(i+1));
	}
    }

    @Override
    public String toString() {
	String S = new String("Les balles ont pour coordonnées : \n");
	for (int i = 0; i < this.balles.length; i++) {
	    S += "balle " + i + " : (" + this.balles[i].getX() + ", " 
		+ this.balles[i].getY() +") \n";
	}
	return S;
    }
}
