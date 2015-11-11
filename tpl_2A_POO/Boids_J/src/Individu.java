public class Individu {
    private Integer essaim; // A quel essaim appartient l'individu
    private Pt position;
    private Pt direction;

    public Individu(Integer e, Pt p, Pt d) {
	this.essaim = e;
	this.position = p;
	this.direction = d;
    }

    public Boolean estEgal(Individu a, Individu b) { /* Verifie si deux 
						      * individus sont les memes 
						      */
	return a.essaim == b.essaim 
	    && a.position == b.position 
	    && a.direction == b.direction;
    }

    public Boolean estVu(Individu i1, double d) { /* Renvoit si i2 voit i1*/
	Pt p = new Pt(0.0,0.0);
	if (p.distance(i1.getPosition(), this.getPosition()) <= 10.0*d) { // On vérifie la distance
	    Pt u = new Pt(0.0,0.0);
	    u = this.getDirection();
	    Pt v = new Pt(0.0,0.0);
	    v.sous(this.getPosition(), i1.getPosition());
	    double angle = Math.acos(u.getX()*v.getX() + u.getY()*v.getY()) 
		/ u.norme()*v.norme();
	    if (angle <= Math.PI/2.0 && angle >= 0.0 
		|| angle <= 2.0*Math.PI && angle >= 3.0*Math.PI/2.0) {// On vérifie si l'individu n'est pas derrière
		return true;
	    }
	}
	return false;
    }

    public Integer getEssaim() {
	return this.essaim;
    }

    public Pt getPosition() {
	return this.position;
    }

    public Pt getDirection() {
	return this.direction;
    }

    // public Double getVitesse() {
    // 	return this.vitesse;
    // }

    public Pt Cohesion(Essaim e) {
	Pt p = new Pt(0.0,0.0);
	Integer compteur = 0;
	for (Individu i : e.getAgents()) {
	    if (this.estVu(i, e.getDistance())) {
		p = p.add(p, i.getPosition());
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

    public Pt Alignement(Essaim e) {
	Pt p = new Pt(0.0,0.0);
	Integer compteur = 0;
	for (Individu i : e.getAgents()) {
	    if (this.estVu(i, e.getDistance())) {
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

    public Pt Separation(Essaim e) { // ajouter champ de vision
	Pt p = new Pt(0.0, 0.0);
	Integer nb_trop_proches = 0;
	for (Individu i : e.getAgents()) {
	    if (p.distance(i.position, this.position) < e.getDistance() 
		&& !estEgal(i, this)) {
		nb_trop_proches++;
		p = p.add(p,p.sous(this.position, i.position));
	    }
	}
	if (nb_trop_proches != 0) {
	    return p.div(p,nb_trop_proches);
	}
	else {
	    return p;
	}
    }
    
    public void Evolution(Essaim e) {
	Pt p= new Pt(0.0,0.0);
	Pt cohesion = Cohesion(e);
	Pt alignement = Alignement(e);
	Pt separation = Separation(e);
	Pt direction =  p.add(p.add(cohesion, separation), alignement);
	this.direction = direction;
	System.out.println("Direction: "+ direction.getX() +  ";" 
			   + direction.getY());
	if (direction.norme() > e.getV_max()) {
	    this.direction =  p.mult(direction,e.getV_max()/direction.norme());
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
