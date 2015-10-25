import gui.Simulable;
import gui.GUISimulator;
import gui.Rectangle;
import java.awt.Color;

public class CelluleSimulator implements Simulable {

    private int taillex;
    private int tailley;
    private Cellule cells; 
    private GUISimulator gui;

    public CelluleSimulator(int taillex, int tailley) {
	this.gui = new GUISimulator(10*taillex, 10*tailley, Color.WHITE);
	this.gui.setSimulable(this);
	this.cells = new Cellule(taillex,tailley);
	this.taillex = taillex;
	this.tailley = tailley;
    }

    public Cellule getCells() {
	return this.cells;
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
	
	for (int i = 0; i < this.taillex; i++) {
	    for (int j = 0; j < this.tailley; j++) {
		if (this.cells.getEtatav(i,j)) {
		    this.gui.addGraphicalElement(
						 new Rectangle(10*i,10*j,
							       Color.BLUE,
							       Color.BLUE,
							       10,10
							       )
						 );
		}
	    }
	}
    }
    // @Override
    // public String toString() {
    // 	String S = new String("[");
    // 	for (int i = 0; i < this.b.getDim() - 1; i++) {
    // 	    S += this.b.getBalle(i).toString() + ", ";
    // 	}
    // 	S += this.b.getBalle(this.b.getDim() - 1).toString() + "]";

    // 	return S;
    //} 

    @Override
    public void next() {
	this.cells.evolution(this.taillex,this.tailley);
	//System.out.println(this.toString());
	this.Affiche();
    }
    
    @Override
    public void restart() {
    	this.cells.reInit();
    	//System.out.println(this.toString());
    	this.Affiche();
    }
}
