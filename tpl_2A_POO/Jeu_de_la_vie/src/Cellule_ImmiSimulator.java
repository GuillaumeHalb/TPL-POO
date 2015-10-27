import gui.Simulable;
import gui.GUISimulator;
import gui.Rectangle;
import java.awt.Color;

public class Cellule_ImmiSimulator extends CelluleSimulator implements Simulable {

    private Cellule_Immi cells_immi;
    
    public Cellule_ImmiSimulator(int taillex, int tailley,int n) {
	super(taillex,tailley,n);
	this.cells_immi = new Cellule_Immi(taillex,tailley,n);
    }

    public Cellule_Immi getCells() {
	return this.cells_immi;
    }
    
    public void Affiche() {
	
	this.getGUI().reset();
	
	for (int i = 1; i < this.cells_immi.getLignes()-1; i++) {
	    for (int j = 1; j < this.cells_immi.getColonnes()-1; j++) {
		int etatk = this.cells_immi.getEtatav_immi(i,j);
		Color coul = new Color (250*etatk/this.cells_immi.getNb_etats(),250*etatk/this.cells_immi.getNb_etats(),250*etatk/this.cells_immi.getNb_etats());
		this.getGUI().addGraphicalElement(
					     new Rectangle(10*i,10*j,
							   coul,
							   coul,
							   10,10
							   )
					     );
		
	    }
	}
    }

    @Override
     public void next() {
	 this.cells_immi.evolution();
	 this.Affiche();
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

}
