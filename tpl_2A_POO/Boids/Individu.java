public class Individu {
    private Integer essaim; // A quel essaim appartient l'individu
    private Point position;
    private Point direction;

    public Individu(Integer e, Point p, Point d) {
	this.essaim = e;
	this.position = p;
	this.direction = d;
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

    // Faire les fonctions Cohésion, Alignement, Séparation
    public void Cohesion(Point p) { // Prends un argument le centre de masse
	this.direction = p - this.direction; // l'individu se dirige toujours vers 
    }

    public void Alignement(Integer nb, ) { // Nombre d'individu
	Integer direction_moyenne = 0;
	for (int i = 0; i < nb; i++) {
	    
	}
	
	this.direction = direction_moyenne;
    }

    
}
