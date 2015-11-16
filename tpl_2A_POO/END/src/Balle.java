import java.awt.Color;

public class Balle {
    protected Pt position;
    protected Pt direction;
    private Color couleur;
    private Boolean A;


    public Balle(Pt p, Pt d, Color c) {
	this.position = p;
	this.direction = d;
	this.couleur = c;
	A = false;
    }

    public Pt getPosition() {
	return this.position;
    }

    public Pt getDirection() {
	return this.direction;
    }

    public Color getCouleur() {
	return this.couleur;
    }
    
    public void setPosition(Pt p) {
	this.position = p;
    }
    
    public void setDirection(Pt d) {
	this.direction = d;
    }

    public void setCouleur(Color c) {
	this.couleur = c;
    }

    public Boolean estEgal(Balle b1) {
	return this.position == b1.position 
	    && this.direction == b1.direction
	    && this.couleur == b1.couleur;
    }

    /* La balle rebondit contre b1 */
    public void Rebond(Balle b1) {
	double x = this.direction.getX();
	double y = this.direction.getY();
	this.direction = new Pt(b1.direction.getX(), b1.direction.getY());
	b1.direction = new Pt(x, y);
    }

    /* Renvoit true si les deux balles sont en contact */
    public Boolean enContact(Balle b1, int rayon) {
	if  (this.position.distance(this.position, b1.position) <= 2*rayon) { 
	    return true;
	}
	return false;
    }

    /* Fait passer la position du temps t au temps t+1 */
    // public void translate(int taillex, int tailley, Balls b) { 
    // 	if (this.position.getX() - 7 <= 0 || this.position.getX() + 7 >= taillex) { 
    // 	    this.direction = new Pt(-this.direction.getX(), 
    // 				    this.direction.getY());
    // 	}
    // 	if (this.position.getY() - 7 <= 0 || this.position.getY() + 7 >= tailley ) { // pareil
    // 	    this.direction = new Pt(this.direction.getX(), 
    // 				    -this.direction.getY());
    // 	}

    // 	for (Balle i : b.getBalles()) {
    // 	    if (this.enContact(i)) {
    // 		this.Rebond(i);
    // 	    }
    // 	}
    // 	this.position.translate(this.direction.getX(), this.direction.getY());
    // }
     public void translate(int taillex, int tailley, Balls b, int rayon) {
	/* Fait rebondir les balles sur les bords */
	if (this.position.getX() - rayon <= 0 
	    || this.position.getX() + rayon >= taillex) {
	    this.direction = new Pt(-this.direction.getX(), 
				    this.direction.getY());
	}
	if (this.position.getY() - rayon <= 0 
	    || this.position.getY() + rayon >= tailley) {
	    this.direction = new Pt(this.direction.getX(), 
				    -this.direction.getY());
	}
	    
	/* Fais rebondir les balles les unes contre les autres */
	for (Balle i : b.getBalles()) {
	    if (this.enContact(i, rayon)) {
		this.Rebond(i);
	    }
	}
	this.position.translate(this.direction.getX(), this.direction.getY());
    }
    
    /*@Override
    public String toString() {
	return "La balle de couleur " + this.couleur 
	    + " a pour position : " + this.position.toString() 
	    + " et pour direction : " + this.direction.toString();
	    }*/
}
