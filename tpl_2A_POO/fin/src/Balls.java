import java.util.LinkedList;
import java.awt.Color;

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

    public void translate(int taillex, int tailley) {
	for (Balle i : this.balles) {
	    i.translate(taillex, tailley, this);
	}
    }

    public void reInit(Integer l, Integer h, Integer nb_balles) {
	this.balles = new LinkedList<Balle>();
	for (Integer i = 0; i < nb_balles; i++) {
	    Pt p = new Pt(Math.random()*l, Math.random()*h);
	    Pt d = new Pt(Math.random()*9 + 1, Math.random()*9 + 1);
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
