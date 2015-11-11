import gui.Simulable;
import gui.GUISimulator;
import gui.Rectangle;
import java.awt.Color;

public class Cellule_SchellingSimulator extends CelluleSimulator implements Simulable {

    private Cellule_Schelling cells_schelling;

    public Cellule_SchellingSimulator(int taillex, int tailley, int n, int k) {
		super(taillex,tailley,n);
		this.cells_schelling = new Cellule_Schelling(taillex,tailley,n,k);
    }

    public Cellule_Schelling getCells() {
	return this.cells_schelling;
    }

    public void Affiche() {
	
		this.getGUI().reset();
	
		for (int i = 0; i < this.cells_schelling.getLignes(); i++) {
	    	for (int j = 0; j < this.cells_schelling.getColonnes(); j++) {
				int etatk = this.cells_schelling.getEtatav(i,j);
				//chaque maison est repéré par un entier, définissant une couleur unique
				Color coul = new Color (255, 255, 255);
				if (etatk != 0) {
					coul = new Color ((40*etatk) % 255,(255-40*etatk) % 255,(255-40*etatk) % 255);
				} 
				this.getGUI().addGraphicalElement(new Rectangle(10*i,10*j,coul,coul,10,10));
	    	}
		}
    }

    @Override
     public void next() {
	 	this.cells_schelling.evolution();
	 	this.Affiche();
     }

        @Override
    public void restart() {
    	this.cells_schelling.reInit();
    	this.Affiche();
    }
}