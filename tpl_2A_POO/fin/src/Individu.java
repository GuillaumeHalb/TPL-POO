import java.awt.Color;

public class Individu extends Balle {
    private Integer essaim; // A quel essaim appartient l'individu
 

    public Individu(Integer e, Pt p, Pt d) {
	super(p,d,Color.BLUE);
	this.essaim = e;
    }

    public Boolean estEgal(Individu a, Individu b) { /* Verifie si deux 
						      * individus sont les memes 
						      */
	return a.essaim == b.essaim 
	    && a.position == b.position 
	    && a.direction == b.direction;
    }

    public Boolean estVu(Individu i1, double d) { /* Renvoit true si this voit i1*/
	Pt p = new Pt(0.0,0.0);
	if (!estEgal(this,i1) ) {
	    if (p.distance(i1.getPosition(), this.getPosition()) <= 1.0*d) { // On vérifie la distance
		Pt u = this.getDirection();
		Pt v = u.sous(i1.getPosition(), this.getPosition());
		double angle = Math.acos(u.getX()*v.getX() + u.getY()*v.getY()) / (u.norme()*v.norme());
		return (!((angle <= Math.PI/2.0 && angle >= 0.0 ) || (angle <= 2.0*Math.PI && angle >= 3.0*Math.PI/2.0))); // On vérifie si l'individu n'est pas derrière
		}
	    }
	    return false;
    }
    
    public Integer getEssaim() {
	return this.essaim;
    }


    public Pt Cohesion(Essaim e) {
	Pt p = new Pt(0.0,0.0);
	Integer compteur = 0;
	for (Individu i : e.getAgents()) {
	    if (this.estVu(i, 5.0*e.getDistance())) {
		
		p = p.add(p, i.getPosition());
		compteur++;
	    }
	}
	if (compteur != 0) {
	    return p.sous(p.div(p,compteur),this.position);
	}
	else {
	    return p;
	}
    }

    public Pt Alignement(Essaim e) {
	Pt p = new Pt(0.0,0.0);
	Integer compteur = 0;
	for (Individu i : e.getAgents()) {
	    if (this.estVu(i, 5.0*e.getDistance())) {
		p = p.add(p, i.direction);
		compteur++;
	    }
	}
	if (compteur != 0) {
	    return p.div(p,compteur);
	}
	else {
	    return p;
	}
    }

    public Pt Separation(Essaim e) { 
	Pt p = new Pt(0.0, 0.0);
	for (Individu i : e.getAgents()) {
	    if (p.distance(i.position, this.position) < e.getDistance() && !estEgal(i, this) && this.estVu(i, 5.0*e.getDistance())){ 
		p = p.sous(p,p.sous(i.position, this.position));
	    }
	}
	return p;
    }
    
    public void Evolution(Essaim e, Integer taillex,Integer tailley) {
	Pt p= new Pt(0.0,0.0);
	Pt cohesion = Cohesion(e);
	Pt alignement = Alignement(e);
	Pt separation = p.mult(Separation(e),1.0);
	Pt direction = p.add(this.direction, p.add(p.add(cohesion, separation), alignement));
	this.direction = direction;
	
	//Limitation de la vitesse
	if (direction.norme() > e.getV_max()) {
	    this.direction =  p.mult(direction,e.getV_max()/direction.norme());
	}

	//Gestion des bords
	if (this.position.getX() >taillex) {
	    this.position.setLocation(0.0,this.position.getY());
	}
	if (this.position.getX() < 0) {
	    this.position.setLocation(taillex,this.position.getY());
	}
	if (this.position.getY() >tailley) {
	    this.position.setLocation(this.position.getX(),0.0);
	}
	if (this.position.getY() <0) {
	    this.position.setLocation(this.position.getX(),tailley);
	}		
	this.position =  p.add(this.position, this.direction);
    }

    @Override
    public String toString() {
	return "L'individu appartient à l'essaim " + this.essaim 
	    + " et a pour position " + this.position.toString() 
	    + " et pour direction " + this.direction.toString();
    }
}
