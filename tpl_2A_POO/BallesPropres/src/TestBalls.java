public class TestBalls {
    public static void main(String[] args) {
	
	// Création de 2 balles
	Balls b = new Balls(2);
	System.out.println(b.toString());
	/* for (int i = 0; i < b.getDim(); i++) {
	   System.out.println(b.getBalle(i).toString());
	   }
	*/

	// Bougeons les balles
	System.out.println("Bougeons les balles");
	b.translate(2,3);
	System.out.println(b.toString());

	// Reinitialisation
	System.out.println("Réinitialisation");
	b.reInit();
	System.out.println(b.toString());
    }
}
