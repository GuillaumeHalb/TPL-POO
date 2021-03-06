import gui.Simulable;
import gui.GUISimulator;
import gui.Rectangle;
import java.awt.Color;

public class EssaimSimulator extends BallsSimulator  implements Simulable {

    private Essaim essaim;
    private int nb_boids;
    
    public EssaimSimulator(int taillex, int tailley,double d, Integer v_max,int nb_boids) {
	super(taillex,tailley,nb_boids);
	this.essaim = new Essaim(d,v_max);
	this.nb_boids = nb_boids;
    }

    public Essaim getEssaim() {
	return this.essaim;
    }

     
    public void Affiche() {
	this.getGUI().reset();
	this.gui.addGraphicalElement(new Rectangle(0,0,Color.RED,Color.RED,2*taillex+10,2*tailley+10));
	for (Individu i : this.essaim.getAgents()) {
	    Color coul = Color.BLACK;
	    Pt pos = i.getPosition();
	    this.gui.addGraphicalElement(new Rectangle((int) pos.getX(),(int) pos.getY(),Color.BLUE,Color.BLUE,5,5));
	    this.gui.addGraphicalElement(new Rectangle((int) (pos.getX()+5.0*i.getDirection().getX()/i.getDirection().norme()),(int) (pos.getY() + 5.0*i.getDirection().getY()/i.getDirection().norme()),Color.BLACK,Color.BLACK,2,2));
	}
    }

    @Override
    public void next() {
	for (Individu i : this.essaim.getAgents()) {
	    i.Evolution(this.essaim,taillex,tailley);
	}
	this.Affiche();
    }
    
     @Override
    public void restart() {
	 //this.essaim.reInit();
	 this.essaim = new Essaim(15,14);
	 for(int i=1;i<this.nb_boids;i++){
	    double x =  (Math.random() * taillex + 1.0);
	    double y =  (Math.random() * tailley + 1.0);
	    double bx = 1.0;
	    double by = 1.0;
	    if (Math.random() < 0.5)
		bx = -1.0;
	    if (Math.random() < 0.5)
		by = -1.0;
	    double x1 =  (Math.random()*5.0 + 1.0);
	    double y1 =  (Math.random()*5.0 + 1.0); 
	    Pt Pos = new Pt(x,y);
	    Pt dir = new Pt(bx*x1,by*y1);
	    Individu ind = new Individu (1,Pos,dir);
	    this.essaim.ajouteIndividu(ind);
	}
    	this.Affiche();
    }
}
