/* Classe point avec x et y double */
import java.awt.Point2D.Double;

public class Pt extends point2D.Double {
    public Pt(double x, double y) {
	super(x,y);
    }

    public Pt eg(Pt a) {
	Pt p;
	p.x = a.X;
	p.y = a.Y;
	return p;
    }

    public Pt add(Pt a, Pt b) {
	Pt p;
	p.x = a.X + b.X;
	p.y = a.Y + b.Y;
	return p;
    }

    public Pt sous(Pt a, Pt b) {
	Pt p;
	p.x = a.X - b.X;
	p.y = a.Y - b.Y;
	return p;
    }

    public Pt div(Pt a, double d) {
	Pt p;
	p.x = a.x/d;
	p.y = a.y/d;
	return p;
    }

    public Pt mult(Pt a, double d) {
	Pt p;
	return p = div(a, 1/d);
    }

    public double distance(Pt a, Pt b) {
	double d;
	d = Math.sqrt( (a.y - b.y)*(a.y - b.y) + (a.x - b.x)*(a.x - b.x) );
    }

    public void Normalisation() {
	double norme = Math.sqrt(this.x*this.x + this.y*this.y);
	this.x  = this.x/norme;
	this.y  = this.y/norme;
    }
}
