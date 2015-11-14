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
	int hauteur =20*nb_balles;
	BallsSimulator BS = new BallsSimulator(hauteur,hauteur,nb_balles);
    }
}
