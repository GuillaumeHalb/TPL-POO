import gui.GUISimulator;
import java.awt.Color;
import java.util.Scanner;
import java.util.*;


public class TestBallsSimulator {
    public static void main(String[] args) {
	System.out.println("Combien de balles souhaitez vous simuler?");
	Scanner sc = new Scanner(System.in);
	System.out.println("Veuillez saisir un entier :");
	String str = sc.nextLine();
	int nb_balles = Integer.parseInt(str);
	System.out.println("Entrez également la taille de la boite:");
	System.out.println("Largeur :");
        str = sc.nextLine();
	int largeur = Integer.parseInt(str);
	System.out.println("Hauteur :");
        str = sc.nextLine();
	int hauteur = Integer.parseInt(str);
	BallsSimulator BS = new BallsSimulator(largeur,hauteur,nb_balles);
    }
}
