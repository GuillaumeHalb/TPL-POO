import gui.Simulable;
import gui.GUISimulator;
import gui.Oval;
import gui.Rectangle;
import java.awt.Color;

public class BallsSimulator implements Simulable {

    private int taillex;
    private int tailley;
    private Balls b; 
    private GUISimulator gui;

    public BallsSimulator(int taillex, int tailley, int nb_balles) {
	this.gui = new GUISimulator(taillex, tailley, Color.WHITE);
	this.gui.setSimulable(this);
	//int nb_balles = (int) (Math.random() * 9 + 5); //nb_aléatoire entre 5 et 10
	this.b = new Balls(nb_balles);
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
	for (int i = 0; i < this.getBalls().getDim(); i++) {
	    this.gui.addGraphicalElement(
					 new Oval((int) this.getBalls().getBalle(i).getX(),
						  (int) this.getBalls().getBalle(i).getY(),
						  this.b.getColor(i),
						  this.b.getColor(i),
						  15
						  )
				    );
	}
    }

    @Override
    public String toString() {
	String S = new String("[");
	for (int i = 0; i < this.b.getDim() - 1; i++) {
	    S += this.b.getBalle(i).toString() + ", ";
	}
	S += this.b.getBalle(this.b.getDim() - 1).toString() + "]";

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
	this.b.reInit();
	System.out.println(this.toString());
	this.Affiche();
    }
}
