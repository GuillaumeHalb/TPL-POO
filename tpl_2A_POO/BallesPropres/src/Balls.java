import java.awt.Point;
import java.awt.Color;


public class Balls {
    private Point[] balles;
    private int[] dirh; 
    private int[] dirv; // dv/dh donne le coeff directeur
    private Color[] coul;

    // création d'un tableau où chaque case est une balle
    public Balls (int nb_balles) {
	this.balles = new Point[nb_balles];
	this.dirh = new int[nb_balles];
	this.dirv = new int[nb_balles];
	this.coul = new Color[nb_balles];
	for (int i = 0; i < this.balles.length; i++) {
	    this.balles[i] = new Point(0, 0);
	    int h = (int) (Math.random() * 9 + 1); //nb_aléatoire entre 1 et 10
	    int v = (int) (Math.random() * 9 + 1); //nb_aléatoire entre 1 et 10
	    this.dirh[i] = h;
	    this.dirv[i] = v;
	    this.coul[i] = new Color((int) (Math.random() * 250 + 1),
				      (int) (Math.random() * 250 + 1),
				      (int) (Math.random() * 250 + 1));
	} 
    }
    
    // Pour obtenir le nombre de balles
    public int getDim() {
	return this.balles.length;
    }

    public Point getBalle(int i) {
	return this.balles[i];
    }
    public Color getColor(int i) {
	return this.coul[i];
    }

    void translate(int taillex, int tailley) {
	for (int i = 0; i < this.balles.length; i++) {
	    if (this.balles[i].getX() < 0) {
		this.dirh[i] = 	-this.dirh[i];
	    }
	    if (this.balles[i].getX() > taillex) {
		this.dirh[i] = 	-this.dirh[i];
	    }
	    if (this.balles[i].getY() > tailley) {
		this.dirv[i] = 	-this.dirv[i];
	    }
	    if (this.balles[i].getY() < 0) {
		this.dirv[i] = 	-this.dirv[i];
	    }
	    this.balles[i].translate(this.dirh[i],this.dirv[i]);
	    // if ((this.dirv[i] == 0) & (this.dirh[i] == 0))  
	    // 	this.balles[i].translate(dx,dy);
	    // else if (this.dirv[i] == 0 & this.dirh[i] == 1)  
	    // 	this.balles[i].translate(-dx,dy);
	    // else if (this.dirv[i] == 1 & this.dirh[i] == 1)  
	    // 	this.balles[i].translate(-dx,-dy);
	    // else if (this.dirv[i] == 1 & this.dirh[i] == 0)  
	    // 	this.balles[i].translate(dx,-dy);
	} 
    }

    void reInit(Integer l, Integer h) {
	for (int i = 0; i < this.balles.length; i++) {
	    this.balles[i] = new Point((int)(Math.random()*l), (int)(Math.random() * h));
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
