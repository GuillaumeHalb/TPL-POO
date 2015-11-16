import gui.GUISimulator;
import java.util.LinkedList;


public class EssaimEvent extends Event {
    private Essaim essaim;
    private LinkedList<Individu> allAgents;
    private int taillex;
    private int tailley;
    private GUISimulator gui;
    
    public EssaimEvent (long date, Essaim essaim,int taillex, int tailley,GUISimulator gui,LinkedList<Individu> allAgents){
	super(date);
	this.essaim = essaim;
	this.taillex = taillex;
	this.tailley = tailley;
	this.gui = gui;
	this.allAgents = allAgents;
    }

    public Essaim getEssaim(){
	return this.essaim;
    }

    @Override
    public void execute() {
        this.essaim.next(taillex, tailley, gui,allAgents);
	this.essaim.Affiche(taillex,tailley,gui);
    }
}
