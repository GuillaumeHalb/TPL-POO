import gui.Simulable;
import gui.GUISimulator;
import gui.Oval;
import gui.Rectangle;
import java.awt.Color;

public class BallsSimulator implements Simulable {

    /* Dimensions du cadre */
    private int taillex; 
    private int tailley;
    
    private Balls b; 
    private GUISimulator gui;
    /* Rayon d'une balle */
    private int rayon;

    public BallsSimulator(int taillex, int tailley, int nb_balles) {
	this.gui = new GUISimulator(taillex, tailley, Color.WHITE);
	this.gui.setSimulable(this);
	this.b = new Balls();
	b.reInit(this.taillex, this.tailley, nb_balles, this.rayon);
	this.taillex = taillex;
	this.tailley = tailley;
	this.rayon = 15;
    }

    public Balls getBalls() {
	return this.b;
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

    public void Affiche() {
	this.gui.reset();
	this.gui.addGraphicalElement(
				     new Rectangle(0,0,
						   Color.BLACK,
						   Color.BLACK,
						   2*this.taillex + 10,
						   2*this.tailley + 10
						   ));
	for (Balle i : b.getBalles()) {
	    this.gui.addGraphicalElement(
					 new Oval((int) i.getPosition().getX(),
						  (int) i.getPosition().getY(),
						  i.getCouleur(),
						  i.getCouleur(),
						  this.rayon
						  )
				    );
	}
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
	this.b.translate(this.taillex,this.tailley, this.rayon);
	System.out.println(this.toString());
	this.Affiche();
    }
    
    @Override
    public void restart() {
	this.b.reInit(this.taillex, this.tailley, this.b.getNbBalles(), this.rayon);
	System.out.println(this.toString());
	this.Affiche();
    }
}
