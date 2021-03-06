import java.util.LinkedList;
import java.awt.Point;

public class Essaim {
    private double distance; // distance minimal entre deux individus
    private Point centre; // Centre de gravité de l'essaim
    private Vue vision; /* Angle et Distance déterminent le champ de vision
			 * On peut créer une nouvelle classe
			 */
    private LinkedList<Individu> agents; /* Liste des agents de l'essaim */
    private Integer v_max; // pour éviter la téléportation
 
    public Essaim(double d, Point c, Truc v, Integer n,Integer v_max) {
	this.distance = d;
	this.centre = c;
	this.vision = v;
	this.nombre = n;
	this.v_max = v_max;
	this.agents = new LinkedList<Individu>();
    }

    public Point CalculCentre() {
	Point p = 0;
	for (Individu i : agents) {
	    add(p, i.getPosition());
	}
	return div(p, this.agents.size());
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

    /* On peut faire une fonction changement de direction 
     * si l'essaim a dans son champs de vision un autre essaim
     */


    /* On peut faire une fonction avancer 
     * Pour que l'essaim avance 
     * (On fait avancer son centre de masse)
     */
}
