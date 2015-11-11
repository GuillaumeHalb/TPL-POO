    
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
	Pt Centre = new Pt(20.0,20.0); // Centre dans le champ de vision
	p = p.sous(Centre, this.position);	
	return p;
    }

    public Pt Alignement(Essaim e) {
	Pt p= new Pt(0.0,0.0);
	for (Individu i : e.getAgents()) {
	    p = p.add(p, i.direction);
	}
	p =  p.div(p, e.getNbAgents()); 
       	return p;
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
	return p.div(p,nb_trop_proches);
    }
    
    public void Evolution(Essaim e) {
	Pt p= new Pt(0.0,0.0);
	Pt cohesion = Cohesion(e);
	Pt separation = Separation(e);
	Pt alignement = Alignement(e);
	Pt direction =  p.add( p.add(cohesion, separation), alignement);
	this.direction = direction;
	System.out.println("Direction: "+ direction.getX() +  ";" + direction.getY());
	if (direction.norme() > e.getV_max()) {
	    this.direction =  p.mult(direction,e.getV_max()/direction.norme());
	}
	this.position =  p.add(this.position, this.direction);
    }
}
