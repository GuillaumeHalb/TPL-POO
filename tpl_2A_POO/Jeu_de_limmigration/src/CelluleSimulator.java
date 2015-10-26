import gui.Simulable;
import gui.GUISimulator;
import gui.Rectangle;
import java.awt.Color;

public class CelluleSimulator implements Simulable {

    private int taillex;
    private int tailley;
    private Cellule cells; 
    private GUISimulator gui;

    public CelluleSimulator(int taillex, int tailley,int n) {
	this.gui = new GUISimulator(10*taillex, 10*tailley, Color.WHITE);
	this.gui.setSimulable(this);
	this.cells = new Cellule(taillex,tailley,n);
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
	
	for (int i = 1; i < this.taillex-1; i++) {
	    for (int j = 1; j < this.tailley-1; j++) {
		int etatk = this.cells.getEtatav(i,j);
		Color coul = new Color (250*etatk/this.cells.getNb_etats(),250*etatk/this.cells.getNb_etats(),250*etatk/this.cells.getNb_etats());
		this.gui.addGraphicalElement(
					     new Rectangle(10*i,10*j,
							   coul,
							   coul,
							   10,10
							   )
					     );
		
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
	this.cells.evolution();
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
