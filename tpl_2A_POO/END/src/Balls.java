import java.util.LinkedList;
import java.awt.Color;
import gui.Oval;
import gui.Rectangle;
import gui.GUISimulator;

/* Ensemble de toutes les balles */

public class Balls {
    private LinkedList<Balle> balles; // Liste des balles

    public Balls() {
	this.balles = new LinkedList<Balle>();
    }

    public Integer getNbBalles() {
	return this.balles.size();
    }

    public void ajouteBalle(Balle b) {
	this.balles.add(b);
    }

    public LinkedList<Balle> getBalles() {
	return this.balles;
    }

    public void translate(int taillex, int tailley, int rayon) {
	for (Balle i : this.balles) {
	    i.translate(taillex, tailley, this,rayon);
	}
    }

    public void Affiche(int taillex, int tailley,GUISimulator gui) {
	gui.reset();
	gui.addGraphicalElement(
				     new Rectangle(0,0,
						   Color.BLACK,
						   Color.BLACK,
						   2*taillex+10,
						   2*tailley+10
						   ));
	for (Balle i : this.balles) {
	    gui.addGraphicalElement(
					 new Oval((int) i.getPosition().getX(),
						  (int) i.getPosition().getY(),
						  i.getCouleur(),
						  i.getCouleur(),
						  15
						  )
				    );
	}
    }

    // public void reInit(Integer l, Integer h, Integer nb_balles) {
    // 	this.balles = new LinkedList<Balle>();
    // 	for (Integer i = 0; i < nb_balles; i++) {
    // 	    Pt p = new Pt(Math.random()*l, Math.random()*h);
    // 	    Pt d = new Pt(Math.random()*9 + 1, Math.random()*9 + 1);
    // 	    Color c = new Color((int) (Math.random()*250 + 1),
    // 				(int) (Math.random()*250 + 1),
    // 				(int) (Math.random()*250 + 1));
    // 	    Balle a = new Balle(p, d, c);
    // 	    this.ajouteBalle(a);
    // 	}
    // }

     public void reInit(int l, int h, int nb_balles, int rayon) {
	this.balles = new LinkedList<Balle>();
	double x = 0.0;
	double y = 0.0;
	for (int i = 0; i < nb_balles; i++) {
	    x = Math.random()*l;
	    y = Math.random()*h;

	    /* Assure que les balles soient bien dans le cadre */
	    if (x < rayon)
		x += rayon;
	    else if (x > l - rayon)
		x -= rayon;

	    if (y < rayon)
		y += rayon;
	    else if (y > h - rayon)
		y -= rayon;

	    Pt p = new Pt(x, y);
	    Pt d = new Pt(Math.random()*10 + 1, Math.random()*10 + 1);
	    Color c = new Color((int) (Math.random()*250 + 1),
				(int) (Math.random()*250 + 1),
				(int) (Math.random()*250 + 1));
	    Balle a = new Balle(p, d, c);
	    this.ajouteBalle(a);
	}
    }

    @Override
    public String toString() {
	return "Cet ensemble Balls contient " 
	    + this.balles.size() + " balles";
    }
}
