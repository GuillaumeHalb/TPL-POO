import gui.Simulable;
import gui.GUISimulator;
import gui.Oval;
import gui.Rectangle;
import java.awt.Color;

public class BallsSimulator extends Simulator {

    private Balls b;
    private int rayon;
   
    public BallsSimulator(int taillex, int tailley, int nb_balles) {
	super(taillex,tailley);
	this.b = new Balls();
	b.reInit(this.taillex, this.tailley, nb_balles,15);
	this.rayon = 15;

    }

    public Balls getBalls() {
	return this.b;
    }
    
    
    @Override
    public String toString() {
	String S = new String("[");
	for (Balle i : b.getBalles()) {
	    S += i.getPosition().toString() + ", ";
	}
	S += "]";
	return S;
    } 

    @Override
    public void next() {
	super.next();
	this.eventMan.addEvent(new BallsEvent(this.eventMan.getcurrentDate()+1,
					      this.b,
					      taillex,tailley,
					      this.gui));
    }
    
    @Override
    public void restart() {
	this.b.reInit(this.taillex, this.tailley,
		      this.b.getNbBalles(),this.rayon);
	System.out.println(this.toString());
	this.b.Affiche(taillex,tailley,this.gui);
    }
}
