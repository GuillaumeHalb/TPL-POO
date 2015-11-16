import java.util.LinkedList;
import java.awt.Point;
import gui.GUISimulator;
import gui.Rectangle;
import java.awt.Color;


/**
   La classe essaim (boid) qui caractérise un essaim à simuler
 */
public class Essaim {
    private double distance; // distance minimale entre deux individus
    private LinkedList<Individu> agents; /* Liste des agents de l'essaim */
    private Integer v_max; // pour éviter la téléportation
    private Color couleur;
    private Integer nb_agents;
 
    public Essaim(double d,Integer v_max, Color couleur, int nb_agents) {
	this.distance = d;
	this.v_max = v_max;
	this.agents = new LinkedList<Individu>();
	this.couleur = couleur;
	this.nb_agents = nb_agents;
        
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

 
    public void Affiche(int taillex, int tailley, GUISimulator gui,LinkedList<Individu> allAgents) {
     
	for (Individu i : allAgents) {
	    Pt pos = i.getPosition();
	    gui.addGraphicalElement(new Rectangle((int) pos.getX(),
						  (int) pos.getY(),
						  i.getIdentifiant(),
						  i.getIdentifiant(),
						  5,5));
	    int x = (int) (5.0*i.getDirection().getX()/i.getDirection().norme());
	    int y = (int) (5.0*i.getDirection().getY()/i.getDirection().norme());
	    gui.addGraphicalElement(new Rectangle((int) (pos.getX() + x),
						  (int) (pos.getY() + y),
						  Color.BLACK,Color.BLACK,2,2));
	}
    }
    

    public void reInit(int taillex,int tailley) {
	this.distance = 20;
	this.v_max = 15;
	this.agents = new LinkedList<Individu>();
	for(int i=0;i<this.nb_agents;i++){
	    double x =  (Math.random() * taillex + 1.0);
	    double y =  (Math.random() * tailley + 1.0);
	    double bx = 1.0;
	    double by = 1.0;
	    if (Math.random() < 0.5)
		bx = -1.0;
	    if (Math.random() < 0.5)
		by = -1.0;
	    double x1 =  (Math.random()*5.0 + 1.0);
	    double y1 =  (Math.random()*5.0 + 1.0); 
	    Pt Pos = new Pt(x,y);
	    Pt dir = new Pt(bx*x1,by*y1);
	    
	    Individu ind = new Individu (this.couleur,Pos,dir);
	    this.ajouteIndividu(ind);
	}
    }

    public void next(int taillex, int tailley, GUISimulator gui,
		     LinkedList<Individu> allAgents){
	for (Individu i : this.agents) {
	    i.Evolution(this,taillex,tailley,allAgents);
	}
    }

}
