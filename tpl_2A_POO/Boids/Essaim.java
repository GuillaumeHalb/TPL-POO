public class Essaim {
    private double distance; // distance minimal entre deux individus
    private Point centre; // Centre de gravité de l'essaim
    private Vue vision; /* Angle et Distance déterminent le champ de vision
			     * On peut créer une nouvelle classe
			     */
    private Integer nombre; // Nombre d'individus

    public Essaim(double d, Point c, Truc v, Integer n) {
	this.distance = d;
	this.centre = c;
	this.vision = v;
	this.nombre = n
    }
    
    // Faire encore tous les GET
}
