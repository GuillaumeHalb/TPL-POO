public class Vue {
    private double angle;
    private double distance;

    public Vue(double a, double d) {
	this.angle = a;
	this.distance = d;
    }

    public double getAngle() {
	return this.angle;
    }
    
    public double getDistance() {
	return this.distance;
    }

    public Boolean estVu(Individu i1, Individu i2) { /* Renvoit si i1 
						      * est vu par i2 */ 
	if (i1.getPosition().getX() <= i2.getPosition().getX() + 
	    && i1.getPosition().getY() <= i2.getPosition().getY() +) {
	    return true;
	}
	else {
	    return false;
	}
    }
}
