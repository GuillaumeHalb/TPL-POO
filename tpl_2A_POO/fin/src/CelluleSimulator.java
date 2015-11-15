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

    /* Constructeur pour la simulation graphique */
    public CelluleSimulator(int taillex, int tailley, int n) {
    	this.gui = new GUISimulator(10*taillex, 10*tailley, Color.WHITE);
    	this.gui.setSimulable(this);
    	this.cells = new Cellule(taillex,tailley);
    	this.taillex = taillex;
    	this.tailley = tailley;
        this.nb_etats = n;
    }

    /* On récupère la grillle */
    public Cellule getCells() {
	   return this.cells;
    }
    /* On récupère la taille horizontale de la grille */
    public int gettaillex() {
	   return this.taillex;
    }
    /* On récupère la taille verticale de la grille */
    public int gettailley() {
	   return this.tailley;
    }
    /* On récupère le simulateur */
    public GUISimulator getGUI() {
	   return this.gui;
    }
    /* On récupère le nombre d'états */
    public int getNb_etats() {
       return this.nb_etats;
    }
    
    /* fonction d'affichage pour l'interface grahique 
    // On 'colorie' une case vivante */
    public void Affiche() {
	
        this.gui.reset();
    	for (int i = 0; i < this.taillex; i++) {
    	    for (int j = 0; j < this.tailley; j++) {
    		  if (this.cells.getEtatav(i,j) == 1) {
    		      this.gui.addGraphicalElement(
    						 new Rectangle(10*i,10*j,Color.BLUE,Color.BLUE,10,10));
    		  }
    	    }
    	}
    }

    /* Implémentation du bouton next, on passe du temps t au temps t+1, 
    // pûis on affiche */
    @Override
    public void next() {
	   this.cells.evolution(this.taillex,this.tailley);
	   this.Affiche();
    }
  
    /* Implémentation du bouton restart, on revient au temps 0 
    // pûis on affiche */
    @Override
    public void restart() {
    	this.cells.reInit();
    	this.Affiche();
    }
}
