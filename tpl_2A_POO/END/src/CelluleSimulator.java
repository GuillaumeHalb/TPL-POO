import gui.Simulable;
import gui.GUISimulator;
import gui.Rectangle;
import java.awt.Color;

public class CelluleSimulator implements Simulable {

    private int taillex;
    private int tailley;
    private Cellule cells; 
    private GUISimulator gui;
    private int nb_etats;

    public CelluleSimulator(int taillex, int tailley, int n) {
    	this.gui = new GUISimulator(10*taillex, 10*tailley, Color.WHITE);
    	this.gui.setSimulable(this);
    	this.cells = new Cellule(taillex,tailley);
    	this.taillex = taillex;
    	this.tailley = tailley;
        this.nb_etats = n;
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

    public int getNb_etats() {
	return this.nb_etats;
    }
    

    public void Affiche() {
	this.gui.reset();
    	for (int i = 0; i < this.taillex; i++) {
    	    for (int j = 0; j < this.tailley; j++) {
		if (this.cells.getEtatav(i,j) == 1) {
		    this.gui.addGraphicalElement(
						 new Rectangle(10*i,10*j,
							       Color.BLUE,
							       Color.BLUE,
							       10,10));
		}
    	    }
    	}
    }


    @Override
    public void next() {
	this.cells.evolution(this.taillex,this.tailley);
	this.Affiche();
    }
    
    @Override
    public void restart() {
    	this.cells.reInit();
    	this.Affiche();
    }
}
