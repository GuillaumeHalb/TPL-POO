import gui.Simulable;
import gui.GUISimulator;
import gui.Oval;
import java.awt.Color;

public class BallsSimulator implements Simulable {

    private Balls b; 
    private GUISimulator gui;

    public BallsSimulator() {
	this.gui = new GUISimulator(500, 500, Color.BLACK);
	this.gui.setSimulable(this);
	this.b = new Balls(5);
    }

    public Balls getBalls() {
	return this.b;
    }

    public GUISimulator getGUI() {
	return this.gui;
    }

    public void Affiche() {
	this.gui.reset();
	for (int i = 0; i < this.getBalls().getDim(); i++) {
	    this.gui.addGraphicalElement(
				    new Oval((int) this.getBalls().getBalle(i).getX(),
						  (int) this.getBalls().getBalle(i).getY(),
						  new Color(50 + 50*i, 50 + 50*i, 50 + 50*i),
						  new Color(50 + 50*i, 50 + 50*i, 50 + 50*i),
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
	this.b.translate(10,10);
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
