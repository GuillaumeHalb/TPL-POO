import java.awt.Color;

public class Balle {
    protected Pt position;
    protected Pt direction;
    private Color couleur;

    public Balle(Pt p, Pt d, Color c) {
	this.position = p;
	this.direction = d;
	this.couleur = c;
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

    public void Rebond(Balle b1) { // la balle rebondit contre b1
	double x = this.direction.getX();
	double y = this.direction.getY();
	this.direction = new Pt(b1.direction.getX(), b1.direction.getY());
	b1.direction = new Pt(x, y);
    }

    public Boolean enContact(Balle b1) { // Renvoit si les deux balles se touchent
	if (this.position.getX() <= (b1.position.getX() + 15) // Remplacer 15 par 2*rayon
	    && this.position.getX() >= (b1.position.getX() - 15)
	    && this.position.getY() <= (b1.position.getY() + 15)
	    && this.position.getY() >=  (b1.position.getY() - 15)
	    && !this.estEgal(b1)) { 
	    return true;
	}
	return false;
    }

    public void translate(int taillex, int tailley, Balls b) { // Remplacer 7 par le rayon
	if (this.position.getX() - 7 <= 0 || this.position.getX() + 7 >= taillex) { // rajouter la condition je ne suis pas du mauvais coté de la barrière
	    this.direction = new Pt(-this.direction.getX(), 
				    this.direction.getY());
	}
	if (this.position.getY() - 7 <= 0 || this.position.getY() + 7 >= tailley ) { // pareil
	    this.direction = new Pt(this.direction.getX(), 
				    -this.direction.getY());
	}

	for (Balle i : b.getBalles()) {
	    if (this.enContact(i)) {
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
