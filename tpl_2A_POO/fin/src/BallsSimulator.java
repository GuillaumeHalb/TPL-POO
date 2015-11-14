import gui.Simulable;
import gui.GUISimulator;
import gui.Oval;
import gui.Rectangle;
import java.awt.Color;

public class BallsSimulator implements Simulable {

    protected int taillex;
    protected int tailley;
    private Balls b; 
    protected GUISimulator gui;

    public BallsSimulator(int taillex, int tailley, int nb_balles) {
	this.gui = new GUISimulator(taillex, tailley, Color.WHITE);
	this.gui.setSimulable(this);
	this.b = new Balls();
	/*for (int i = 0; i < nb_balles; i++) {
	    Pt p = new Pt(Math.random()*9 + 1, Math.random()*9 + 1);
	    Color c = new Color((int) (Math.random()*250 + 1),
				(int) (Math.random()*250 + 1),
				(int) (Math.random()*250 + 1));
	    Balle a = new Balle(new Pt(1.0, 1.0), p, c);
	    b.ajouteBalle(a);
	} */

	b.reInit(this.taillex, this.tailley, nb_balles);
	this.taillex = taillex;
	this.tailley = tailley;
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
						   2*this.taillex+10,
						   2*this.tailley+10
						   ));
	for (Balle i : b.getBalles()) {
	    this.gui.addGraphicalElement(
					 new Oval((int) i.getPosition().getX(),
						  (int) i.getPosition().getY(),
						  i.getCouleur(),
						  i.getCouleur(),
						  15
						  )
				    );
	}
    }

    @Override
    public String toString() {
	String S = new String("[");
	Integer c = 1; // On met un compteur pour traiter la dernière balle
	for (Balle i : b.getBalles()) {
	    S += i.getPosition().toString() + ", ";
	}
	S += "]";
	return S;
    } 

    @Override
    public void next() {
	this.b.translate(this.taillex,this.tailley);
	System.out.println(this.toString());
	this.Affiche();
    }
    
    @Override
    public void restart() {
	this.b.reInit(this.taillex, this.tailley, this.b.getNbBalles());
	System.out.println(this.toString());
	this.Affiche();
    }
}
