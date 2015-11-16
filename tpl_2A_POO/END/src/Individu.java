import java.awt.Color;
import java.util.LinkedList;

public class Individu extends Balle {
    private Color identifiant; // A quel essaim appartient l'individu
 

    public Individu(Color coul, Pt p, Pt d) {
	super(p,d,Color.BLUE);
	this.identifiant = coul;
    }
    
    /* Verifie si deux individus sont les memes  */
    public Boolean estEgal(Individu a, Individu b) { 
	return a.identifiant == b.identifiant 
	    && a.position == b.position 
	    && a.direction == b.direction;
    }

    /* Renvoit true si this voit i1*/
    public Boolean estVu(Individu i1, double d) { 
	Pt p = new Pt(0.0,0.0);
	if (!estEgal(this,i1) ) {
	    if (p.distance(i1.getPosition(), this.getPosition()) <= 1.0*d) { 
		Pt u = this.getDirection();
		Pt v = u.sous(i1.getPosition(), this.getPosition());
		double scalaire = u.getX()*v.getX() + u.getY()*v.getY();
		double angle = Math.acos(scalaire)/ (u.norme()*v.norme());
		return (!((angle <= Math.PI/2.0 && angle >= 0.0 ) ||
			  (angle <= 2.0*Math.PI && angle >= 3.0*Math.PI/2.0)));
		// On vérifie si l'individu n'est pas derrière
	    }
	}
	return false;
    }
    
    public Color getIdentifiant() {
	return this.identifiant;
    }


    public Pt Cohesion(Essaim e,LinkedList<Individu> allAgents) {
	Pt p = new Pt(0.0,0.0);
	Integer compteur = 0;
	for (Individu i : allAgents) {
	    if (this.estVu(i, 5.0*e.getDistance()) &&
		(this.identifiant == i.identifiant)) {
		
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

    public Pt Alignement(Essaim e,LinkedList<Individu> allAgents) {
	Pt p = new Pt(0.0,0.0);
	Integer compteur = 0;
	for (Individu i : allAgents) {
	    if (this.estVu(i, 5.0*e.getDistance()) &&
		(this.identifiant == i.identifiant)) {
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

    public Pt Separation(Essaim e,LinkedList<Individu> allAgents) { 
	Pt p = new Pt(0.0, 0.0);
	for (Individu i :allAgents) {
	    if (p.distance(i.position, this.position) < e.getDistance() &&
		!estEgal(i, this) && this.estVu(i, 5.0*e.getDistance())){ 
		p = p.sous(p,p.sous(i.position, this.position));
	    }
	}
	return p;
    }
    
    public void Evolution(Essaim e, Integer taillex,Integer tailley,
			  LinkedList<Individu> allAgents) {
	Pt p= new Pt(0.0,0.0);
	Pt cohesion = Cohesion(e,allAgents);
	Pt alignement = Alignement(e,allAgents);
	Pt separation = p.mult(Separation(e,allAgents),1.0);
	Pt direction = p.add(this.direction,
			     p.add(p.add(cohesion,
					 separation),
				   alignement));
	this.direction = direction;
	
	//Limitation de la vitesse
	if (direction.norme() > e.getV_max()) {
	    this.direction =  p.mult(direction,e.getV_max()/direction.norme());
	}

	//Gestion des bords
	this.position =  p.add(this.position, this.direction);
	this.position.setLocation((this.position.getX()+taillex)%taillex,
				  (this.position.getY()+tailley)%tailley);

    }

    @Override
    public String toString() {
	return "L'individu appartient à l'essaim de couleur" +
	    this.identifiant.toString() 
	    + " et a pour position " + this.position.toString() 
	    + " et pour direction " + this.direction.toString();
    }
}
