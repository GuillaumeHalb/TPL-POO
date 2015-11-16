import gui.Simulable;
import gui.GUISimulator;
import gui.Oval;
import gui.Rectangle;
import java.awt.Color;

public class Simulator implements Simulable {

    protected int taillex;
    protected int tailley;
    protected GUISimulator gui;
    protected EventManager eventMan;

     public Simulator(int taillex, int tailley) {
	this.gui = new GUISimulator(taillex, tailley, Color.WHITE);
	this.gui.setSimulable(this);
	this.eventMan = new EventManager();
	this.taillex = taillex;
	this.tailley = tailley;
    }

    public int gettaillex() {
	return this.taillex;
    }
    public int gettailley() {
	return this.tailley;
    }

    public GUISimulator getGUI() {
	return this.gui;
    }

     public EventManager getEventMan() {
	return this.eventMan;
    }

     @Override
    public void next() {
	this.eventMan.next();
    }
    
    @Override
    public void restart() {
	gui.addGraphicalElement(new Rectangle(0,0,Color.RED,Color.WHITE,
					      2*taillex+10,2*tailley+10));
    }

}
