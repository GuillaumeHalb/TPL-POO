import java.util.LinkedList;

public class Essaim {
    private double distance; // distance minimal entre deux individus
    private Point centre; // Centre de gravité de l'essaim
    private Vue vision; /* Angle et Distance déterminent le champ de vision
			 * On peut créer une nouvelle classe
			 */
    private LinkedList<Individu> agents; 

    public Essaim(double d, Point c, Truc v, Integer n) {
	this.distance = d;
	this.centre = c;
	this.vision = v;
	this.nombre = n;
	agents = new LinkedList<Individu>();
    }
    
    public Integer getNbAgents() {
	return agents.size();
    }

    public void ajouteIndividu(Individu i) {
	agents.add(i);
    }

    public LinkedList<Individu> getAgents() {
	return this.agents;
    }

    public Vue getVision() {
	return this.vision;
    }

    public Point getCentre() {
	return this.centre;
    }

    public double getDistance() {
	return this.distance;
    }
}
