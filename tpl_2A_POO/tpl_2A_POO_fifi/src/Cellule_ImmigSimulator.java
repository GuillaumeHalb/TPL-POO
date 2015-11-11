import gui.Simulable;
import gui.GUISimulator;
import gui.Rectangle;
import java.awt.Color;

public class Cellule_ImmigSimulator extends CelluleSimulator implements Simulable {

    private Cellule_Immig cells_immig;
    
    public Cellule_ImmigSimulator(int taillex, int tailley,int n) {
	super(taillex,tailley,n);
	this.cells_immig = new Cellule_Immig(taillex,tailley,n);
    }

    public Cellule_Immig getCells() {
	return this.cells_immig;
    }
    
    public void Affiche() {
	
		this.getGUI().reset();
	
		for (int i = 0; i < this.cells_immig.getLignes(); i++) {
	    	for (int j = 0; j < this.cells_immig.getColonnes(); j++) {
				int etatk = this.cells_immig.getEtatav(i,j);
				Color coul = new Color (250*etatk/this.cells_immig.getNb_etats(),250*etatk/this.cells_immig.getNb_etats(),250*etatk/this.cells_immig.getNb_etats());
				this.getGUI().addGraphicalElement(new Rectangle(10*i,10*j,coul,coul,10,10));
	    	}
		}
    }

    @Override
     public void next() {
	 	this.cells_immig.evolution();
	 	this.Affiche();
     }

        @Override
    public void restart() {
    	this.cells_immig.reInit();
    	this.Affiche();
    }
}
