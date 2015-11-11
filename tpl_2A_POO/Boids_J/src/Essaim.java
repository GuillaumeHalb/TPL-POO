import java.util.LinkedList;
import java.awt.Point;

public class Essaim {
    private double distance; // distance minimal entre deux individus
    //private Point centre; // Centre de gravité de l'essaim
    //private Vue vision;
    /* Angle et Distance déterminent le champ de vision
			 * On peut créer une nouvelle classe
			 */
    private LinkedList<Individu> agents; /* Liste des agents de l'essaim */
    private Integer v_max; // pour éviter la téléportation
 
    public Essaim(double d,Integer v_max) {
	this.distance = d;
	//this.centre = new Pt(0.0,0.0);
	//this.vision = v;
	this.v_max = v_max;
	this.agents = new LinkedList<Individu>();
        
    }

    public Pt CalculCentre() {
	Pt p = new Pt(0.0,0.0);
	for (Individu i : agents) {
	    p= p.add(p, i.getPosition());
	}
	return p.div(p, this.agents.size());
    }
    
    public Integer getNbAgents() {
	return agents.size();
    }

    public Integer getV_max() {
	return this.v_max;
    }

    public void ajouteIndividu(Individu i) {
	agents.add(i);
    }

    public LinkedList<Individu> getAgents() {
	return this.agents;
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
