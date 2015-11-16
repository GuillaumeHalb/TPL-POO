import gui.Simulable;
import gui.GUISimulator;
import gui.Rectangle;
import java.awt.Color;
import java.util.LinkedList;


public class EssaimSimulator extends Simulator {

    private int nb_essaims;
    private Essaim[] essaim;
    private int nb_agents;
    private LinkedList<Individu> allAgents;

    public EssaimSimulator(int taillex, int tailley,double d, Integer v_max,int[] nb_agents, int nb_essaims) {
	super(taillex,tailley);
	this.nb_essaims = nb_essaims;
	this.essaim = new Essaim[nb_essaims];
	for (int i=0;i<nb_essaims;i++){
	    this.essaim[i] = new Essaim(d,v_max,new Color(70*(i+1)%255,255-(70*(i+1))%255,200%255),nb_agents[i]);
	}
	this.nb_agents = nb_agents[0];
	this.allAgents = new LinkedList<Individu>();

    }

    public Essaim getEssaim(int i) {
	return this.essaim[i];
    }

  
    @Override
    public void next() {
	gui.reset();
	gui.addGraphicalElement(new Rectangle(0,0,Color.RED,Color.WHITE,2*taillex+10,2*tailley+10));
	this.eventMan.next();
	for (int i=0;i<nb_essaims;i++){
	    this.eventMan.addEvent(new EssaimEvent(this.eventMan.getcurrentDate()+(i+1),this.essaim[i],taillex,tailley,this.gui,this.allAgents));
	}
    }
    
     @Override
     public void restart() {
	 gui.addGraphicalElement(new Rectangle(0,0,Color.RED,Color.WHITE,2*taillex+10,2*tailley+10));
	 for (int i=0;i<this.nb_essaims;i++){
	     this.essaim[i].reInit(taillex,tailley);
	     this.allAgents.addAll(this.essaim[i].getAgents());
	     this.essaim[i].Affiche(taillex,tailley,gui);
	 }

    }
}
