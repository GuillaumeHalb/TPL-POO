/* Classe point avec x et y double */
import java.awt.geom.Point2D.Double;

public class Pt extends Double {
    public Pt(double x, double y) {
	super(x,y);
    }

    public Pt eg(Pt a) {
	Pt p= new Pt(0.0,0.0);;
	p.x = a.x;
	p.y = a.y;
	return p;
    }

    public Pt add(Pt a, Pt b) {
	Pt p= new Pt(0.0,0.0);;
	p.x = a.x + b.x;
	p.y = a.y + b.y;
	return p;
    }

    public Pt sous(Pt a, Pt b) {
	Pt p= new Pt(0.0,0.0);;
	p.x = a.x - b.x;
	p.y = a.y - b.y;
	return p;
    }

    public Pt div(Pt a, double d) {
	Pt p= new Pt(0.0,0.0);;
	p.x = a.x/d;
	p.y = a.y/d;
	return p;
    }

    public Pt mult(Pt a, double d) {
	Pt p= new Pt(0.0,0.0);;
	return p = div(a, 1/d);
    }

    public double distance(Pt a, Pt b) {
	double d;
	d = Math.sqrt( (a.y - b.y)*(a.y - b.y) + (a.x - b.x)*(a.x - b.x) );
	return d;
    }

    public double norme(){
	return Math.sqrt(this.x*this.x + this.y*this.y);
    }

    public void Normalisation() {
	double norme = Math.sqrt(this.x*this.x + this.y*this.y);
	this.x  = this.x/norme;
	this.y  = this.y/norme;
    }
    
    @Override
    public String toString() {
	return "(X = " + this.x + ", Y = " + this.y + ")";
    }
}
