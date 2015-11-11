import gui.Simulable;
import gui.GUISimulator;
import gui.Rectangle;
import java.awt.Color;

public class EssaimSimulator  implements Simulable {

    private int taillex;
    private int tailley;
    private GUISimulator gui;
    private Essaim essaim;
    
    public EssaimSimulator(int taillex, int tailley,double d, Integer v_max) {
	this.gui = new GUISimulator(taillex, tailley, Color.WHITE);
	this.taillex = taillex;
    	this.tailley = tailley;
	this.essaim = new Essaim(d,v_max);
    }

    public Essaim getEssaim() {
	return this.essaim;
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
	this.getGUI().reset();
	for (Individu i : this.essaim.getAgents()) {
	    Color coul = Color.BLACK;
	    Pt pos = i.getPosition();
	    this.gui.addGraphicalElement(new Rectangle((int) pos.getX(),(int) pos.getY(),Color.BLUE,Color.BLUE,5,5));
	}
    }

    @Override
    public void next() {
	for (Individu i : this.essaim.getAgents()) {
	    i.Evolution(this.essaim);
	}
	this.Affiche();
    }
    
     @Override
    public void restart() {
	 //this.essaim.reInit();
	 this.essaim = new Essaim(6,2);
	 for(int i=1;i<10;i++){
	    double x =  (Math.random() * taillex + 1.0);
	    double y =  (Math.random() * tailley + 1.0);
	    double x1 =  (Math.random());
	    double y1 =  (Math.random()); 
	    Pt Pos = new Pt(x,y);
	    Pt dir = new Pt(x1,y1);
	    Individu ind = new Individu (1,Pos,dir);
	    this.essaim.ajouteIndividu(ind);
	}
    	this.Affiche();
    }
}
