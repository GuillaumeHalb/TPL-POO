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

    public Integer getEssaim() {
	return this.essaim;
    }

    public Point getPosition() {
	return this.position;
    }

    public Point getDirection() {
	return this.direction;
    }

    public Double getVitesse() {
	return this.vitesse;
    }

    public Pt Cohesion(Essaim e) {
	Pt p;
	p = sous(e.getCentre(), this.position);	
	return p;
    }

    public Pt Alignement(Essaim e) {
	Pt p;
	for (Individu i : e.getAgents()) {
	    p = add(p, i.direction);
	}
	p = div(p, e.getNbAgents()); 
       	return p;
    }

    public Pt Separation(Essaim e) { // ajouter champ de vision
	Pt p = new Pt(0.0, 0.0);
	Integer nb_trop_proches = 0;
	for (Individu i : e.getAgents()) {
	    if (distance(i.position, this.position) < e.getDistance() 
		&& !estEgal(i, this)) {
		nb_trop_proches++;
		p = add(p,sous(this.position, i.position));
	    }
	}
	return div(p,nb_trop_proches);
    }
    
    public void Evolution(Essaim e) {
	Pt cohesion = Cohesion(e);
	Pt separation = Separation(e);
	Pt alignement = Alignement(e);
	Pt direction = add(add(cohesion, separation), alignement);
	this.direction = direction;
	if (direction > e.v_max) {
	    this.direction = mult(direction.Normalisation(),e.v_max);
	}
	this.position = add(this.position, this.direction);
    }
}
